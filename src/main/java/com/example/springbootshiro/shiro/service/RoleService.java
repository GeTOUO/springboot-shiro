package com.example.springbootshiro.shiro.service;

import com.example.springbootshiro.shiro.dao.RoleRepository;
import com.example.springbootshiro.shiro.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * 查询某个用户的角色
     * @param username
     */
    public List<SysRole> findUserByName(String username){
        return this.roleRepository.findRolesByUsername(username);
    }
}
