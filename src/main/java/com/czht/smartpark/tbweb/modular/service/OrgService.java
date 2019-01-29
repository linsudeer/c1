package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.tree.TreeNode;

import java.util.List;

public interface OrgService {

    /**
     * 查找包含在岗人数的部门树
     * @param deptPid 父部门Id
     * @return
     */
    List<TreeNode> getOnWorkOrgTree(Integer deptPid);
}
