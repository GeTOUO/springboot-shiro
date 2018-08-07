package com.example.springbootshiro.shiro.domain;

import java.util.List;

/**
 * 角色
 * 一个角色可拥有多种权限
 * @author carzy
 * @date 2018/08/03
 */
public class SysRole extends Identity {

    private String role;
    private String description;
    /**
     * 一个用户拥有多个权限
     */
    private List<SysPermission> permissions;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
