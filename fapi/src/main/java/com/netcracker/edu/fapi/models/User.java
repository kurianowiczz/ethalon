package com.netcracker.edu.fapi.models;

public class User {

    private Long id;
    private String userName;
    private String password;
    private String role;
    private double cash;


    public User(Long id, String userName, String password, String role, double cash) {
        this.id = id;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", cash=" + cash +
                '}';
    }
}
