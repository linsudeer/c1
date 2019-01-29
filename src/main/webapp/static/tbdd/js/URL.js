var DOMAIN = 'http://localhost:8089';
var HTML_PATH = '/static/tbdd/html/';

// 通行记录类
var SERVER_URL = {
    login_valil: DOMAIN+"/loginValil",//登陆校验
    logout:DOMAIN+"/logout",//退出
    checklogin: DOMAIN+"/checklogin",//校验登陆
    pass_list: DOMAIN+"/pass/list", // 通行记录

    user_simple: DOMAIN+"/user/simple",// 用户基本信息

    code_dept: DOMAIN+"/code/dept",// 部门字典
    code_user: DOMAIN+"/code/user",//用户字典
    code_area: DOMAIN+"/code/area",// 区域字典
    code_usergroup: DOMAIN+"/code/user_group",//用户分组字典
    code_direct: DOMAIN+"/code/device_direction",//设备方向字典

    area_list: DOMAIN+"/area/list",//区域列表
    org_onWorkTree: DOMAIN+"/org/onWorkTree",//在岗人员树

    current_24h: DOMAIN+"/current/onwork/24h",//24小时在岗人员统计
    current_typegroup: DOMAIN+"/current/count/typeGroup",//根据在岗类型分组统计、
    current_areagroup: DOMAIN+"/current/count/areaGroup",//不同区域在岗情况
    current_pass: DOMAIN+"/current/pass",//最新的记录

    attend_statistics:DOMAIN+"/attend/statistics",//综合考勤
    attend_history: DOMAIN+"/attend/history",//个人历史考勤

}