package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import com.czht.smartpark.tbweb.modular.mapper.AreaMapper;
import com.czht.smartpark.tbweb.modular.mapper.DepartmentMapper;
import com.czht.smartpark.tbweb.modular.mapper.DictMapper;
import com.czht.smartpark.tbweb.modular.mapper.UserMapper;
import com.czht.smartpark.tbweb.modular.service.CodeService;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private DepartmentMapper deptMapper;

    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<CodeDTO> getUsers(String username, Integer deptId, Integer limit) {
        return userMapper.getUsersForCode(username, deptId, limit);
    }

    @Override
    public List<CodeDTO> getAreas(String key, Integer limit) {
        return areaMapper.getAreasForCode(key, limit);
    }

    @Override
    public List<CodeDTO> getDepts(String key, Integer deptPid, Integer limit) {
        return deptMapper.getDeptsForCode(key, deptPid, limit);
    }

    @Override
    public List<CodeDTO> getDicts(String key) {
        return dictMapper.getDics(key);
    }
}
