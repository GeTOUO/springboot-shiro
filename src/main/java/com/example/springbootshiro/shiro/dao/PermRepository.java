package com.example.springbootshiro.shiro.dao;

import com.example.springbootshiro.shiro.domain.SysPermission;
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
@CacheConfig(cacheNames = "permission")
public class PermRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Cacheable(key = "#p0")
    public List<SysPermission> findAllByUsername(String username) {
        String sql = "SELECT SYS_PERMISSION.* FROM SYS_PERMISSION " +
                "INNER JOIN SYS_ROLE_PERMISSION ON SYS_ROLE_PERMISSION.SYS_PERMISSION_UUID = SYS_PERMISSION.UUID " +
                "INNER JOIN SYS_ROLE ON SYS_ROLE.UUID = SYS_ROLE_PERMISSION.SYS_ROLE_UUID " +
                "INNER JOIN SYS_ROLE_USER ON SYS_ROLE.UUID = SYS_ROLE_USER.SYS_ROLE_UUID " +
                "INNER JOIN USER_INFO ON SYS_ROLE_USER.USER_INFO_UUID = USER_INFO.UUID " +
                "WHERE USER_INFO.USER_NAME = :USER_NAME";
        Map<String, String> map = new HashMap<>(1);
        map.put("USER_NAME", username);
        return this.jdbcTemplate.query(sql, map, rse -> {
            List<SysPermission> sysPermissions = new ArrayList<>();
            SysPermission sysPermission = null;
            while (rse.next()) {
                sysPermission = new SysPermission();
                sysPermission.setUuid(rse.getString("UUID"));
                sysPermission.setName(rse.getString("NAME"));
                sysPermissions.add(sysPermission);
            }
            return sysPermissions;
        });
    }
}
