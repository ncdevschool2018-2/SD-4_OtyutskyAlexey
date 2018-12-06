package com.netcracker.edu.fapi.service.Impl;

import com.netcracker.edu.fapi.model.UserAccountViewModel;
import com.netcracker.edu.fapi.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service("userAccountDataService")
public class UserAccountDataServiceImpl implements UserAccountDataService, UserDetailsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<UserAccountViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel[] UserAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/user-accounts/", UserAccountViewModel[].class);
        return UserAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(UserAccountViewModelResponse);
    }

    @Override
    public UserAccountViewModel getUserAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel UserAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/user-accounts/" + Long.toString(id), UserAccountViewModel.class);
        return UserAccountViewModelResponse;
    }

    @Override
    public UserAccountViewModel saveUserAccount(UserAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user-accounts", account, UserAccountViewModel.class).getBody();
    }

    @Override
    public UserAccountViewModel findByLogin(String name) {
        RestTemplate template = new RestTemplate();
        UserAccountViewModel user = template.getForObject(backendServerUrl +
                "/api/user-accounts/get/" + name, UserAccountViewModel.class);

        return user;
    }

    @Override
    public void deleteUserAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/user-accounts/" + id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountViewModel user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), getAuthority(user));
    }

    private Set getAuthority(UserAccountViewModel user) {
        Set auth = new HashSet();
        auth.add(new SimpleGrantedAuthority(user.isAdmin() ? "Admin" : "User"));
        return auth;
    }

}
