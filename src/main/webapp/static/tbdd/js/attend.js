
var ATTEND_TABLE = "#attendTable";

var QUERY_DEPT = "select[name='deptId']";//部门
var QUERY_UNAME = "select[name='userId']"; // 用户名

var QUERY_STARTTIME = "#starttime";//开始时间
var QUERY_ENDTIME = "#endtime";//开始时间

function initAttend(){

// 初始化下拉框
    renderSelect($(QUERY_DEPT),'部门', SERVER_URL.code_dept, {}, function (e) {
        var deptId = e.target.value;
        renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user,{deptId: deptId});
    });
    renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user);

    //初始化日期
    laydate.render({ elem: QUERY_STARTTIME, type: 'date'});
    laydate.render({ elem: QUERY_ENDTIME, type: 'date'});

    loadAttendTable();

    setDeptTreeData();
    //监听查询按钮
    $('form#query').on('click', 'button', function(e){
        var params = $(this).parents('form').serializeJSON();
        console.log(params);
        table.clear();
        table.destroy();
        loadAttendTable(params);
    });
}

function loadAttendTable(params){
    var options = {
        serverSide: false,
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"userName", "name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"deptName", "name": "部门" ,"title": "部门" ,"orderable": true},
            { "data":"startDate", "name": "开始日期" ,"title": "开始日期" ,"orderable": true, "render":renderAttendDate},
            { "data":"endDate", "name": "结束日期" ,"title": "结束日期" ,"orderable": true, "render":renderAttendDate},
            { "data":"absenceDays", "name": "应出勤（天）" ,"title": "应出勤（天）" ,"orderable": true},
            { "data":"leaveDays", "name": "请假（天）" ,"title": "请假（天）" ,"orderable": true},
            { "data":"absenceTime", "name": "应出勤（小时）" ,"title": "应出勤（小时" ,"orderable": true},
            { "data":"absenceTime", "name": "考勤时长（小时）" ,"title": "考勤时长（小时）" ,"orderable": true},
            { "data":"overTime", "name": "加班时长（小时）" ,"title": "加班时长（小时）" ,"orderable": true}
        ]
    }
    table = renderTable($(ATTEND_TABLE), SERVER_URL.attend_statistics,params,options);

    function renderAttendDate(data, type, row){
        return data?data.split(' ')[0]:'';
    }

    function renderUserName(data, type,row,meta){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            return "<a href='#!track/"+row.userId+"'>"+data+"</a>";
        }
    }
}

//加载部门树数据
function setDeptTreeData() {
    $.get(SERVER_URL.org_onWorkTree, {pid: 0},function(res){
        var data = res.data;
        renderTree(data, function(event, data){
            if(data.type==1){// 单位
                //draw24hData(true,'deptPId', data.id);
            }else if(data.type==2){// 部门
                //draw24hData(true,'deptId', data.id);
            }else {// 所有
                // draw24hData(true);
            }

        },function (event, data){
            var path = 'onwork';
            if(data.type==1){//单位
                path += '/'+data.id;
            }else if(data.type=2) {//部门
                path += "/" + data.pId+"/"+data.id;
            }
            go(path);
        });
    });

}