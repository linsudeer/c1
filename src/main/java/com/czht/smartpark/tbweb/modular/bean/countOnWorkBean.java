package com.czht.smartpark.tbweb.modular.bean;

public class countOnWorkBean extends PermissonBean{

    private Integer areaId;

    private Integer deptId;
    private Integer deptPid;
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


    public Integer getType() {
        return type;
    }

    @Override
    public Integer getDeptId() {

        return deptId;
    }

    @Override
    public Integer getDeptPid() {
        return (super.getDeptPid() != null && super.getDeptPid()>0)?super.getDeptPid():deptPid;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public void setDeptPid(Integer deptPid) {
        this.deptPid = deptPid;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
