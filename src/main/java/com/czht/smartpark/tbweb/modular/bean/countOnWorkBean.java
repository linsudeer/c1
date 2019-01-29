package com.czht.smartpark.tbweb.modular.bean;

public class countOnWorkBean extends PermissonBean {

    private Integer areaId;

    private Integer deptId;

    /**
     * 类型1-在岗 2-临时离岗 3-不在岗
     */
    private Integer type;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
