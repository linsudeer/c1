package com.czht.smartpark.tbweb.modular.bean;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 权限有关的bean
 */
public class PermissonBean {

    /**
     * 部门父ID
     */
    private Integer deptId;
    private Integer deptPid;

    /**
     * 用户ID
     */
    private Integer userId;

    public Integer getDeptPid() {
        return deptPid;
    }

    public void setDeptPid(Integer deptPid) {
        this.deptPid = deptPid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
