package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.context.support.FastDFSClient;
import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.dmo.PassRecord;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.mapper.PassRecordMapper;
import com.czht.smartpark.tbweb.modular.service.PassService;
import com.czht.smartpark.tbweb.modular.service.UserService;
import com.czht.smartpark.tbweb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PassServiceImpl implements PassService {

    @Autowired
    private PassRecordMapper passRecordMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<PassDTO> getPassRecords(PassBean query) {

        return passRecordMapper.getPassRecords(query);
    }

    @Override
    public Integer getPassCount(PassBean query) {
        return passRecordMapper.getPassCount(query);
    }

    @Override
    public PassRecord addPassRecord(PassBean bean) {
        // 用户名，公司，部门，区域名字，部门名字，头像，操作日志
        PassRecord record = new PassRecord();

        UserDTO user = userService.getSimpleUserInfo(bean.getUserId().intValue());

        record.setUserName(user.getUserName());
        record.setUserSex(user.getUserSex());
        record.setUserGroup(user.getUserGroup());
        record.setUserType(user.getUserType());
        record.setDeptId(user.getDeptId());
        record.setDeptParentId(user.getDeptPid());
        record.setDeviceAreaId(bean.getAreaId());
        record.setUserId(bean.getUserId());
        record.setDeviceDirection(bean.getDirect());

        try {
            record.setPassDatetime(DateUtil.parseDate(bean.getPasstime(), "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //照片，因为证件照是 byte[] 所以这里需要存储并返回地址
        FastDFSClient fastdfs = new FastDFSClient();
        byte[] img = user.getIdPic();
        if(img != null && img.length>0){
            String url = fastdfs.uploadFile(img, "jpg");
            record.setFaceFdfsId(url);
            record.setFullFdfsId(url);
        }
        passRecordMapper.insert(record);

        // 操作日志 TODO

        return record;
    }

    @Override
    public PassRecord updatePassRecord(PassBean bean) {
        Long recordId = bean.getRecordId();

        PassRecord record = passRecordMapper.getPassRecordById(recordId);
        // 更新只能更新用户
        record.setUserId(bean.getUserId());
        UserDTO user = userService.getSimpleUserInfo(bean.getUserId().intValue());
        record.setUserName(user.getUserName());
        record.setUserType(user.getUserType());
        record.setUserGroup(user.getUserGroup());
        record.setUserSex(user.getUserSex());
        record.setDeptParentId(user.getDeptPid());
        record.setDeptId(user.getDeptId());
        passRecordMapper.updateByPrimaryKey(record);

        // 操作日志 TODO

        return record;
    }

    @Override
    public void deletePassRecord(Long recordId) {

        passRecordMapper.deleteByPrimaryKey(recordId);

        // 删除图片
        FastDFSClient fast = new FastDFSClient();
        PassRecord record = passRecordMapper.getPassRecordById(recordId);
        fast.deleteFile(record.getFaceFdfsId());
        fast.deleteFile(record.getFullFdfsId());
    }
}
