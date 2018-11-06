package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserAccountViewModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserAccountDataService implements UserAccountDataServiceInterface {

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
        return null;
    }

    @Override
    public UserAccountViewModel saveUserAccount(UserAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/User-accounts", account, UserAccountViewModel.class).getBody();
    }

    @Override
    public void deleteUserAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/User-accounts/" + id);
    }
}
