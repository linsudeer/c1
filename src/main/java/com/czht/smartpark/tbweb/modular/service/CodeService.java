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

    CodeDTO getArea(Integer areaId);

    /**
     * 查找所有部门
     * @param deptName
     * @param limit
     * @return
     */
    List<CodeDTO> getDepts(String deptName, Integer deptPid, Integer limit);

    CodeDTO getDept(Integer deptPid);

    /**
     * 查找字典值
     * @param key
     * @param limit
     * @return
     */
    CodeDTO getDict(String key, String value);

    List<CodeDTO> getDicts(String key);

    /**
     * 从配置文件中查 tb_sys_config
     * @param configName
     * @return
     */
    CodeDTO getConfig(String configName);
}

