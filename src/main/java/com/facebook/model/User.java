package com.facebook.model;

public class User {
    private String role;
    private String password;
    private String email;

    public User(String email, String password, String role) {
        this.role = role;
        this.password = password;
        this.email = email;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

