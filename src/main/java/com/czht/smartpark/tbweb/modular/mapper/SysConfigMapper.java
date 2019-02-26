package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.SysConfig;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysConfigMapper extends Mapper<SysConfig> {
    List<SysConfig> getConfigs(String fdfs_client);
}