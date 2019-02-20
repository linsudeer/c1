package com.czht.smartpark.tbweb.modular.dto;

/**
 * 在岗统计实体类
 */
public class OnWrokCntDTO {

    /**
     * id，可以是区域id,部门id,人员类型标识等
     * 规定 在岗人员类型：1， 临时离岗人员类型：2，不在岗人员类型：3
     */
    private Integer id;

    /**
     * 统计分组的名字，可以是区域名字，部门名字，人员类型等
     */
    private String name;

    /**
     * 如果按部门查找，所查找的部门
     */
    private String deptName;

    private Integer deptId;

    /**
     * 数量
     */
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
