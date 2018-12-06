package com.netcracker.edu.fapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {
    private long id_AC;
    private boolean admin;
    private long id_BA;
    private String login;
    private String email;
    private String password;

    public UserAccountViewModel() {
    }

    public UserAccountViewModel(long id_AC, boolean admin, long id_BA, String login, String email, String password) {
        this.id_AC = id_AC;
        this.admin = admin;
        this.id_BA = id_BA;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public long getId_BA() {
        return id_BA;
    }

    public void setId_BA(long id_BA) {
        this.id_BA = id_BA;
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
