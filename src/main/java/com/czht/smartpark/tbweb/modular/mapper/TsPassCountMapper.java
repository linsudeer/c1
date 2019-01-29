package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.TsPassCount;

public interface TsPassCountMapper {
    int deleteByPrimaryKey(Long recordId);

    int insert(TsPassCount record);

    int insertSelective(TsPassCount record);

    TsPassCount selectByPrimaryKey(Long recordId);

    int updateByPrimaryKeySelective(TsPassCount record);

    int updateByPrimaryKey(TsPassCount record);
}