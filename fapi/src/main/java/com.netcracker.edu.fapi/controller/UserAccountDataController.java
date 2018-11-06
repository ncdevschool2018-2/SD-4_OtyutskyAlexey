package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UserAccountViewModel;
import com.netcracker.edu.fapi.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ua")
public class UserAccountDataController {

    @Autowired
    private UserAccountDataService userAccountDataService;

    @RequestMapping
    public ResponseEntity<List<UserAccountViewModel>> getAllUserAccounts() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> saveUserAccount(@RequestBody UserAccountViewModel userAccount /*todo server validation*/) {
        if (userAccount != null) {
            return ResponseEntity.ok(userAccountDataService.saveUserAccount(userAccount));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserAccount(@PathVariable String id) {
        userAccountDataService.deleteUserAccount(Long.valueOf(id));
    }

}