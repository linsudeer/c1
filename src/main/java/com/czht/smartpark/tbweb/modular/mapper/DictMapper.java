package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.Dict;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DictMapper extends Mapper<Dict> {

    /**
     * 查找字典值
     * @param key
     * @param limit
     * @return
     */
    List<CodeDTO> getDics(@Param("key") String key, @Param("value") String value);

    /**
     * 从配置文件中查找
     * @param configName
     * @return
     */
    CodeDTO getConfig (@Param("configName") String configName);

}