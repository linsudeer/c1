package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.mapper.PassRecordMapper;
import com.czht.smartpark.tbweb.modular.service.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassServiceImpl implements PassService {

    @Autowired
    private PassRecordMapper passRecordMapper;

    @Override
    public List<PassDTO> getPassRecords(PassBean query) {

        return passRecordMapper.getPassRecords(query);
    }

    @Override
    public Integer getPassCount(PassBean query) {
        return passRecordMapper.getPassCount(query);
    }
}
