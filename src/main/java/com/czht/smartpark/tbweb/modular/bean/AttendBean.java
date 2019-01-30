package com.czht.smartpark.tbweb.modular.bean;

import com.czht.smartpark.tbweb.modular.bean.page.Page;

public class AttendBean extends Page {

    private Integer deptId;

    private Integer userId;

    private String startDate;

    private String endDate;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
