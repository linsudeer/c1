package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.Department;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import com.czht.smartpark.tbweb.modular.dto.DeptDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DepartmentMapper extends Mapper<Department> {

    List<Department> listOrgs(@Param("deptPid") Integer deptPid);

    /**
     * 查找部门树，包含在岗人数
     * @param deptPid
     * @return
     */
    List<DeptDTO> getOnWorkOrgTree(@Param("deptPid") Integer deptPid);

    /**
     * 部门字典
     * @param key
     * @param deptPid
     * @param limit
     * @return
     */
    List<CodeDTO> getDeptsForCode(@Param("key") String key, @Param("deptPid") Integer deptPid, @Param("limit") Integer limit);
}