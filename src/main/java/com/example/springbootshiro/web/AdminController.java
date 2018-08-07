package com.example.springbootshiro.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @author carzy
 * @date 2018/08/03
 */
@RestController
public class AdminController {

    @GetMapping("/admin/config")
    public String adminConfig() {
        return "admin";
    }

    @GetMapping("/admin/get")
    @RequiresPermissions({"get"})
    public String getPermission() {
        return "permission";
    }

}
