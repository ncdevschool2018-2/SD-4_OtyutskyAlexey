package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_AC;
    private Boolean isAdmin;
    private Long id_BA;
    private String login;
    private String email;
    private String password;

    public UserAccount() {
    }

    public UserAccount(Boolean isAdmin, Long id_BA, String login, String email, String password) {
        this.isAdmin = isAdmin;
        this.id_BA = id_BA;
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Long getId_AC() {
        return id_AC;
    }

    public void setId_AC(Long id_AC) {
        this.id_AC = id_AC;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Long getId_BA() {
        return id_BA;
    }

    public void setId_BA(Long id_BA) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (id_AC != null ? !id_AC.equals(that.id_AC) : that.id_AC != null) return false;
        if (isAdmin != null ? !isAdmin.equals(that.isAdmin) : that.isAdmin != null) return false;
        if (id_BA != null ? !id_BA.equals(that.id_BA) : that.id_BA != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = id_AC != null ? id_AC.hashCode() : 0;
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        result = 31 * result + (id_BA != null ? id_BA.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id_AC=" + id_AC +
                ", isAdmin=" + isAdmin +
                ", id_BA=" + id_BA +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}