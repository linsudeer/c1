package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.dmo.PassRecord;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PassRecordMapper extends Mapper<PassRecord>{

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
     * 查找一条记录
     * @param recordId
     * @return
     */
    PassRecord getPassRecordById(@Param("recordId") Long recordId);
}