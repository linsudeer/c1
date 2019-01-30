
var QUERY_DEPT = "select[name='deptId']";//部门
var QUERY_UNAME = "select[name='userId']"; // 用户名
var QUERY_AREA = "select[name='areaId']";//区域
var QUERY_USERGROUP = "select[name='userGroup']";//人员分组
var QUERY_DIRECT = "select[name='direct']";//进出方向

var QUERY_STARTTIME = "#starttime";//开始时间
var QUERY_ENDTIME = "#endtime";//开始时间

var PASS_TABLE = "#passTable";// 表格

var table;

function initPass() {

    // 初始化下拉框
    renderSelect($(QUERY_DEPT),'部门', SERVER_URL.code_dept, {}, function (e) {
        var deptId = e.target.value;
        renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user,{deptId: deptId});
    });

    renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user);
    renderSelect($(QUERY_AREA),'区域', SERVER_URL.code_area);
    renderSelect($(QUERY_USERGROUP),'人员类型', SERVER_URL.code_usergroup);
    renderSelect($(QUERY_DIRECT),'进出方向', SERVER_URL.code_direct);
    //初始化日期
    laydate.render({ elem: QUERY_STARTTIME, type: 'datetime'});
    laydate.render({ elem: QUERY_ENDTIME, type: 'datetime'});

    //加载表格
    loadPassTable();

    //监听查询按钮
    $('form#query').on('click', '#queryBtn', function(e){
        var params = $(this).parents('form').serializeJSON();
        console.log(params);
        table.clear();
        table.destroy();
        loadPassTable(params);
    });

    // 监听新增按钮
    $('form#query').on('click', '#addBtn', function (e){
        layer.open({
            type:1,
            content:$(PASS_ADD_WRAP),
            area: ['550px', '350px']
        });
    });

}

function loadPassTable(params) {

    var options = {
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"faceFdfsId", "width":100, "name": "人脸图片" ,"title": "图片" ,"orderable": false, "render":renderImage},
            { "data":"userName","width":100, "name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"userGroupName","width":100, "name": "人员类型" ,"title": "人员类型" ,"orderable": false},
            { "data":"deptName","width":100, "name": "部门" ,"title": "部门" ,"orderable": false},
            { "data":"deviceAreaName","width":100, "name": "通行区域" ,"title": "区域" ,"orderable": false},
            { "data":"direct","width":100, "name": "进出方向" ,"title": "方向" ,"orderable": false},
            { "data":"passDatetime","width":100, "name": "通行时间" ,"title": "时间" ,"orderable": false},
            { "data":"", "name": "操作" ,"width":100,"title": "操作" ,"orderable": false,"render":renderOpt}
        ]
    }
    table = renderTable($(PASS_TABLE), SERVER_URL.pass_list,params,options);

    function renderImage(data, type,row,meta){
        if(row.userId<=0){
            row.userName = '--';
        }
        return '<a href="'+row.fullFdfsId+'" data-title="'+row.userName+'/'+row.passDatetime+'" data-lightbox="faceImg"><img onerror="thumb_onerror(this)" src="'+row.faceFdfsId+'"></a>'
    }

    function renderUserName(data, type,row){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            var time = parseDate(row.passDatetime).format('yyyy-MM-dd');
            return "<a href='#!track/"+row.userId+"/"+time+"/"+time+"'>"+data+"</a>";
        }
    }

    function renderOpt(data, type, row){
        return "<a href='javascript:void(0)' onclick='editPassRecord(1)'>修改</a>&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='delPassRecord(1)'>删除</a>";
    }
}

function editPassRecord(row){
    // 这里加权限判断
    layer.msg("请联系室办领导");
}