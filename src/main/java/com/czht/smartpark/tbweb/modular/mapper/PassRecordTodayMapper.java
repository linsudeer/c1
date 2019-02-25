package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.PassRecordToday;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface PassRecordTodayMapper extends Mapper<PassRecordToday> {

    /**
     * 更新
     * @param passRecordId 通行记录表的ID
     * @return
     */
    PassRecordToday getByPassRecordId(@Param("passRecordId") Long passRecordId);


    /**
     * 删除
     * @param passRecordId 通行记录表的ID
     */
    void deleteByPassRecordId(@Param("passRecordId") Long passRecordId);
}