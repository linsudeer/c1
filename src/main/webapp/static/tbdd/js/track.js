
var QUERY_DEPT = "#query select[name='deptId']";//部门
var QUERY_UNAME = "#query select[name='userId']"; // 用户名
var QUERY_STARTTIME = "#starttime";//开始时间
var QUERY_ENDTIME = "#endtime";//开始时间

var USER_HEADER = "#userHeader";// 显示的头像
var USER_NAME = "#userName";// 显示的名字
var DEPT_NAME = "#deptName";// 显示的部门
var TRACK_DATE = "#trackDate";// 轨迹日期

var ATTEMD_HISTORY = "#historyTable";//历史考勤
var TRACK_WRAP = "trackWrap";// 历史轨迹

function initTrack(params){

    renderSelect($(QUERY_DEPT),'部门', SERVER_URL.code_dept, {}, function (e) {
        var deptId = e.target.value;
        renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user,{deptId: deptId});
    });
    renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user);


    //初始化日期
    laydate.render({ elem: QUERY_STARTTIME});
    laydate.render({ elem: QUERY_ENDTIME});

    // 填充人员基本信息
    setUserInfo(params.userId);
    //当天通行记录（轨迹图片）
    drawTrack(params.userId, params.starttime, params.endtime);
    // $(QUERY_STARTTIME).val(params.starttime);
    // $(QUERY_ENDTIME).val(params.endtime);

    //加载此人历史考勤（历史考勤）
    drawHistoryAttend(params.userId);

    //监听查询按钮
    $('form#query').on('click', '#queryBtn', function(e){
        var p = $(this).parents('form').serializeJSON();
        table.clear();
        table.destroy();

        //跳转页面
        if(p.userId){
            /*var curdate = new Date().format("yyyy-MM-dd");
            p.starttime = p.starttime?p.starttime:curdate;
            p.endtime = p.endtime?p.endtime:curdate;
            go("track/"+p.userId+"/"+p.starttime+"/"+p.endtime);*/

            // 这里是页面内加载
            setUserInfo(p.userId);
            drawHistoryAttend(p.userId, p.starttime, p.endtime);
            drawTrack(p.userId, p.starttime, p.endtime);

        }else {
            layer.msg("请选择姓名！");
            return;
        }

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
                // $(PASS_UNAME).val('').trigger('change');
                $(PASS_OLD_UNAME).val('');
                $(PASS_REMARK).val('');
            }
        });
    });
}

function setUserInfo(userId){
    if(!userId) return;
    $.get(SERVER_URL.user_simple+"/"+userId, function(res){
        var user = res.data;
        if(!user) return;
        $(USER_HEADER).attr('src','data:image/jpeg;base64,'+(user.idPic || ''));
        $(USER_NAME).text(user.userName || '');
        $(DEPT_NAME).text(user.deptName || '');
        setSelect2Val($(QUERY_UNAME), userId, user.userName)
        setSelect2Val($(PASS_UNAME), userId, user.userName)

    });
}

/**
 * 个人轨迹
 * @param userId
 * @param startdate 开始日期 2019-01-18
 * @param endtime 结束日期 2019-01-19
 */

function drawTrack(userId, startdate, enddate){
    startdate = startdate?(startdate+' 00:00:00'):new Date().minOfCurdate();
    enddate = enddate?(enddate+' 23:59:59'):new Date().maxOfCurdate();

    $(TRACK_DATE).text(startdate.split(' ')[0]+' / '+enddate.split(' ')[0]);

    $.get(SERVER_URL.pass_list, {userId:userId, starttime:startdate, endtime:enddate}, function(res){
        var list = res.data;
        // if(!list) return;

        // 获取所有区域
        var areas = getAreas().reverse();
        if(areas.length==0) return;

        var seriesData = [];
        var xAxisData = [];
        var obj = {};
        var areaNames = [];
        var length = areas.length;
        // var colors=getColors(length);
        var colors=['#fffc79ee',"#06f1c9ee","#04b4f0ee"]; // 这里是固定区域，如果区域不固定用上面的函数随机生成颜色
        var mySeries = [];

        // 初始化数据
        for(var i=0;i<length;i++){
            obj[i] = areas[i].text;
            seriesData[areas[i].id] = [];
            mySeries[i]={};
        }

        //对数据进行分类，属于那个区域
        for(var i=list.length-1;i>=0; i--){
            var item = list[i];
            var value = +item.deviceAreaId ;
            var direct = item.direct;
            var areaName = item.deviceAreaName;
            var xtime = item.passDatetime.split(' ');
            var title = xtime[0] + "\r\n"+xtime[1]+"\n"+areaName+" / "+item.direct ;//年月日时分/位置

            for(var j=0;j<length;j++){
                if(value==areas[j].id){
                    seriesData[areas[j].id].push({value:j,symbol:"image://" + item.faceFdfsId,title:title,fullFdfsId:item.fullFdfsId});
                }else {
                    seriesData[areas[j].id].push({});
                }
            }
            xAxisData.push(item.passDatetime)


        }

        for(var i=0;i<length;i++){
            var areaId = areas[i].id;
            var areaName = areas[i].text;
            areaNames[i]=areaName;
            mySeries[i]={name:areaName,type:'line',symbol:"rectangle",symbolSize: [60,70],data:seriesData[areaId],itemStyle:{normal:{lineStyle:{width:10},label : {color:colors[length-1-i],formatter:function(o){return o.data.title;},show: true,position: 'top'}}}};
        }
        option = {
            tooltip : {trigger: 'item'},
            grid:{y:120,x:80,borderWidth:0,height:280,x2:80,y2:150 },
            title : {show:false},
            dataZoom: [{type: 'inside',start: 0,end: Math.round((10/list.length)*100),textStyle:{color:"#fff"}},
                {
                    start: 0,end: Math.round((10/list.length)*100),
                    handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                    handleSize: '80%',
                    handleStyle: {color: '#fff',shadowBlur: 3,shadowColor: 'rgba(0, 0, 0, 0.6)',shadowOffsetX: 2,shadowOffsetY: 2},
                    textStyle:{color:"#fff"}
                }]	,
            color:colors,
            legend: {left:"right",show:true,textStyle:{color:"#fff"},itemWidth:45,itemHeight:35,data:areaNames.reverse()},
            calculable : true,
            xAxis : [{type : 'category',show:false,axisLabel : {formatter: '',textStyle:{color:"#fff"}},
                axisLine:{lineStyle:{color: '#ffffff',width: 5,type: 'solid'}} ,splitLine:{show:true  },boundaryGap : true,data : xAxisData}],
            yAxis : {show:true,type : 'value',splitNumber:length-1,min:0, max:length-1, axisLine:{show:true},
                axisLabel:{formatter:function(index,data){return obj[index]},textStyle:{color: '#FFF',fontSize:14}},
                splitLine:{show:true,lineStyle:{width: 1,color: colors.reverse()}}},
            series : mySeries
        };
        var trackChart = echarts.init(document.getElementById(TRACK_WRAP));
        trackChart.setOption(option);

        trackChart.on('click',function(params){
            var fullFdfsId = params.data.fullFdfsId || '';
            layer.open({
                type: 1,
                title: false,
                closeBtn: 0,
                area: ['788px','443px'],
                skin: 'layui-layer-nobg', //没有背景色
                shadeClose: true,
                content: '<img style="width: 100%;" src='+fullFdfsId+'>',
                success: function(layero, index){

                }
            });
        });
    })

}

/**
 * ajax同步请求，返回区域
 * @returns {Array}
 */
function getAreas(){
    var areas = [];
    $.ajax({
        async: false,
        url:SERVER_URL.code_area,
        success:function(res){
            areas = res.data;
        }
    });
    return areas;
}

function drawHistoryAttend(userId,startDate,endDate) {
    var options = {
        ordering:false,
        serverSide: true,
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"userName", "defaultContent":'',"name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"deptName", "defaultContent":'',"name": "部门" ,"title": "部门" ,"orderable": false},
            { "data":"attendDate", "defaultContent":'',"name": "考勤日期" ,"title": "考勤日期" ,"orderable": false, "render":renderAttendDate},
            { "data":"week", "defaultContent":'',"name": "星期" ,"title": "星期" ,"orderable": false, "render": renderWeek},
            { "data":"absenceTime", "defaultContent":'',"name": "应出勤(小时)" ,"title": "应出勤（小时）" ,"orderable": false},
            { "data":"actualTime", "defaultContent":'',"name": "考勤时长（小时）" ,"title": "考勤时长（小时）" ,"orderable": false},
            { "data":"overTime", "defaultContent":'',"name": "加班时长（小时）" ,"title": "加班时长（小时）" ,"orderable": false},
            { "data":"leaveRemark", "defaultContent":'',"name": "状态" ,"title": "状态" ,"orderable": false, "render": renderLeaveRemark},
            { "data":"computeDetail", "defaultContent":'',"name": "计算详情" ,"title": "计算详情" ,"orderable": false,"render":renderCompuleDetail}
        ],
        rowCallback:function( row, data ){
            var remarkNum = 0;
            var content = '';
            if(data.causaRecords && data.causaRecords.length>0){// 考勤异常整行变红
                var flag = 1;

                for(var i=0; i<data.causaRecords.length; i++){
                    var r = data.causaRecords[i];
                    if(r.reviewFlag == 0){// 这里如果有一个0 则说明还有异常情况未处理
                        flag = 0;
                    }else {// 这里如果是1的话则说明有已经处理过的情况，要显示出来备注
                        content += (remarkNum+=1)+". "+r.reviewUserName+"于"+ r.reviewTime+'修改了'+r.causalname+'状态，原因：'+r.reviewRemark+";<br />";
                    }
                }
                if(!data.reviewFlag && flag == 0){
                    $(row).css('color', 'red');
                    $('td>a', row).css('color', 'red');
                }else {// 这里说明全部是1 则应该显示黄色

                    $(row).css('color', 'yellow');
                    $('td>a', row).css('color', 'yellow');
                }

            }
            if(data.reviewFlag==1){
                $(row).css('color', 'yellow');
                $('td>a', row).css('color', 'yellow');

                content+= (remarkNum+=1)+". "+data.reviewRemark;
            }
            if(!data.reviewFlag && data.actualTime<data.absenceTime){
                $(row).css('color', 'red');
                $('td>a', row).css('color', 'red');
            }
            if(content){
                $('td>a', row).prepend('<span class="glyphicon glyphicon-info-sign m-xs-r" aria-hidden="true"></span>')
                $('td>a', row).on('mouseover', function(){
                    tip(content,$('td>a', row));
                });
                $('td>a', row).on('mouseout', function(){
                    closeTip();
                });
            }

        }
    }
    var params = {userId:userId, startDate:startDate, endDate:endDate}
    table = renderTable($(ATTEMD_HISTORY), SERVER_URL.attend_history,params,options);


    function renderAttendDate(data, type, row){
        return data?data.split(' ')[0]:'';
    }


    function renderUserName(data, type,row){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            var time = row.attendDate?row.attendDate.split(' ')[0]:'';
            return "<a href='#!track/"+row.userId+"/"+time+"/"+time+"'>"+data+"</a>";
        }
    }

    /**
     * 考勤状态 请假，大队执勤，上午迟到，上午早退，下午迟到，下午早退，上午旷工，下午旷工，时长不足，记录不全，
     * @param data
     * @param type
     * @param row
     * @returns {string}
     */
    function renderLeaveRemark(data, type, row, meta) {
        var content = "<span style='color:"+getLeaveColor(data)+"'>"+data+"</span>";
        if(row.pairFlag==1){
            data = '记录不全';
        }
        if(!row.reviewFlag && row.actualTime<row.absenceTime){
            data = "时长不足"
            content = "<span style='color:"+getLeaveColor(data)+";cursor: pointer' onclick='openModifyStatus("+meta.row+")'><span class='glyphicon glyphicon-pencil m-xs-r' aria-hidden='true'></span><span>"+data+"</span></span>";
        }
        if(row.causaRecords && row.causaRecords.length>0 ){
            for(var i=0; i<row.causaRecords.length; i++){
                if(row.causaRecords[i].reviewFlag == 0){// 这里如果有一个0 则说明还有异常情况未处理
                    data = row.causaRecords[i].causalname;
                    break;
                }
            }
        }
        return content;
    }

    function renderCompuleDetail(data, type, row, meta) {

        if(data){
            return "<i class='glyphicon glyphicon-list-alt' id='detail"+meta.row+"' onmouseover='tip(\""+data+"\",\"#detail"+meta.row+"\")' onmouseout='closeTip()'></i>"
        }else {
            return "<i class='glyphicon glyphicon-list-alt' style='color:#aaa'></i>"
        }
    }

    function renderWeek(data){
        var week = data;
        if(data == 1){
            week = '星期一';
        }else if(data==2){
            week = '星期二';
        }else if(data==3){
            week = '星期三';
        }else if(data==4){
            week = '星期四';
        }else if(data==5){
            week = '星期五';
        }else if(data==6){
            week = '星期六';
        }
        else if(data==7){
            week = '星期日';
        }
        return week;
    }
}

function openModifyStatus(index){
    var data = table.row(index).data();
    //加载权限判断
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1){// 部门以下的权限 不可以修改其他部门的通行数据，大队领导权限可以修改本部门权限
            layer.msg("请联系本室办领导修改");
            return;
        }
        if(role.indexOf(ROLE.senior)>-1){// 大队领导可以查看所有数据，可以修改本部门和军事办的数据
            if(user.deptId != data.deptId  && data.deptId!=5){
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
    var html = '<form style="padding: 10px;">' +
        '<div class="form-group"><label>姓名：</label><span style="display: inline-block;">'+data.userName+'</span></div>' +
        '<div class="form-group"><label>状态：</label><select id="attendSelect" type="text" style="width:85%" class="form-control" name="status" placeholder="考勤状态"></select></div>' +
        '</form>'

    layer.open({
        type:1,
        shadeClose: true, //开启遮罩关闭
        content:html,
        area: ['600px', '350px'],
        btn: ['保存', '关闭'],
        yes: function(layindex){
            var status = $("#attendSelect").val();
            saveAttendStatus(layindex, index, data.id, status);
        },
        success:function(){
            $("#attendSelect").select2({
                data:[{id:'正常', text:"正常"},{id:'大队执勤', text:'大队执勤'},{id:'休假', text:'休假'},{id:'临时外出', text:"临时外出"}]
            });
        }
    });
}

function saveAttendStatus(layindex, rowIndex, attendId, status){

    $.post(SERVER_URL.attend_modifyStatus,{attendId:attendId, status:status}, function(ret){
        var record = ret.data;
        if(record){
            table.row(rowIndex).data(record);
            table.draw(false);
            layer.msg('修改成功!');
        }


    })
    layer.close(layindex);
}