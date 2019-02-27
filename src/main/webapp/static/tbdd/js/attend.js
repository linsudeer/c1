
var ATTEND_TABLE = "#attendTable";

var QUERY_DEPT = "#query select[name='deptId']";//部门
var QUERY_UNAME = "#query select[name='userId']"; // 用户名

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

    // 这里判断权限
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1 || role.indexOf(ROLE.middle)>-1){// 部门以下的权限 不可以查看其他部门的通行数据
            loadAttendTable({deptId:user.deptId});
            setSelect2Val($(QUERY_DEPT), user.deptId, user.deptName);
            $(QUERY_DEPT).attr('disabled', true);
        }else {// 其他权限可以查看
            loadAttendTable();
        }
    }

    //监听查询按钮
    $('form#query').on('click', '#queryBtn', function(e){
        var params = $(this).parents('form').serializeJSON();
        params.deptId = $(QUERY_DEPT).val();
        attendTable.clear();
        attendTable.destroy();
        loadAttendTable(params);
    });

    //监听查询按钮
    $('form#query').on('click', '#preAttendBtn', function(e){
        var params = $(this).parents('form').serializeJSON();
        params.deptId = $(QUERY_DEPT).val();
        params.startDate = new Date().getPreMonday().format("yyyy-MM-dd");
        params.endDate = new Date().getPreSunday().format("yyyy-MM-dd");
        attendTable.clear();
        attendTable.destroy();
        loadAttendTable(params);
    });
}
var attendTable;
function loadAttendTable(params){
    var options = {
        serverSide: false,
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"userName", "defaultContent":'',"name": "姓名" ,"title": "姓名" ,"orderable": true, "render":renderUserName},
            { "data":"deptName", "defaultContent":'',"name": "部门" ,"title": "部门" ,"orderable": true},
            { "data":"startDate", "defaultContent":'',"name": "开始日期" ,"title": "开始日期" ,"orderable": true, "render":renderAttendDate},
            { "data":"endDate", "defaultContent":'',"name": "结束日期" ,"title": "结束日期" ,"orderable": true, "render":renderAttendDate},
            { "data":"absenceDays","defaultContent":0, "name": "应出勤（天）" ,"title": "应出勤（天）" ,"orderable": true},
            { "data":"leaveDays", "defaultContent":0,"name": "请假（天）" ,"title": "请假（天）" ,"orderable": true},
            { "data":"absenceTime", "defaultContent":0,"name": "应出勤（小时）" ,"title": "应出勤（小时" ,"orderable": true},
            { "data":"attendTime", "defaultContent":0,"name": "考勤时长（小时）" ,"title": "考勤时长（小时）" ,"orderable": true, "render":renderAttendTime},
            { "data":"overTime", "defaultContent":0,"name": "加班时长（小时）" ,"title": "加班时长（小时）" ,"orderable": true},
            { "data":"null", "name": "状态" ,"title": "状态" ,"orderable": false, "render":renderStatus}
        ],
        buttons: [
            {
                'extend':'excelHtml5',
                'text':'导出',
                'title':'人脸识别考勤系统-考勤报表',
                'className':'btn btn-success btn-sm',
                "exportOptions":{
                    columns:[1,2,3,4,5,6,8,9]
                },
            },
            /*{
                'extend':'print',
                'text':'打印',
                'title':'人脸识别考勤系统-考勤报表',
                'className':'btn btn-success btn-sm',
                "exportOptions":{
                    columns:[1,2,3,4,5,6,8,9]
                },
            }*/
        ],
        rowCallback:function( row, data ){
            var remarNum = 0;
            if(data.causaRecords && data.causaRecords.length>0){// 考勤异常整行变红
                var flag = 1;
                var content = '';
                for(var i=0; i<data.causaRecords.length; i++){
                    var r = data.causaRecords[i];
                    if(r.reviewFlag == 0){// 这里如果有一个0 则说明还有异常情况未处理
                        flag = 0;
                    }else {// 这里如果是1的话则说明有已经处理过的情况，要显示出来备注
                        content += (remarNum+=1)+". "+r.reviewUserName+"修改了"+r.attendDate.substr(0,10)+r.causalname+'状态，原因：'+r.reviewRemark+";<br />";
                    }
                }
                if(flag == 0){
                    $(row).css('color', 'red');
                    $('td>a', row).css('color', 'red');
                }else {// 这里说明全部是1 则应该显示黄色
                    $(row).css('color', 'yellow');
                    $('td>a', row).css('color', 'yellow');

                    $('td>a', row).on('mouseover', function(){
                        tip(content,$('td>a', row));
                    });
                    $('td>a', row).on('mouseout', function(){
                        closeTip();
                    });
                    $('td>a', row).prepend('<span class="glyphicon glyphicon-info-sign m-xs-r" aria-hidden="true"></span>')
                }
            }

        }
    }
    attendTable = renderTable($(ATTEND_TABLE), SERVER_URL.attend_statistics,params,options);

    function renderAttendDate(data, type, row){
        return data?data.split(' ')[0]:'';
    }

    function renderUserName(data, type,row){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            return "<a href='#!track/"+row.userId+"'>"+data+"</a>";
        }
    }

    function renderAttendTime(data, type,row){
        return data?data.toFixed(1):0;
    }

    /**
     * 离岗状态，如果异常则点击查看详情
     * @param data
     * @param type
     * @param row
     */
    function renderStatus(data, type,row, meta){
        if(row.causaRecords && row.causaRecords.length>0 ){
            var flag = 1;
            for(var i=0; i<row.causaRecords.length; i++){
                if(row.causaRecords[i].reviewFlag == 0){// 这里如果有一个0 则说明还有异常情况未处理
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                return '<a href="javascript:void(0)" onclick="casuaDetail('+meta.row+')" onmouseover="showCasua(this, '+meta.row+')" onmouseout="closeTip()"><span class="glyphicon glyphicon-pencil m-xs-r" aria-hidden="true"></span><span>异常</span></a>';
            }else {
                return '正常';
            }

        }else {
            return '正常';
        }
    }


}

function showCasua(e, index){
    var data = attendTable.row(index).data();

    event.stopPropagation();
    var causas = data.causaRecords;// 对应的异常记录
    var content = "";
    for(var i=0;i<causas.length;i++){
        var r = causas[i];

        if(r.reviewFlag==1){
            content += "<div style='color: yellow'>"+(r.attendDate.substr(0, 10)+" "+r.time)+r.causalname+"\t已修改;</div>";
        }else {
            content += (r.attendDate.substr(0, 10)+" "+r.time)+r.causalname+"<br>";
        }

    }
    tip(content, $(e));
}

/**
 * 异常考勤点击事件
 * @param detail
 */
var causalLayerIndex;
function casuaDetail(index){
    var data = attendTable.row(index).data();
    //加载权限判断
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1){// 部门以下的权限 不可以修改其他部门的通行数据，大队领导权限可以修改本部门权限
            layer.msg("请联系本室办领导修改");
            return;
        }
        if(role.indexOf(ROLE.senior)>-1){// 大队领导可以查看所有数据，可以修改本部门和军事办的数据
            if(user.deptId != data.deptId  && data.deptId!=SENIOR_DEPT_ID){
                layer.msg("请联系本室办领导修改");
                return;
            }
        }
        if(role.indexOf(ROLE.middle)>-1){
            if(user.deptId != data.deptId){
                layer.msg("请联系本室办领导修改");
                return;
            }
        }
    }else {
        layer.msg("请联系本室办领导修改");
        return;
    }
    var causas = data.causaRecords;// 对应的异常记录
    var html = '<ul class="list-group casua"><li class="list-group-item text-center"><span>序号</span><span>离岗状态</span><span>时间</span><span>操作</span></li>';
    for(var i=0;i<causas.length;i++){
        var r = causas[i];
        if(r.reviewFlag==0){
            html += '<li class="list-group-item text-center">' +
                '<span>'+(i+1)+'</span><span>'+r.causalname+'</span>' +
                '<span>'+(r.attendDate.substr(0, 10)+" "+r.time)+'</span>' +
                '<span class="edit"><button class="btn btn-success btn-sm" onclick="causalEdit()">修正</button></span>' +
                '<span class="hidden"><input class="form-control" placeholder="请输入原因" style="display: inline-block;color: #333;width: 60%;margin-right: 15px;" type="text" name="remark"><button onclick="causalOk(this,'+r.id+', '+index+')" class="btn btn-success btn-sm m-r">确定</button></span></span></li>';
        }

    }
    html += '</ul>';
    causalLayerIndex = layer.open({
        title:'离岗情况',
        type:1,
        shadeClose: true, //开启遮罩关闭
        content:html,
        area: ['600px', '350px']
    });
}

/**
 * 点击修正按钮 切换到输入框
 * @param e
 */
function causalEdit(e){
    $('.casua li > span.edit').addClass('hidden');
    $('.casua li > span.edit').next().removeClass('hidden');
}

/**
 * 确认修改考勤
 */
function causalOk(e, id, rowindex){
    var remark = $('.casua li > span >input[name="remark"]').val();
    if(!remark){
        layer.msg("请输入修正原因");
        return;
    }

    $.post(SERVER_URL.attend_causal_review,{id:id,remark:remark}, function(ret){
        // 修正成功后 移除此行并更新 考勤信息
        $(e).parents('li').remove();
        if($(e).parents('li').length == 1){
            layer.close(causalLayerIndex);
        }
        attendTable.ajax.reload( null, false );
    });
}
