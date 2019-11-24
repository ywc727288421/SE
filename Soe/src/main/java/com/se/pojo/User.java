package com.se.pojo;

/**
 * @author DeepBlue
 * @date 2019/10/31  15:09
 */
public class User {
    private long id;
    private String identity;
    private String username;
    private String password;
    private String password2;
    private String email;


    public User() {
    }

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String identity, String username, String password, String password2, String email) {
        this.identity = identity;
        this.username = username;
        this.password = password;
        this.password2 = password2;
        this.email = email;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public User(String identity, String username, String password) {
        this.identity = identity;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
