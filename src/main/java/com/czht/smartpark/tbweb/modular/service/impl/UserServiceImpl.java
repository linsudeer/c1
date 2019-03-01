package com.czht.smartpark.tbweb.modular.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.czht.smartpark.tbweb.modular.constant.SysConfigEnum;
import com.czht.smartpark.tbweb.modular.dmo.User;
import com.czht.smartpark.tbweb.modular.dto.ThirdOaUserDTO;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.mapper.UserMapper;
import com.czht.smartpark.tbweb.modular.service.UserService;
import com.czht.smartpark.tbweb.util.HttpClientUtil;
import com.czht.smartpark.tbweb.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    @Override
    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public ThirdOaUserDTO getThirdOaUser(String token) {
        String url = SysConfigEnum.THIRD_OA_SSO_URL.getValue();
        try {
            String result = HttpClientUtil.doGet(url+"/"+token);
            if(StringUtils.isNotBlank(result)){
                ThirdOaUserDTO dto = JSONObject.parseObject(result, ThirdOaUserDTO.class);
                return dto;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return new ThirdOaUserDTO("李松林");
    }

    @Override
    public UserDTO getByName(String username) {
        return userMapper.getSimpleUserByName(username);
    }

    @Override
    public boolean checkOldPwd(Long userId, String oldPwd){
        User user = userMapper.checkOldPwd(userId, MD5Util.encrypt(oldPwd));
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public void modifyPwd(Long userId, String pwd){
        userMapper.modifyPwd(userId, MD5Util.encrypt(pwd));
    }
}
