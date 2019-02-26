package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.User;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    /**
     * 登陆校验
     * @param username
     * @param encrypt
     * @param deptPid
     * @return
     */
    UserDTO loginVail(@Param("username") String username, @Param("password") String password, @Param("deptPid") Integer deptPid);

    /**
     * 查找用户的字典集合
     * @param username
     * @return
     */
    List<CodeDTO> getUsersForCode(@Param("username") String username, @Param("deptId") Integer deptId, @Param("limit") Integer limit);

    /**
     * 查找用户的字典集合
     * @param username
     * @return
     */
    List<CodeDTO> getUsersForCodeBydeptIds(@Param("username") String username, @Param("deptIds") String[] deptIds, @Param("limit") Integer limit);

    /**
     * 根据用户Id查找基本信息
     * @param userId
     * @return
     */
    UserDTO getSimpleUserInfo(@Param("userId") Integer userId);
}