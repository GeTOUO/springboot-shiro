package com.example.springbootshiro.base.service;


import com.example.springbootshiro.base.dao.UserRepository;
import com.example.springbootshiro.shiro.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author carzy
 * @date 2018/08/03
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 模拟查询返回用户信息
     * @param username
     * @return
     */
    public UserInfo findUserByName(String username){
        UserInfo user = new UserInfo();
        return this.userRepository.getByUsername(username);
    }

}
