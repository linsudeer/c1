package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.dto.UserDTO;

public interface UserService {

    /**
     * 校验登陆
     * @param username 登陆名
     * @param password 登陆密码
     * @param deptPid 对应的单位ID
     * @return
     */
    UserDTO loginVail(String username, String password, Integer deptPid);

    /**
     * 查找基本的用户信息
     * @param userId
     * @return
     */
    UserDTO getSimpleUserInfo(Integer userId);
}
