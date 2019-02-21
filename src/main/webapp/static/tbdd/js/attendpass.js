
var QUERY_DEPT = "#query select[name='deptId']";//部门
var QUERY_UNAME = "#query select[name='userId']"; // 用户名

var ATTEND_PASS_TABLE = "#attendPassTable";// 表格

var attendPassTable;

function initAttendPass(params) {

    var user = getCacheObj(SESSION_USER);
    var type = params.type;
    // 初始化下拉框
    renderSelect($(QUERY_DEPT),'部门', SERVER_URL.code_dept, {}, function (e) {
        var deptId = e.target.value;
        renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user,{deptId: deptId});
    });

    renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user);

    //加载表格
    loadAttendPassTable(params);

    //监听查询按钮
    $('form#query').on('click', '#queryBtn', function(e){
        var params = $(this).parents('form').serializeJSON();
        params.type = type;
        attendPassTable.clear();
        attendPassTable.destroy();
        loadAttendPassTable(params);
    });

}

function loadAttendPassTable(params) {

    var options = {
        ordering:false,
        serverSide:false,
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"userName","defaultContent":'',"width":100, "name": "姓名" ,"title": "姓名" , "render":renderUserName},
            { "data":"deptName","defaultContent":'',"width":100, "name": "部门" ,"title": "部门"},
            { "data":"areaName","defaultContent":'',"width":100, "name": "签到区域" ,"title": "签到区域"},
            { "data":"lastPasstime","defaultContent":'',"width":100, "name": "签到时间" ,"title": "签到时间"}

        ]

    }
    attendPassTable = renderTable($(ATTEND_PASS_TABLE), SERVER_URL.current_pass_attend,params,options);

    function renderUserName(data, type,row){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            return "<a href='#!track/"+row.userId+"'>"+data+"</a>";
        }
    }

}

