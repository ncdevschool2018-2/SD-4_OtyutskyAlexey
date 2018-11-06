package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataServiceInterface {
    List<UserAccountViewModel> getAll();
    UserAccountViewModel getUserAccountById(Long id);
    UserAccountViewModel saveUserAccount(UserAccountViewModel account);
    void deleteUserAccount(Long id);
}
