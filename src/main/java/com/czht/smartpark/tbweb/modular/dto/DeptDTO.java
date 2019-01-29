package com.czht.smartpark.tbweb.modular.dto;

public class DeptDTO {

    /**
     * id
     */
    private Integer deptId;

    /**
     * pid
     */
    private Integer parentId;

    /**
     * name
     */
    private String deptName;

    /**
     * type
     */
    private Integer type;

    /**
     * 负责人id
     */
    private Integer leaderId;

    /**
     * 在岗人数
     */
    private Integer onWorkCnt;

    public DeptDTO(){}

    public DeptDTO(Integer deptId, Integer parentId, String deptName) {
        this.deptId = deptId;
        this.parentId = parentId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getOnWorkCnt() {
        return onWorkCnt;
    }

    public void setOnWorkCnt(Integer onWorkCnt) {
        this.onWorkCnt = onWorkCnt;
    }
}
