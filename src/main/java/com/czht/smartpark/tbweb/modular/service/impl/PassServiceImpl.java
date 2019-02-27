package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.context.cache.MapCache;
import com.czht.smartpark.tbweb.context.support.FastDFSClient;
import com.czht.smartpark.tbweb.context.support.HttpServletRequestHolder;
import com.czht.smartpark.tbweb.modular.bean.PassBean;
import com.czht.smartpark.tbweb.modular.constant.AuthProperties;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dmo.AttendanceRecord;
import com.czht.smartpark.tbweb.modular.dmo.PassRecord;
import com.czht.smartpark.tbweb.modular.dmo.PassRecordToday;
import com.czht.smartpark.tbweb.modular.dmo.SysOplog;
import com.czht.smartpark.tbweb.modular.dto.PassDTO;
import com.czht.smartpark.tbweb.modular.dto.ScreenDTO;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.mapper.AttendanceRecordMapper;
import com.czht.smartpark.tbweb.modular.mapper.PassRecordMapper;
import com.czht.smartpark.tbweb.modular.mapper.PassRecordTodayMapper;
import com.czht.smartpark.tbweb.modular.service.PassService;
import com.czht.smartpark.tbweb.modular.service.SysOptlogService;
import com.czht.smartpark.tbweb.modular.service.UserService;
import com.czht.smartpark.tbweb.util.BeanUtil;
import com.czht.smartpark.tbweb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PassServiceImpl implements PassService {

    @Autowired
    private PassRecordMapper passRecordMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private SysOptlogService logService;

    @Autowired
    private PassRecordTodayMapper passTodayMapper;

    @Autowired
    private AttendanceRecordMapper attendMapper;

    private FastDFSClient fastDFSClient = new FastDFSClient();

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
        record.setUserSex(user.getUserSex());
        record.setFilterFlag(0);
        record.setGroupId(user.getUserGroup());
        record.setWayOfPass(0);
        record.setRegisterFlag(1);

        try {
            record.setPassDatetime(DateUtil.parseDate(bean.getPasstime(), "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //照片，因为证件照是 byte[] 所以这里需要存储并返回地址
        byte[] img = user.getIdPic();
        if(img != null && img.length>0){
            String url = fastDFSClient.uploadFile(img, "jpg");
            record.setFaceFdfsId(url);
            record.setFullFdfsId(url);
        }
        passRecordMapper.insert(record);

        //today表
        passTodayMapper.insert(BeanUtil.convert(record, PassRecordToday.class));

        //重新生成当天考勤
        String attendDate = DateUtil.format(bean.getPasstime(), "yyyy-MM-dd");
        List<AttendanceRecord> attends = attendMapper.getAttend(attendDate, bean.getUserId());
        if(attends!=null && attends.size()>0){
            for ( AttendanceRecord attend: attends) {
                attendMapper.delete(attend);
            }
            attendMapper.generalAttend(attendDate, bean.getUserId());
        }


        // admin 不开启日志
        UserDTO sessionUser = HttpServletRequestHolder.getSessionInfo();
        if(sessionUser != null && !AuthProperties.ROLE_ADMIN.equals(sessionUser.getDataRole())){
            // 操作日志
            StringBuilder sb = new StringBuilder();
            sb.append(DateUtil.getDate("yyyy年MM月dd日 HH时mm分ss秒")).append(HttpServletRequestHolder.getNickName()).append("新增记录").append(bean.getRemark()==null?".":(",原因："+bean.getRemark()+"。"));
            logService.add(createLog(Constant.PASS_LOG_TYPE_ADD, Constant.PASS_LOG_MODULE, bean.getUserId().intValue(), record.getPassRecordId(), sb.toString()));
        }




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

        PassRecordToday passRecordToday = passTodayMapper.getByPassRecordId(record.getPassRecordId());
        if(passRecordToday != null){
            passRecordToday.setUserId(record.getUserId());
            passRecordToday.setUserName(user.getUserName());
            passRecordToday.setUserType(user.getUserType());
            passRecordToday.setUserGroup(user.getUserGroup());
            passRecordToday.setUserSex(user.getUserSex());
            passRecordToday.setDeptParentId(user.getDeptPid());
            passRecordToday.setDeptId(user.getDeptId());
        }
        passTodayMapper.updateByPrimaryKey(passRecordToday);


        //重新生成当天考勤
        String attendDate = DateUtil.format(record.getPassDatetime(), "yyyy-MM-dd");
        List<AttendanceRecord> attends = attendMapper.getAttend(attendDate, bean.getUserId());
        if(attends!=null && attends.size()>0){
            for ( AttendanceRecord attend: attends) {
                attendMapper.delete(attend);
            }
            attendMapper.generalAttend(attendDate, bean.getUserId());
        }

        // admin 不开启日志
        UserDTO sessionUser = HttpServletRequestHolder.getSessionInfo();
        if(sessionUser != null && !AuthProperties.ROLE_ADMIN.equals(sessionUser.getDataRole())){
            // 操作日志
            StringBuilder sb = new StringBuilder();
            sb.append(DateUtil.getDate("yyyy年MM月dd日HH时mm分ss秒,")).append(HttpServletRequestHolder.getNickName()).append("修改了记录。");
            logService.add(createLog(Constant.PASS_LOG_TYPE_EDIT, Constant.PASS_LOG_MODULE, bean.getUserId().intValue(), record.getPassRecordId(), sb.toString()));

        }

        return wrapPassRecord(record.getPassRecordId());
    }

    @Override
    public void deletePassRecord(Long recordId) {
        if(recordId == null) return;

        PassRecord record = passRecordMapper.selectByPrimaryKey(recordId);

        // 删除图片
        if(record != null){
            fastDFSClient.deleteFile(record.getFaceFdfsId());
            fastDFSClient.deleteFile(record.getFullFdfsId());
        }
        passRecordMapper.deleteByPrimaryKey(recordId);
        //删除today表
        passTodayMapper.deleteByPassRecordId(recordId);

        // admin 不开启日志
        UserDTO sessionUser = HttpServletRequestHolder.getSessionInfo();
        if(sessionUser != null && !AuthProperties.ROLE_ADMIN.equals(sessionUser.getDataRole())){
            // 操作日志
            StringBuilder sb = new StringBuilder();
            sb.append(DateUtil.getDate("yyyy年MM月dd日 HH时mm分ss秒")).append(HttpServletRequestHolder.getNickName()).append("删除记录");
            logService.add(createLog(Constant.PASS_LOG_TYPE_ADD, Constant.PASS_LOG_MODULE, recordId.intValue(), record.getPassRecordId(), sb.toString()));
        }

    }

    @Override
    public Map<String, Object> screenHearBeat(Integer areaId) {
        return passRecordMapper.screenHearBeat(areaId);
    }

    @Override
    public ScreenDTO getScreenData(Long passRecordId, Integer areaId) {

        ScreenDTO dto = new ScreenDTO();
        int allTotalCnt = 0, allSelfCnt = 0, allOtherCnt = 0;//所有总数
        int todayTotalCnt = 0, todaySeflCnt = 0, todayOtherCnt = 0;//今日总数
        //查询统计数据
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        Date cutDate = calendar.getTime();//截止日期 为当天的零点

        //从缓存中读取今天之前的数据
        MapCache mapCache = MapCache.getInstance();
        allSelfCnt = (int) (mapCache.get(Constant.SCREEN_ALL_SELF_CNT)==null?0:mapCache.get(Constant.SCREEN_ALL_SELF_CNT));
        if(allSelfCnt==0) {
            Example example1 = new Example(PassRecord.class);
            //本单位在cutDate时间之前的总数
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andCondition("pass_datetime<", cutDate);
            criteria1.andCondition("user_group>", 0);
            criteria1.andCondition("device_direction=", 1);
            if(areaId!=null){
                criteria1.andCondition("device_area_id=", areaId);
            }

            allSelfCnt = passRecordMapper.selectCountByExample(example1);
            //保存到缓存, 计算过期时间
            mapCache.set(Constant.SCREEN_ALL_SELF_CNT, allSelfCnt, getExpired());
        }
        //访客在cutDate时间之前的总数
        allOtherCnt = (int) (mapCache.get(Constant.SCREEN_ALL_OTHER_CNT)==null?0:mapCache.get(Constant.SCREEN_ALL_OTHER_CNT));
        if(allOtherCnt==0) {
            Example example2 = new Example(PassRecord.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andCondition("pass_datetime<", cutDate);
            criteria2.andCondition("user_group=", 0);
            criteria2.andCondition("device_direction=", 1);
            if(areaId != null){
                criteria2.andCondition("device_area_id=", areaId);
            }
            allOtherCnt = passRecordMapper.selectCountByExample(example2);
            //保存到缓存, 计算过期时间
            mapCache.set(Constant.SCREEN_ALL_OTHER_CNT, allOtherCnt, getExpired());
        }
        allTotalCnt = allSelfCnt+allOtherCnt;

        //今日本单位在cutDate时间之前的总数
        Example example3 = new Example(PassRecordToday.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andCondition("user_group>", 0);
        criteria3.andCondition("device_direction=", 1);
        if(areaId!=null){
            criteria3.andCondition("device_area_id=", areaId);
        }

        todaySeflCnt = passTodayMapper.selectCountByExample(example3);

        //今日访客在cutDate时间之前的总数
        Example example4 = new Example(PassRecordToday.class);
        Example.Criteria criteria4 = example4.createCriteria();
        criteria4.andCondition("pass_datetime>=", cutDate);
        criteria4.andCondition("user_group=", 0);
        criteria4.andCondition("device_direction=", 1);
        if(areaId!=null){
            criteria4.andCondition("device_area_id=", areaId);
        }

        todayOtherCnt = passTodayMapper.selectCountByExample(example4);
        todayTotalCnt = todaySeflCnt + todayOtherCnt;//总人数

        //填充数据
        dto.setAllTotalCnt(allTotalCnt+todayTotalCnt);
        dto.setAllSelfCnt(allSelfCnt+todaySeflCnt);
        dto.setAllOtherCnt(allOtherCnt+todayOtherCnt);
        dto.setTodayTotalCnt(todayTotalCnt);
        dto.setTodaySelfCnt(todaySeflCnt);
        dto.setTodayOtherCnt(todayOtherCnt);

        //这里是可配置的一些选项
        dto.setAreaName("战备执勤区");
        dto.setTitle("智能人脸识别考勤系统");
        dto.setCmpName("本单位");
        //这里需要查询具体数据
        PassDTO passDTO = passRecordMapper.getPassRecordById(passRecordId);
        dto.setUserName(passDTO.getUserName());
        if(passDTO == null || passDTO.getUserId()==0){// 访客是通行的照片
            dto.setPicUrl(passDTO.getFaceFdfsId());
        }else {//是证件照片
            UserDTO user = userService.getSimpleUserInfo(passDTO.getUserId().intValue());
            dto.setIdPic(user.getIdPic());
        }

        dto.setPassDateTime(passDTO.getPassDatetime());
        dto.setDirect(passDTO.getDirect());
        return dto;
    }

    // 计算过期时间，当前时间到第二天0点的时间差
    private static long getExpired() {
        Calendar calendar = Calendar.getInstance();
        Date curTime = calendar.getTime();
        calendar.add(Calendar.DATE,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date cutTime = calendar.getTime();

        return (cutTime.getTime()-curTime.getTime())/1000;
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

       return passRecordMapper.getPassRecordById(recordId);
    }
}
