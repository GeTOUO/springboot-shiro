package com.example.springbootshiro.shiro.domain;

import java.util.List;

/**
 * @author carzy
 * @date 2018/08/03
 */
public class UserInfo extends Identity {

    private String username;
    private String password;
    /**
     * 一个用户可有拥有多种角色
     */
    private List<SysRole> roles;

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

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
