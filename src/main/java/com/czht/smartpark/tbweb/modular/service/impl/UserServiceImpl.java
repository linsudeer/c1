package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.mapper.UserMapper;
import com.czht.smartpark.tbweb.modular.service.UserService;
import com.czht.smartpark.tbweb.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO loginVail(String username, String password, Integer deptPid) {

        return userMapper.loginVail(username, MD5Util.encrypt(password), deptPid);
    }

    @Override
    public UserDTO getSimpleUserInfo(Integer userId) {
        if(userId == null) return null;
        return userMapper.getSimpleUserInfo(userId);
    }
}
