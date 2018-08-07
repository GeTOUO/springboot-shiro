package com.example.springbootshiro.shiro.dao;

import com.example.springbootshiro.shiro.domain.SysRole;
import com.example.springbootshiro.shiro.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author carzy
 * @date 2018/08/06
 */
@Repository
@CacheConfig(cacheNames = "role")
public class RoleRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Cacheable(key = "#p0")
    public List<SysRole> findRolesByUsername(String username) {
        String sql = "SELECT SYS_ROLE.* FROM SYS_ROLE " +
                "INNER JOIN SYS_ROLE_USER ON SYS_ROLE.UUID = SYS_ROLE_USER.SYS_ROLE_UUID " +
                "INNER JOIN USER_INFO ON SYS_ROLE_USER.USER_INFO_UUID = USER_INFO.UUID " +
                "WHERE USER_INFO.USER_NAME = :USER_NAME ";
        Map<String, String> map = new HashMap<>(1);
        map.put("USER_NAME", username);
        return this.jdbcTemplate.query(sql, map, resultSet -> {
            List<SysRole> sysRoles = new ArrayList<>();
            SysRole sysRole = null;
            while (resultSet.next()) {
                sysRole = new SysRole();
                sysRole.setUuid(resultSet.getString("UUID"));
                sysRole.setRole(resultSet.getString("ROLE"));
                sysRole.setDescription(resultSet.getString("DESCRIPTION"));
                sysRoles.add(sysRole);
            }
            return sysRoles;
        });
    }
}
