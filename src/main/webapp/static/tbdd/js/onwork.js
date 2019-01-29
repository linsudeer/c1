
var HEADER = "#content-header .current";
var CAROUSE_TITLE = "#carouselTitle";
var TABLE_TITLE = "#tableTitle";
var PASS_TABLE = "#passTable";
var CAROUSEWRAP = "#carousel";

function initOnwork(params){
    setTitleData(params.deptPid, params.deptId);
    loadData(params.deptPid, params.deptId);

}

/**
 * 设置标题
 */
function setTitleData(deptPid, deptId){
    $.get(SERVER_URL.current_typegroup,{deptId:deptId, deptPid:deptPid}, function(res){
        var data = res.data;
        var onCnt=0, offCnt=0, total=0;
        var deptName='';
        if(data && data.length>0){
            for(var i=0;i<data.length;i++){
                if(data[i].id==1){
                    onCnt = data[i].count;
                }else {
                    offCnt = data[i].count;
                }
            }
            total = onCnt+offCnt;
            deptName = data[0].deptName;
        }
        $(HEADER).text(deptName+"在岗人员");
        var html='<span>'+deptName+'人员统计：</span>\n' +
            '\t\t\t\t\t<span> 共 '+total+'人，  </span>\n' +
            '\t\t\t\t\t<span> 在岗'+onCnt+'人， </span>\n' +
            '\t\t\t\t\t<span> 不在岗'+offCnt+'人。</span>';
        $(CAROUSE_TITLE).html(html+'<a data-toggle="tab" href="#tab1">列表显示</a>');
        $(TABLE_TITLE).html(html + '<a data-toggle="tab" href="#tab2">图例显示</a>')
    });
}

function loadData(pid, id){

    $.get(SERVER_URL.current_pass,{deptId:id, deptPid:pid}, function(ret){
        var list = ret.data;
        if(list && list.length<100){// 数量太多则不显示图例
            drawCarousel(list);
        }else {
            // $('#tab1').removeClass('active')
            // $('#tab2').addClass('active')
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
            '<a href="#!track/'+row.userId+'">' +
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
            { "data":null, "width":50, "name": "序号" ,"title": "序号", "render":xh},
            { "data":"userName", "name": "姓名" ,"title": "姓名" ,"orderable": false, "render":renderUserName},
            { "data":"deptName", "name": "部门" ,"title": "部门" ,"orderable": false},
            { "data":"areaName", "name": "最后出现区域" ,"title": "最后出现区域" ,"orderable": false},
            { "data":"lastPasstime", "name": "最后通行时间" ,"title": "时间" ,"orderable": false},
            { "data":"lastDirect", "name": "进出方向" ,"title": "方向" ,"orderable": false},
            { "data":"onworkStatus", "name": "状态" ,"title": "状态" ,"orderable": false,"render": renderOnworkStatus}

        ]
    }
    table = renderTable($(PASS_TABLE), list,{},options);



    function renderUserName(data, type,row,meta){
        if(row.userId<=0){
            return '<a href="javascript:void(0)">--</a>';
        }else {
            return "<a href='#!track/"+row.userId+"'>"+data+"</a>";
        }
    }

    function renderOnworkStatus(data) {
        return "<span style='color:"+getLeaveColor(data)+"'>"+data+"</span>";
    }
}

