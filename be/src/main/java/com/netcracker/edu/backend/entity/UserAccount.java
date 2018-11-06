package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_AC;
    private Long id_BA;
    private Long id_ROLE;
    private String login;
    private String email;
    private String password;

    public UserAccount(){

    }

    public UserAccount(long id_BA, long id_ROLE, String login, String email, String password) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (id_AC != that.id_AC) return false;
        if (id_BA != that.id_BA) return false;
        if (id_ROLE != that.id_ROLE) return false;
        if (!login.equals(that.login)) return false;
        if (!email.equals(that.email)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = (int) (id_AC ^ (id_AC >>> 32));
        result = 31 * result + (int) (id_BA ^ (id_BA >>> 32));
        result = 31 * result + (int) (id_ROLE ^ (id_ROLE >>> 32));
        result = 31 * result + login.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id_AC=" + id_AC +
                ", id_BA=" + id_BA +
                ", id_ROLE=" + id_ROLE +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}