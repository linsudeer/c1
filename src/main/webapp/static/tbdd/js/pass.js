
var QUERY_DEPT = "#query select[name='deptId']";//部门
var QUERY_UNAME = "#query select[name='userId']"; // 用户名
var QUERY_AREA = "#query select[name='areaId']";//区域
var QUERY_USERGROUP = "#query select[name='userGroup']";//人员分组
var QUERY_DIRECT = "#query select[name='direct']";//进出方向

var QUERY_STARTTIME = "#starttime";//开始时间
var QUERY_ENDTIME = "#endtime";//开始时间

var PASS_TABLE = "#passTable";// 表格

var table;

function initPass() {

    var user = getCacheObj(SESSION_USER);
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

    setDeptTreeData();

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
        $(PASS_DIRECT).attr('disabled', false);
        $(PASS_AREA).attr('disabled', false);
        $(PASS_DATETIME).attr('disabled', false);
        $(PASS_REMARK).parents('div').show();
        $(PASS_RECORD_ID).val('');
        layer.open({
            type:1,
            content:$(PASS_ADD_WRAP),
            area: ['600px', '380px']
        });
    });

}

function loadPassTable(params) {

    var options = {
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"faceFdfsId","defaultContent":'', "width":100, "name": "人脸图片" ,"title": "图片" ,"orderable": false, "render":renderImage},
            { "data":"userName","defaultContent":'',"width":100, "name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"userGroupName","defaultContent":'',"width":100, "name": "人员类型" ,"title": "人员类型" ,"orderable": false},
            { "data":"deptName","defaultContent":'',"width":100, "name": "部门" ,"title": "部门" ,"orderable": false},
            { "data":"deviceAreaName","defaultContent":'',"width":100, "name": "通行区域" ,"title": "区域" ,"orderable": false},
            { "data":"direct","defaultContent":'',"width":100, "name": "进出方向" ,"title": "方向" ,"orderable": false},
            { "data":"passDatetime","defaultContent":'',"width":100, "name": "通行时间" ,"title": "时间" ,"orderable": false},
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

    function renderOpt(data, type, row, meta){
        return "<a href='javascript:void(0)' onclick='editPassRecord("+meta.row+")'>修改</a>&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='delPassRecord("+meta.row+")'>删除</a>";
    }
}

function editPassRecord(index){
    // 这里加权限判断
    var row = table.row(index).data();
    // layer.msg("请联系本室办领导修改");

    layer.open({
        type:1,
        content:$(PASS_ADD_WRAP),
        area: ['600px', '380px'],
        success: function(layero, index){

            $(PASS_DIRECT).prop('disabled', true);
            $(PASS_AREA).prop('disabled', true);
            $(PASS_DATETIME).attr('disabled', true);
            $(PASS_REMARK).parent('div').hide();

            setSelect2Val($(PASS_UNAME), row.userId, row.userName);
            setSelect2Val($(PASS_DIRECT), row.deviceDirection, row.direct);
            setSelect2Val($(PASS_AREA), row.deviceAreaId, row.deviceAreaName);
            $(PASS_DATETIME).val(row.passDatetime);
            $(PASS_RECORD_ID).val(row.passRecordId);
        }
    });
}

function delPassRecord(index){
    var row = table.row(index).data();
    $.post(SERVER_URL.pass_del,{recordId:row.passRecordId}, function(ret){
        layer.msg("删除成功！");
        //这里删除一行
        table.row(index).remove();
    })
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