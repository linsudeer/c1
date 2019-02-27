
var QUERY_DEPT = "#query select[name='deptId']";//部门
var QUERY_P_DEPT = "#query input[name='deptPid']";//部门
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

    // 这里判断权限
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1 || role.indexOf(ROLE.middle)>-1){// 部门以下的权限可以查看本部门的数据
            loadPassTable({deptId:user.deptId});
            setSelect2Val($(QUERY_DEPT), user.deptId, user.deptName);
            $(QUERY_DEPT).attr('disabled', true);
        }else {// 其他权限可以查看
            loadPassTable();
        }
    }


    //监听查询按钮
    $('form#query').on('click', '#queryBtn', function(e){
        var params = $(this).parents('form').serializeJSON();
        params.deptId = $(QUERY_DEPT).val();
        if(params.deptId){
            params.deptPid=0;
        }
        table.clear();
        table.destroy();
        loadPassTable(params);
    });

    // 监听新增按钮
    $('form#query').on('click', '#addBtn', function (e){
        var user = getCacheObj(SESSION_USER);
        if(user){
            var role = user.dataRole;
            if(role.indexOf(ROLE.general)>-1){// 部门以下的权限 不可修改其他部门的通行数据，这里判断senoir权限，可以修改 大队领导和军事办的权限 TODO
                layer.msg("请联系本室办领导新增!");
                return;
            }
        }else {
            layer.msg("请联系本室办领导新增!");
            return;
        }
        layer.open({
            type:1,
            content:$(PASS_ADD_WRAP),
            area: ['600px', '400px'],
            btn: ['保存', '关闭'],
            yes: function(index){
                savePass(index);
            },
            success:function(){
                $(PASS_DIRECT).attr('disabled', false);
                $(PASS_AREA).attr('disabled', false);
                $(PASS_DATETIME).attr('disabled', false);
                $(PASS_REMARK).parents('div').show();
                $(PASS_RECORD_ID).val('');
                $(PASS_DIRECT).val('').trigger('change');
                $(PASS_AREA).val('').trigger('change');
                $(PASS_DATETIME).val('');
                $(PASS_UNAME).val('').trigger('change');
                $(PASS_OLD_UNAME).val('');
                $(PASS_REMARK).val('');
            }
        });
    });

}

function loadPassTable(params) {

    var options = {
        ordering:false,
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"faceFdfsId","defaultContent":'', "width":100, "name": "人脸图片" ,"title": "图片" , "render":renderImage},
            { "data":"userName","defaultContent":'',"class":"username", "width":100, "name": "姓名" ,"title": "姓名" , "render":renderUserName},
            { "data":"userGroupName","defaultContent":'',"width":100, "name": "人员类型" ,"title": "人员类型"},
            { "data":"deptName","defaultContent":'',"width":100, "name": "部门" ,"title": "部门"},
            { "data":"deviceAreaName","defaultContent":'',"width":100, "name": "通行区域" ,"title": "区域"},
            { "data":"direct","defaultContent":'',"width":100, "name": "进出方向" ,"title": "方向"},
            { "data":"passDatetime","defaultContent":'',"width":100, "name": "通行时间" ,"title": "时间"},
            { "data":"", "name": "操作" ,"width":100,"title": "操作" ,"orderable": false,"render":renderOpt}
        ],
        rowCallback:function( row, data ) {
            var logs = data.logs;
            var content = '';
            if (logs.length > 0) {
                $(row).css('color', 'yellow');
                $('td>a', row).css('color', 'yellow');
                for(var i=0; i<logs.length;i++){
                    var log = logs[i];
                    content += log.optContent+"<br>";
                }
                $('td.username>a', row).on('mouseover', function(){
                    tip(content,$('td.username>a', row));
                });
                $('td.username>a', row).on('mouseout', function(){
                    closeTip();
                });
                $('td.username>a', row).prepend('<span class="glyphicon glyphicon-info-sign m-xs-r" aria-hidden="true"></span>')
            }

        }

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

        var content =  "<a href='javascript:void(0)' onclick='editPassRecord("+meta.row+")'>修改</a>";
        if(row.logs && row.logs.length>0){
            content += "&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='delPassRecord("+meta.row+")'>删除</a>";
        }
        return content;
    }
}

function editPassRecord(index){
    var row = table.row(index).data();
    // 这里加权限判断
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1){// 部门以下的权限 不可以修改其他部门的通行数据，大队领导权限可以修改本部门权限
            layer.msg("请联系本室办领导修改");
            return;
        }
        if(role.indexOf(ROLE.senior)>-1){// 大队领导可以查看所有数据，可以修改本部门和军事办的数据
            if(user.deptId != row.deptId  && row.deptId!=SENIOR_DEPT_ID){
                layer.msg("请联系本室办领导修改");
                return;
            }
        }
        if(role.indexOf(ROLE.middle)>-1){
            if(user.deptId != row.deptId){
                layer.msg("请联系本室办领导修改");
                return;
            }
        }
    }else {
        layer.msg("请联系本室办领导修改");
        return;
    }
    // layer.msg("请联系本室办领导修改");

    layer.open({
        type:1,
        content:$(PASS_ADD_WRAP),
        area: ['600px', '380px'],
        btn: ['保存', '关闭'],
        yes: function(idx){
            savePass(index);
        },
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
            $(PASS_OLD_UNAME).val(row.userId);
        }
    });
}

function delPassRecord(index){
    var row = table.row(index).data();
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1){// 部门以下的权限 不可修改其他部门的通行数据，这里判断senoir权限，可以修改 大队领导和军事办的权限 TODO
            layer.msg("请联系本室办领导删除!");
            return;
        }
    }else {
        layer.msg("请联系本室办领导删除!");
        return;
    }
    $.post(SERVER_URL.pass_del,{recordId:row.passRecordId}, function(ret){
        layer.msg("删除成功！");
        //这里删除一行
        table.row(index).remove();
        table.draw(false);
    })
}
