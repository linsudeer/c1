package com.czht.smartpark.tbweb.modular.service;

import com.czht.smartpark.tbweb.modular.dmo.Area;

import java.util.List;

public interface AreaService {

    /**
     * 查找所有区域，升序排列
     * @return
     */
    List<Area> getAreas();
}
