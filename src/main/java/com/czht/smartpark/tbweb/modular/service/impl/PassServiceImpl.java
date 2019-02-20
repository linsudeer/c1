package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.context.support.FastDFSClient;
import com.czht.smartpark.tbweb.context.support.HttpServletRequestHolder;
import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dmo.PassRecord;
import com.czht.smartpark.tbweb.modular.dmo.SysOplog;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.mapper.PassRecordMapper;
import com.czht.smartpark.tbweb.modular.service.CodeService;
import com.czht.smartpark.tbweb.modular.service.PassService;
import com.czht.smartpark.tbweb.modular.service.SysOptlogService;
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

    @Autowired
    private CodeService codeService;

    @Autowired
    private SysOptlogService logService;

    @Override
    public List<PassDTO> getPassRecords(PassBean query) {

        return passRecordMapper.getPassRecords(query);
    }

    @Override
    public Integer getPassCount(PassBean query) {
        return passRecordMapper.getPassCount(query);
    }

    @Override
    public PassDTO addPassRecord(PassBean bean) {
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
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.getDate("yyyy年MM月dd日 HH时mm分ss秒")).append(HttpServletRequestHolder.getNickName()).append("新增记录").append(bean.getRemark()==null?".":(",原因："+bean.getRemark()+"。"));
        logService.add(createLog(Constant.PASS_LOG_TYPE_ADD, Constant.PASS_LOG_MODULE, bean.getUserId().intValue(), record.getPassRecordId(), sb.toString()));


        return wrapPassRecord(record.getPassRecordId());
    }

    @Override
    public PassDTO updatePassRecord(PassBean bean) {
        Long recordId = bean.getRecordId();

        PassRecord record = passRecordMapper.selectByPrimaryKey(recordId);
        // 更新只能更新用户
        record.setUserId(bean.getUserId());
        UserDTO user = userService.getSimpleUserInfo(bean.getUserId().intValue());
        if(user.getUserId().intValue()==bean.getOldUserId().intValue()){ return null;}// 这里没有变化
        record.setUserName(user.getUserName());
        record.setUserType(user.getUserType());
        record.setUserGroup(user.getUserGroup());
        record.setUserSex(user.getUserSex());
        record.setDeptParentId(user.getDeptPid());
        record.setDeptId(user.getDeptId());
        passRecordMapper.updateByPrimaryKey(record);

        // 操作日志 TODO
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.getDate("yyyy年MM月dd日HH时mm分ss秒,")).append(HttpServletRequestHolder.getNickName()).append("修改了记录。");
        logService.add(createLog(Constant.PASS_LOG_TYPE_EDIT, Constant.PASS_LOG_MODULE, bean.getUserId().intValue(), record.getPassRecordId(), sb.toString()));

        return wrapPassRecord(record.getPassRecordId());
    }

    @Override
    public void deletePassRecord(Long recordId) {
        if(recordId == null) return;

        passRecordMapper.deleteByPrimaryKey(recordId);

        // 删除图片
        FastDFSClient fast = new FastDFSClient();
        PassRecord record = passRecordMapper.selectByPrimaryKey(recordId);
        fast.deleteFile(record.getFaceFdfsId());
        fast.deleteFile(record.getFullFdfsId());

        // 操作日志 TODO
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.getDate("yyyy年MM月dd日 HH时mm分ss秒")).append(HttpServletRequestHolder.getNickName()).append("删除记录");
        logService.add(createLog(Constant.PASS_LOG_TYPE_ADD, Constant.PASS_LOG_MODULE, recordId.intValue(), record.getPassRecordId(), sb.toString()));
    }

    private SysOplog createLog(Integer type, String moudle, Integer userId, Long recordId, String content){
        SysOplog log = new SysOplog();
        String username = HttpServletRequestHolder.getNickName();
        log.setOptTime(DateUtil.getDate());
        log.setUserId(userId);
        log.setClientIpaddress(HttpServletRequestHolder.getIp());
        log.setModuleName(moudle);
        StringBuilder sb = new StringBuilder();
        log.setOptContent(content);
        log.setPassRecordId(recordId);
        log.setOptType(type+"");
        log.setUserName(username);
        return log;
    }

    /**
     * 获得包括字典值的record
     * @param recordId
     * @return
     */
    private PassDTO wrapPassRecord(Long recordId){
       /* PassDTO pass = new PassDTO();
        pass.setPassRecordId(record.getPassRecordId());
        pass.setPassDatetime(record.getPassDatetime());
        pass.setUserId(record.getUserId());
        pass.setDeviceId(record.getDeviceId());
        pass.setDeviceType(record.getDeviceType());
        pass.setDeviceDirection(record.getDeviceDirection());

        if(record.getDeviceDirection() != null){
            CodeDTO directCode = codeService.getDict("PASS_DIRECTION", record.getDeviceDirection().toString());
            if(directCode != null){
                pass.setDirect(directCode.getText());
            }
        }


        pass.setDeviceName(record.getDeviceName());
        pass.setDeviceAreaId(record.getDeviceAreaId());
        if(record.getDeviceAreaId() != null){
            CodeDTO areaCode = codeService.getArea(record.getDeviceAreaId());
            if(areaCode != null){
                pass.setDeviceAreaName(areaCode.getText());
            }
        }

        pass.setUserName(record.getUserName());
        pass.setUserSex(record.getUserSex());
        pass.setUserType(record.getUserType());
        pass.setUserGroup(record.getUserGroup());
        if(record.getUserGroup() != null){
            CodeDTO userGroupCode = codeService.getDict("USER_GROUP", record.getUserGroup().toString());
            if(userGroupCode != null){
                pass.setUserGroupName(userGroupCode.getText());
            }
        }
        pass.setGroupId(record.getGroupId());
        pass.setDeptId(record.getDeptId());
        if(record.getDeptId() != null){
            CodeDTO deptCode = codeService.getDept(record.getDeptId());
            if(deptCode != null){
                pass.setDeptName(deptCode.getText());
            }
        }
        pass.setDeptParentId(record.getDeptParentId());

        CodeDTO fdfsCode = codeService.getConfig("fdfs_url");
        if(fdfsCode != null){
            pass.setFullFdfsId(fdfsCode.getText()+"/"+record.getFullFdfsId());
            pass.setFaceFdfsId(fdfsCode.getText()+"/"+record.getFaceFdfsId());
        }

        return pass;*/

       return passRecordMapper.getPassRecordById(recordId);
    }
}
