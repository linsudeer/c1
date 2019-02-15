package com.czht.smartpark.tbweb.modular.bean;

import com.czht.smartpark.tbweb.modular.bean.page.Page;

import java.util.Date;

/**
 * 统计记录查询条件
 */
public class PassBean extends Page {

    private Integer deptId;

    private Long userId;

    private Integer userGroup;

    private Integer areaId;

    private Integer direct;

    private String starttime;

    private String endtime;

    // 新增通行记录
    private Long recordId;
    private String passtime;
    private String remark;

    public Integer getDeptId() {
        if(super.getDeptId() != null && super.getDeptId() > 0){
            return super.getDeptId();
        }else {
            return deptId;
        }

    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Integer userGroup) {
        this.userGroup = userGroup;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
}
