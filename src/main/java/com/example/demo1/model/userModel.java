package com.example.demo1.model;

import java.sql.Timestamp;

public class userModel extends AbstractModel <userModel>{

    private String userName;
    private String password;
    private long roleId;
    private String fullName;
    private String email;
    private int status;
    private roleModel role;

    public roleModel getRole() {
        return role;
    }

    public void setRole(roleModel role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
