package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.dmo.PassRecord;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.dto.ScreenDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    PassDTO addPassRecord(PassBean bean);

    /**
     * 编辑记录
     * @param bean
     */
    PassDTO updatePassRecord(PassBean bean);

    /**
     * 删除
     * @param recordId
     */
    void deletePassRecord(Long recordId);

    /**
     * 通行记录心跳检查
     * @param areaId
     * @return
     */
    Map<String, Object> screenHearBeat(Integer areaId);

    /**
     * 投屏数据
     * @param areaId
     * @param limit
     * @return
     */
    ScreenDTO getScreenData(Long passRecordId, Integer areaId);
}
