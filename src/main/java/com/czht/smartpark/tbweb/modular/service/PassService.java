package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;

import java.util.List;

public interface PassService {

    /**
     * 查询通行记录
     * @param query
     * @return
     */
    List<PassDTO> getPassRecords(PassBean query);

    /**
     * 查找通行记录条数
     * @param query
     * @return
     */
    Integer getPassCount(PassBean query);

    /**
     * 新增记录
     * @param bean
     */
    void addPassRecord(PassBean bean);

    /**
     * 编辑记录
     * @param bean
     */
    void updatePassRecord(PassBean bean);

    /**
     * 删除
     * @param recordId
     */
    void deletePassRecord(Long recordId);
}