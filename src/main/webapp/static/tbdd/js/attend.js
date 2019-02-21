
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

    loadAttendTable();

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
            { "data":"userName", "defaultContent":'',"name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"deptName", "defaultContent":'',"name": "部门" ,"title": "部门" ,"orderable": true},
            { "data":"startDate", "defaultContent":'',"name": "开始日期" ,"title": "开始日期" ,"orderable": true, "render":renderAttendDate},
            { "data":"endDate", "defaultContent":'',"name": "结束日期" ,"title": "结束日期" ,"orderable": true, "render":renderAttendDate},
            { "data":"absenceDays","defaultContent":'', "name": "应出勤（天）" ,"title": "应出勤（天）" ,"orderable": true},
            { "data":"leaveDays", "defaultContent":'',"name": "请假（天）" ,"title": "请假（天）" ,"orderable": true},
            { "data":"absenceTime", "defaultContent":'',"name": "应出勤（小时）" ,"title": "应出勤（小时" ,"orderable": true},
            { "data":"attendTime", "defaultContent":'',"name": "考勤时长（小时）" ,"title": "考勤时长（小时）" ,"orderable": true},
            { "data":"overTime", "defaultContent":'',"name": "加班时长（小时）" ,"title": "加班时长（小时）" ,"orderable": true},
            { "data":"null", "name": "状态" ,"title": "状态" ,"orderable": false, "render":renderStatus}
        ],
        rowCallback:function( row, data ){
            if(data.causaRecords && data.causaRecords.length>0){// 考勤异常整行变红
                var flag = 1;
                var content = '';
                for(var i=0; i<data.causaRecords.length; i++){
                    var r = data.causaRecords[i];
                    if(r.reviewFlag == 0){// 这里如果有一个0 则说明还有异常情况未处理
                        flag = 0;
                    }else {// 这里如果是1的话则说明有已经处理过的情况，要显示出来备注
                        content += r.reviewUserName+"于"+ r.reviewTime+'修改了'+r.causalname+'状态，原因：'+r.reviewRemark+";<br />";
                        $(row).on('mouseover', function(){
                            tip(content,$(row));
                        });
                        $(row).on('mouseout', function(){
                            closeTip();
                        });
                    }
                }
                if(flag == 0){
                    $(row).css('color', 'red');
                    $('td>a', row).css('color', 'red');
                }else {// 这里说明全部是1 则应该显示黄色
                    $(row).css('color', 'yellow');
                    $('td>a', row).css('color', 'yellow');
                }
            }

        }
    }
    table = renderTable($(ATTEND_TABLE), SERVER_URL.attend_statistics,params,options);

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
                return '<a href="javascript:void(0)" onclick="casuaDetail('+meta.row+')">异常</a>';
            }else {
                return '正常';
            }

        }else {
            return '正常';
        }
    }


}

/**
 * 异常考勤点击事件
 * @param detail
 */
var causalLayerIndex;
function casuaDetail(index){
    var data = table.row(index).data();
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
        table.ajax.reload( null, false );
    });
}
