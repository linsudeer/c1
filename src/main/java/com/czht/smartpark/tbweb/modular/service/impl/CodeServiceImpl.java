package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dmo.Area;
import com.czht.smartpark.tbweb.modular.dmo.Department;
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
    public List<CodeDTO> getUsers(String username, String deptId, Integer limit) {
        if(deptId != null){
            String[] deptIds = deptId.split(",");
            if(deptIds.length==1){
                return userMapper.getUsersForCode(username, Integer.parseInt(deptIds[0]), limit);
            }else if(deptIds.length>1){
                List<CodeDTO> list = userMapper.getUsersForCodeBydeptIds(username, deptIds, limit);
                return list;
            }else {
                return userMapper.getUsersForCode(username, 0, limit);
            }
        }else {
            return userMapper.getUsersForCode(username, 0, limit);
        }
    }

    @Override
    public List<CodeDTO> getAreas(String key, Integer limit) {
        return areaMapper.getAreasForCode(key, null, limit);
    }

    @Override
    public CodeDTO getArea(Integer areaId) {
        Area area = areaMapper.selectByPrimaryKey(areaId);
        if(area != null){
            CodeDTO code = new CodeDTO();
            code.setId(area.getAreaId());
            code.setText(area.getAreaName());
            return code;
        }
        return null;
    }

    @Override
    public List<CodeDTO> getDepts(String key, Integer deptPid, Integer limit) {
        return deptMapper.getDeptsForCode(key, deptPid, limit);
    }

    @Override
    public CodeDTO getDept(Integer deptPid) {
        Department dept = deptMapper.selectByPrimaryKey(deptPid);
        if(dept != null){
            CodeDTO code = new CodeDTO();
            code.setId(dept.getDeptId());
            code.setText(dept.getDeptName());
            return code;
        }
        return null;
    }

    @Override
    public CodeDTO getDict(String key, String value) {
        List<CodeDTO> list = dictMapper.getDics(key, value);
        if(list !=  null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<CodeDTO> getDicts(String key) {
        return dictMapper.getDics(key, null);
    }

    @Override
    public CodeDTO getConfig(String configName) {
        return dictMapper.getConfig(configName);
    }

}
