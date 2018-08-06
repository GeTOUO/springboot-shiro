package com.example.springbootshiro.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carzy
 * @date 2018/08/03
 */
@RestController
public class AdminController {

    @RequestMapping("/admin/config")
    public String adminConfig() {
        return "admin";
    }

}
