package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.model.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataService {
    List<UserAccountViewModel> getAll();
    UserAccountViewModel getUserAccountById(Long id);
    UserAccountViewModel saveUserAccount(UserAccountViewModel account);
    UserAccountViewModel findByLogin(String name);
    void deleteUserAccount(Long id);
}
