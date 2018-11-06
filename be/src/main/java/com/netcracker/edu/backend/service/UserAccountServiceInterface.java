package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserAccount;

import java.util.Optional;

public interface UserAccountServiceInterface {

    UserAccount saveUserAccount(UserAccount account);
    Optional<UserAccount> getUserAccountById(Long id);
    Iterable<UserAccount> getAllUserAccounts();
    void deleteUserAccount(Long id);

}
