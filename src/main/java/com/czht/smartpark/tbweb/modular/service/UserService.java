package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.dmo.User;
import com.czht.smartpark.tbweb.modular.dto.ThirdOaUserDTO;
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

    User getById(Integer userId);

    /**
     * 根据token查帮系统登陆的用户
     * @param token
     * @return
     */
    ThirdOaUserDTO getThirdOaUser(String token);

    UserDTO getByName(String username);

    boolean checkOldPwd(Long userId, String oldPwd);

    void modifyPwd(Long userId, String pwd);
}
