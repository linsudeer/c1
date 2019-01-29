package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.dto.CodeDTO;

import java.util.List;

/**
 * 字典类
 */
public interface CodeService {

    /**
     * 查找用户字典
     * @param username
     * @return
     */
    List<CodeDTO> getUsers(String username, Integer deptId, Integer limit);

    /**
     * 查找所有区域
     * @param key
     * @param limit
     * @return
     */
    List<CodeDTO> getAreas(String key, Integer limit);

    /**
     * 查找所有部门
     * @param deptName
     * @param limit
     * @return
     */
    List<CodeDTO> getDepts(String deptName, Integer deptPid, Integer limit);

    /**
     * 查找字典值
     * @param key
     * @param limit
     * @return
     */
    List<CodeDTO> getDicts(String key);
}

