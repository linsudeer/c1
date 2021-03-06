
var HEADER = "#content-header .current";
var CAROUSE_TITLE = "#carouselTitle";
var TABLE_TITLE = "#tableTitle";
var PASS_TABLE = "#passTable";
var CAROUSEWRAP = "#carousel";

var QUERY_DEPT = "#query select[name='deptId']";//部门
var QUERY_P_DEPT = "#query input[name='deptPid']";//部门


function initOnwork(params){
    setTitleData(params.deptPid, params.deptId, params.type);
    loadData(params.deptPid, params.deptId, params.type, params.areaId, decodeURI(params.endDatetime));


}

/**
 * 设置标题
 */
function setTitleData(deptPid, deptId, type){
    if(+type){// 类型1-在岗 2-临时离岗 3-不在岗 4-24小时在岗
    }else {// 没有类型，显示所有，根据部门显示
        $.get(SERVER_URL.current_typegroup,{deptId:deptId, deptPid:deptPid}, function(res){
            var data = res.data;
            var onCnt=0, offCnt=0, total=0;
            var deptName='';
            if(data && data.length>0){
                for(var i=0;i<data.length;i++){
                    if(data[i].name=='在岗人员'){
                        onCnt += data[i].count;
                    }else {
                        offCnt += data[i].count;
                    }
                    if(data[i].deptName){
                        deptName = data[i].deptName;
                    }
                }
                total = onCnt+offCnt;

            }
            $(HEADER).text(deptName+"在岗人员");
            if(!+deptId){
                deptName = "";
            }else {
                setSelect2Val($(QUERY_DEPT), deptId, deptName)
            }

            var html='<span>'+deptName+'人员统计：</span>\n' +
                '\t\t\t\t\t<span> 共 '+total+'人，  </span>\n' +
                '\t\t\t\t\t<span> 在岗'+onCnt+'人， </span>\n' +
                '\t\t\t\t\t<span> 不在岗'+offCnt+'人。</span>';

            if(!+deptId || data.length>50){
                $('#tab2').removeClass('active')
                $('#tab1').addClass('active')
                $(TABLE_TITLE).html(html + '<a data-toggle="tab" href="#tab2"></a>')
            }else {
                $(CAROUSE_TITLE).html(html+'<a data-toggle="tab" href="#tab1">列表显示</a>');
                $(TABLE_TITLE).html(html + '<a data-toggle="tab" href="#tab2">图例显示</a>')
            }

        });
    }

}

function loadData(pid, id, type, areaId, endDatetime){
    $.get(SERVER_URL.current_pass,{deptId:id, deptPid:pid, type:type, areaId:areaId, endDatetime:endDatetime}, function(ret){

        var list = ret.data;
        // 这里重复赋值主要是填充数量
        var html = ""
        if(type){
            if(type == 1){
                $(HEADER).text("在岗人员");
                html='<span>在岗人员统计：</span>\n\t\t\t\t\t<span> 共 '+list.length+'人，  </span>\n';
            }else if (type == 2){
                $(HEADER).text("临时离岗人员");
                html='<span>临时离岗人员统计：</span>\n\t\t\t\t\t<span> 共 '+list.length+'人，  </span>\n';
            }else if (type == 3){
                $(HEADER).text("不在岗人员");
                html='<span>不在岗人员统计：</span>\n\t\t\t\t\t<span> 共 '+list.length+'人，  </span>\n';
            }
            $(CAROUSE_TITLE).html(html+'<a data-toggle="tab" href="#tab1">列表显示</a>');
            $(TABLE_TITLE).html(html + '<a data-toggle="tab" href="#tab2">图例显示</a>')
        }

        if(id){// 数量太多则不显示图例
            drawCarousel(list);
        }else {
            $('#tab2').removeClass('active')
            $('#tab1').addClass('active')
        }
        drawTable(list);

    });


}

function drawCarousel(list){
    if(!list || list.length==0){
        $("#carousel").html('没有数据');
        return;
    }
    var carouselHtml = '';
    for (var i = 0; i < list.length; i++) {
        var row = list[i];

        var activeStyle="border: 3px #fff solid;";
        var active = row.onworkStatus=='在岗'?true:false;
        carouselHtml += '<li>' +
            '<a href="javascript:goTrack('+row.userId+','+row.deptId+')">' +
            '<img src="data:image/jpeg;base64,'+(row.userPic || '')+'" active="'+active+'"/>' +
            '</a>' +
            '<div class="tooltip">' +
            '<div class="detail-name" style="">' +
            '<p>姓名：' + row.userName + '</p>' +
            '<p>部门：' + row.deptName + '</p>' +
            '<p>状态：' + row.onworkStatus + '</p>' +
            '</div>';
        carouselHtml += '</div></li>'
    }
    $(CAROUSEWRAP).html($(carouselHtml));
    var width = $(".panel-auto").width() * 0.8;
    var height = 450;


    $(CAROUSEWRAP).carousel({
        width: width,
        height: height,
        itemWidth: 100,
        itemHeight: 120,
        horizontalRadius: 270,
        verticalRadius: 85,
        resize: false,
        mouseScroll: false,
        mouseDrag: true,
        scaleRatio: 0.4,
        scrollbar: true,
        tooltip: true,
        mouseWheel: true,
        mouseWheelReverse: true
    });

}

function drawTable(list) {
    if(!list || list.length==0) {
        return;
    }
    var options = {
        serverSide:false,
        columns: [
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "orderable": false, "render":xh},
            { "data":"userName", "defaultContent":'',"name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"deptName", "defaultContent":'',"name": "部门" ,"title": "部门" ,"orderable": false},
            { "data":"areaName", "defaultContent":'',"name": "最后出现区域" ,"title": "最后出现区域" ,"orderable": false},
            { "data":"lastPasstime", "defaultContent":'',"name": "最后通行时间" ,"title": "时间" ,"orderable": false},
            { "data":"lastDirect", "defaultContent":'',"name": "进出方向" ,"title": "方向" ,"orderable": false},
            { "data":"onworkStatus", "defaultContent":'',"name": "状态" ,"title": "状态" ,"orderable": false,"render": renderOnworkStatus}

        ]
    }
    table = renderTable($(PASS_TABLE), list,{},options);

    function renderUserName(data, type,row,meta){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            return "<a href='javascript:goTrack("+row.userId+","+row.deptId+")'>"+data+"</a>";
        }
    }

    function renderOnworkStatus(data) {
        return "<span style='color:"+getLeaveColor(data)+"'>"+data+"</span>";
    }
}


function goTrack(userId, deptId){
    var user = getCacheObj(SESSION_USER);
    if(user){
        var role = user.dataRole;
        if(role.indexOf(ROLE.general)>-1 || role.indexOf(ROLE.middle)>-1){// 部门以下的权限 不可以查看其他部门的通行数据
            if(user.deptId == deptId){// 只可以看本部门的
                go("track/"+userId);
            }
        }else {// 其他权限可以查看
            go("track/"+userId);
        }
    }

}
