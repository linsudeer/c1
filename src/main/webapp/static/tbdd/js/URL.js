var DOMAIN = 'http://localhost:8089';
// var DOMAIN = 'http://192.168.10.201:8080/tbweb';
var HTML_PATH = '/static/tbdd/html/';

// 通行记录类
var SERVER_URL = {
    login_valil: DOMAIN+"/loginValil",//登陆校验
    logout:DOMAIN+"/logout",//退出
    checklogin: DOMAIN+"/checklogin",//校验登陆
    pass_list: DOMAIN+"/pass/list", // 通行记录
    pass_edit: DOMAIN +"/pass/edit",//编辑通行记录
    pass_add: DOMAIN +"/pass/add",//新增通行记录
    pass_del: DOMAIN +"/pass/del",//删除通行记录

    user_simple: DOMAIN+"/user/simple",// 用户基本信息

    code_dept: DOMAIN+"/code/dept",// 部门字典
    code_user: DOMAIN+"/code/user",//用户字典
    code_area: DOMAIN+"/code/area",// 区域字典
    code_usergroup: DOMAIN+"/code/user_group",//用户分组字典
    code_direct: DOMAIN+"/code/device_direction",//设备方向字典

    area_list: DOMAIN+"/area/list",//区域列表
    org_onWorkTree: DOMAIN+"/org/onWorkTree",//在岗人员树
    org_onWorkList: DOMAIN+"/org/onWorkList",

    current_24h: DOMAIN+"/current/onwork/24h",//24小时在岗人员统计
    current_typegroup: DOMAIN+"/current/count/typeGroup",//根据在岗类型分组统计、
    current_areagroup: DOMAIN+"/current/count/areaGroup",//不同区域在岗情况
    current_pass: DOMAIN+"/current/pass",//最新的记录
    current_count_attend: DOMAIN+"/current/count/attendGroup",//考勤人数
    current_pass_attend: DOMAIN+"/current/attendPass",//考勤人数

    attend_statistics:DOMAIN+"/attend/statistics",//综合考勤
    attend_history: DOMAIN+"/attend/history",//个人历史考勤
    attend_modifyStatus: DOMAIN+"/attend/modifyStatus",//修改考勤状态

    attend_causal_review: DOMAIN+"/attend/updateAttendCausa",//修正考勤异常情况

    screen_heartbeat:DOMAIN+"/pass/screenHearBeat",//心跳
    screen_data:DOMAIN+"/pass/getScreenData",//心跳

    user_modifyPwd:DOMAIN+"/user/modifyPwd",//修改密码

}