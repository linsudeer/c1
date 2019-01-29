package com.czht.smartpark.tbweb.modular.constant;

public enum  OnWorkTypeEnum {

    ONWORK(1, "在岗"), TEMPWORK(2, "临时离岗"), OFFWORK(3, "不在岗");

    private Integer type;

    private String name;

    OnWorkTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
