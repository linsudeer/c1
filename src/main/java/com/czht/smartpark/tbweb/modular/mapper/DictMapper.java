package com.czht.smartpark.tbweb.modular.mapper;

import com.czht.smartpark.tbweb.modular.dmo.Dict;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DictMapper extends Mapper<Dict> {

    /**
     * 查找字典值
     * @param key
     * @param limit
     * @return
     */
    List<CodeDTO> getDics(String key);
}