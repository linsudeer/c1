package com.czht.smartpark.tbweb.modular.bean.page;

import com.czht.smartpark.tbweb.modular.bean.PermissonBean;
import com.czht.smartpark.tbweb.modular.constant.Constant;

public class Page extends PermissonBean {
    /**
     * 页码
     */
    private Integer start = 1;

    /**
     * 页大小
     */
    private Integer length = 20;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length>Constant.DEFAULT_LIMIT?Constant.DEFAULT_LIMIT:length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}
