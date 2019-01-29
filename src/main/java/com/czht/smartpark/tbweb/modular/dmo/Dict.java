package com.czht.smartpark.tbweb.modular.dmo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_code")
public class Dict {
    @Id
    @Column(name = "code_id")
    private Integer codeId;

    @Column(name = "codetype_id")
    private Integer codetypeId;

    private Integer code;

    private String name;

    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 1可用，0不可用
     */
    @Column(name = "in_use")
    private Integer inUse;

    private String remark;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * @return code_id
     */
    public Integer getCodeId() {
        return codeId;
    }

    /**
     * @param codeId
     */
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    /**
     * @return codetype_id
     */
    public Integer getCodetypeId() {
        return codetypeId;
    }

    /**
     * @param codetypeId
     */
    public void setCodetypeId(Integer codetypeId) {
        this.codetypeId = codetypeId;
    }

    /**
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sort_no
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * @param sortNo
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取1可用，0不可用
     *
     * @return in_use - 1可用，0不可用
     */
    public Integer getInUse() {
        return inUse;
    }

    /**
     * 设置1可用，0不可用
     *
     * @param inUse 1可用，0不可用
     */
    public void setInUse(Integer inUse) {
        this.inUse = inUse;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
}