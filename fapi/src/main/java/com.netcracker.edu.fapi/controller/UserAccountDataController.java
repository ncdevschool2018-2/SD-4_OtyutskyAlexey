package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.model.UserAccountViewModel;
import com.netcracker.edu.fapi.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-accounts")
public class UserAccountDataController {

    @Autowired
    private UserAccountDataService userAccountDataService;

    private BCryptPasswordEncoder encoder;

    @RequestMapping
    public ResponseEntity<List<UserAccountViewModel>> getAllUserAccounts() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

    @RequestMapping(value = "/{id_AC}", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserAccountById(@PathVariable("id_AC") String id){
        return ResponseEntity.ok(userAccountDataService.getUserAccountById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/get/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserByLogin(@PathVariable(name = "login") String login) {
        return ResponseEntity.ok(userAccountDataService.findByLogin(login));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> saveUserAccount(@RequestBody UserAccountViewModel userAccount /*todo server validation*/) {
        if (userAccount != null) {
            return ResponseEntity.ok(userAccountDataService.saveUserAccount(userAccount));
        }
        return null;
    }

    @RequestMapping(value = "/{id_AC}", method = RequestMethod.DELETE)
    public void deleteUserAccount(@PathVariable String id) {
        userAccountDataService.deleteUserAccount(Long.valueOf(id));
    }

}