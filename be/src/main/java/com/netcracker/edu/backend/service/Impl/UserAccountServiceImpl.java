package com.netcracker.edu.backend.service.Impl;

import com.netcracker.edu.backend.entity.UserAccount;
import com.netcracker.edu.backend.repository.UserAccountRepository;
import com.netcracker.edu.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository repository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount saveUserAccount(UserAccount account) {
        return repository.save(account);
    }

    @Override
    public Optional<UserAccount> getUserAccountById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<UserAccount> getAllUserAccounts() {
        return repository.findAll();
    }

    @Override
    public void deleteUserAccount(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserAccount> getUserAccountByLogin(String login) {
        return repository.findByLogin(login);
    }
}
