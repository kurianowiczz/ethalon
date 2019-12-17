package com.netcracker.edu.fapi.models;

public class User {

    private Long id;
    private String username;
    private String password;
    private String role;
    private double cash;


    public User(Long id, String username, String password, String role, double cash) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.cash = cash;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", cash=" + cash +
                '}';
    }
}
