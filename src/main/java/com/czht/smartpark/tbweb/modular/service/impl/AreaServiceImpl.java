package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.dmo.Area;
import com.czht.smartpark.tbweb.modular.mapper.AreaMapper;
import com.czht.smartpark.tbweb.modular.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAreas() {
        return areaMapper.getAreas();
    }
}
