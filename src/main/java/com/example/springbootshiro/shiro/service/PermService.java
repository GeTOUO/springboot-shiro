package com.example.springbootshiro.shiro.service;

import com.example.springbootshiro.shiro.dao.PermRepository;
import com.example.springbootshiro.shiro.dao.RoleRepository;
import com.example.springbootshiro.shiro.domain.SysPermission;
import com.example.springbootshiro.shiro.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Service
public class PermService {

    private PermRepository permRepository;

    @Autowired
    public void setPermRepository(PermRepository permRepository) {
        this.permRepository = permRepository;
    }

    /**
     * 查询某个用户的角色
     * @param username
     */
    public List<SysPermission> findAllByUsername(String username){
        return this.permRepository.findAllByUsername(username);
    }

}
