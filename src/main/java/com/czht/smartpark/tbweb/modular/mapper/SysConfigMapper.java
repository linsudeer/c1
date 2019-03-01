package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.SysConfig;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysConfigMapper extends Mapper<SysConfig> {

    List<SysConfig> getConfigs(@Param("configName") String configName);
    List<SysConfig> getConfigsByNames(@Param("configNames") String[] configNames);
}