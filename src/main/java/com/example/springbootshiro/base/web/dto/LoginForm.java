package com.example.springbootshiro.base.web.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author carzy
 * @date 2018/08/06
 */
public class LoginForm {

    private String username;
    private String password;

    @NotBlank(message = "用户名不可为空")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "密码不能为空")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
