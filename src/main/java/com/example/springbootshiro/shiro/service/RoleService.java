package com.example.springbootshiro.shiro.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Service
public class RoleService {

    /**
     * 模拟根据用户uuid查询返回用户的所有角色
     */
    public Set<String> getRolesByUserId(Long uid){
        Set<String> roles = new HashSet<>();
        roles.add("js");
        roles.add("java");
        roles.add("cpp");
        return roles;
    }

}
