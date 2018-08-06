package com.example.springbootshiro.shiro.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Service
public class PermService {

    /**
     * 模拟根据用户uuid查询返回用户的所有权限
     */
    public Set<String> getPermsByUserId(Long uid){
        Set<String> perms = new HashSet<>();
        //js程序员的权限
        perms.add("html:edit");
        //c++程序员的权限
        perms.add("hardware:debug");
        //java程序员的权限
        perms.add("mvn:install");
        perms.add("mvn:clean");
        perms.add("mvn:test");
        return perms;
    }

}
