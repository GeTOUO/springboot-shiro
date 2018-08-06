package com.example.springbootshiro.base.dao;

import com.example.springbootshiro.shiro.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author carzy
 * @date 2018/08/06
 */
@Repository
public class UserRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserInfo getByUsername(String username) {
        String sql = "SELECT * FROM `USER_INFO` WHERE USER_NAME = :USER_NAME";
        Map<String, String> map = new HashMap<>(1);
        map.put("USER_NAME", username);
        return this.jdbcTemplate.query(sql, map, rse -> {
            UserInfo userInfo = null;
            if (rse.next()) {
                userInfo = new UserInfo();
                userInfo.setUuid(rse.getString("UUID"));
                userInfo.setUsername(rse.getString("USER_NAME"));
                userInfo.setPassword(rse.getString("PASSWORD"));
            }
            return userInfo;
        });
    }
}
