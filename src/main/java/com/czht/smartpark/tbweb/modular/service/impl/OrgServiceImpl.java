package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.dto.DeptDTO;
import com.czht.smartpark.tbweb.modular.mapper.DepartmentMapper;
import com.czht.smartpark.tbweb.modular.service.OrgService;
import com.czht.smartpark.tbweb.modular.tree.TreeNode;
import com.czht.smartpark.tbweb.modular.tree.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private DepartmentMapper deptMapper;

    @Override
    public List<TreeNode> getOnWorkOrgTree(Integer deptPid) {
        List<DeptDTO> depts = deptMapper.getOnWorkOrgTree(deptPid);
        return TreeUtil.treeWrap(depts);
    }
}
