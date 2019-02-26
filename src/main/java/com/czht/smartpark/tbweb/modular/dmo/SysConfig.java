package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_config")
public class SysConfig {
    @Id
    @Column(name = "config_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer configId;

    /**
     * 参数类型
     */
    @Column(name = "config_type")
    private String configType;

    /**
     * 参数所属类型
     */
    private String typename;

    /**
     * 配置参数名
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 配置的值
     */
    private String value;

    /**
     * 是否可编辑
     */
    private Integer editable;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * @return config_id
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * @param configId
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取参数类型
     *
     * @return config_type - 参数类型
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 设置参数类型
     *
     * @param configType 参数类型
     */
    public void setConfigType(String configType) {
        this.configType = configType;
    }

    /**
     * 获取参数所属类型
     *
     * @return typename - 参数所属类型
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置参数所属类型
     *
     * @param typename 参数所属类型
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }

    /**
     * 获取配置参数名
     *
     * @return config_name - 配置参数名
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置配置参数名
     *
     * @param configName 配置参数名
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 获取配置的值
     *
     * @return value - 配置的值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置配置的值
     *
     * @param value 配置的值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取是否可编辑
     *
     * @return editable - 是否可编辑
     */
    public Integer getEditable() {
        return editable;
    }

    /**
     * 设置是否可编辑
     *
     * @param editable 是否可编辑
     */
    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取更新时间
     *
     * @return updated - 更新时间
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间
     *
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}