package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {
    private long id_AC;
    private long id_BA;
    private long id_ROLE;
    private String login;
    private String email;
    private String password;

    public UserAccountViewModel() {
    }

    public UserAccountViewModel(long id_AC, long id_BA, long id_ROLE, String login, String email, String password) {
        this.id_AC = id_AC;
        this.id_BA = id_BA;
        this.id_ROLE = id_ROLE;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public long getId_AC() {
        return id_AC;
    }

    public void setId_AC(long id_AC) {
        this.id_AC = id_AC;
    }

    public long getId_BA() {
        return id_BA;
    }

    public void setId_BA(long id_BA) {
        this.id_BA = id_BA;
    }

    public long getId_ROLE() {
        return id_ROLE;
    }

    public void setId_ROLE(long id_ROLE) {
        this.id_ROLE = id_ROLE;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
