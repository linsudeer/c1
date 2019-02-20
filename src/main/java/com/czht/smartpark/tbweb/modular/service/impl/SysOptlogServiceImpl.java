package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.dmo.SysOplog;
import com.czht.smartpark.tbweb.modular.mapper.SysOplogMapper;
import com.czht.smartpark.tbweb.modular.service.SysOptlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysOptlogServiceImpl implements SysOptlogService {

    @Autowired
    private SysOplogMapper sysOplogMapper;

    @Override
    public void add(SysOplog log) {
        sysOplogMapper.insert(log);
    }
}
