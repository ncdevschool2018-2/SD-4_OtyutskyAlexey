package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserAccount;
import com.netcracker.edu.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user-accounts")
public class UserAccountController {

    private UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping(value = "/{id_AC}", method = RequestMethod.GET)
    public ResponseEntity<UserAccount> getUserAccountById(@PathVariable(name = "id_AC") Long id) {
        Optional<UserAccount> UserAccount = userAccountService.getUserAccountById(id);
        if (UserAccount.isPresent()) {
            return ResponseEntity.ok(UserAccount.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserAccount> getAllUserAccounts() {
        return userAccountService.getAllUserAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserAccount saveUserAccount(@RequestBody UserAccount account) {
        return userAccountService.saveUserAccount(account);
    }

    @RequestMapping(value = "/{id_AC}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserAccount(@PathVariable(name = "id_AC") Long id) {
        userAccountService.deleteUserAccount(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/get/{login}" , method = RequestMethod.GET)
    public ResponseEntity<UserAccount> getUserAccountByLogin(@PathVariable String login){
        Optional<UserAccount> user = userAccountService.getUserAccountByLogin(login);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}