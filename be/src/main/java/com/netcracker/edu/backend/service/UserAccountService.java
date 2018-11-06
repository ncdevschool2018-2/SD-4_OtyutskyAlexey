package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserAccount;
import com.netcracker.edu.backend.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAccountService implements UserAccountServiceInterface {

    private UserAccountRepository repository;

    @Autowired
    public UserAccountService(UserAccountRepository repository) {
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
}
