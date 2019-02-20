package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.Area;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AreaMapper extends Mapper<Area> {

    /**
     * 查找所有区域，升序排序
     * @return
     */
    List<Area> getAreas();

    /**
     * 查找区域，字典用
     * @return
     */
    List<CodeDTO> getAreasForCode(@Param("key") String key, @Param("value") String value, @Param("limit") Integer limit);
}