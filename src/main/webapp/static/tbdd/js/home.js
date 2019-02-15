/**
 * home页，显示主页面
 */

var RIGHT_TOTALPERSON = '#totalPerson';// 应在岗人员
var RIGHT_ONDUTYPERSON = '#onDutyPerson';//在岗人员
var RIGHT_TEMPOFFDUTYPERSON = '#tempOffDutyPerson';//临时离岗
var RIGHT_OFFDUTYPERSON = '#offDutyPerson';//不在岗人员

//初始化home页时加载的方法
function initHome() {
    // 加载区域数据
    setAreaData();
    //加载部门树数据
    setDeptTreeData();
    // 加载应在岗人数，在岗，离岗，不在岗等统计数据

    //加载考勤排行数据

    //绘制24小时实时在岗数据折线图
    draw24hData();
    //绘制不同在岗状态饼图
    drawOnWorkByState('总体人员在岗统计');
    //绘制各个区域在岗统计饼图
    drawOnWorkByArea('在岗人员位置分布');
    //绘制上午下午上班时间分布饼图
    drawOnWorkByInTime('考勤情况统计');
    //绘制某个区域本单位和访客人数统计饼图

    //绘制某个区域各部门在岗情况统计饼图

    //绘制某个区域进出人次统计饼图
}
// 加载区域数据
function setAreaData() {

    $.get(SERVER_URL.area_list, function(res){
        var data = res.data;
        if(Array.isArray(data)){
            data[4]={areaId:0, areaName:'总体情况'}
            for(var i=1;i<=4;i++){
                $('.area-'+i).attr('data-id', data[i].areaId);
                $('.area-'+i+' .leftNavText').html(data[i].areaName);

                //监听事件，点击后首页数据变化
                $('.area-'+i).on('click',{id:data[i].areaId}, function(e){
                    var areaId = e.data.id;
                    draw24hData(true,'areaId', areaId);
                });
            }


        }
    });
}
//加载部门树数据
function setDeptTreeData() {
    $.get(SERVER_URL.org_onWorkTree, {pid: 0},function(res){
        var data = res.data;
        renderTree(data, function(event, data){
            if(data.type==1){// 单位
                draw24hData(true,'deptPId', data.id);
            }else if(data.type==2){// 部门
                draw24hData(true,'deptId', data.id);
            }else {// 所有
                draw24hData(true);
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
// 加载应在岗人数，在岗，离岗，不在岗等统计数据
function setOnWorkStateData(){

}
//加载考勤排行数据
function setAttendRankData(){

}
//绘制24小时实时在岗数据折线图
function draw24hData(isDraw, key,value){

    var url = SERVER_URL.current_24h;
    if(key && value){
        url += "?"+key+"="+value;
    }
    $.get(url, function(res){

        var axisLabel = {textStyle:{color:"#FFFFFF"}};

        var option={
            title:{show:false,text:"",textStyle:{color: '#fff'}},
            tooltip:{trigger:"axis",formatter:"{b} - {c}人在岗"},
            grid:{x:30,y:20,x2:20,y2:30,show:false},
            color:["#adff2f"],
            legend:{show:false,data:["在岗人数"]},
            calculable:true,
            xAxis:{type:"category",boundaryGap:false,data:getAxis(),axisLabel:axisLabel,axisTick: {show: false},splitLine: {show: false}},
            yAxis:{type:"value",name:"人数（人）",axisLabel:axisLabel,splitLine: {show: true,lineStyle:{color: ['#252d39']}},axisTick: {show: false}},
            series:[{type:"line",smooth:true,symbol:"none",data:getData(res)}]
            //,name:seriesName
        };
        var myChart = echarts.init(document.getElementById('onWork24h'));
        myChart.setOption(option, isDraw);
        myChart.on('click', function(param){
            alert('点击了');
        });

    });

    //x轴坐标
    function getAxis(){
        var xAxis = [];
        for(var i=0; i<24; i++){
            for(var j=0;j<60; j+=5){
                xAxis.push((i<10?'0':'') + i + ":" + (j<10?'0':'') + j );
            }
        }
        return xAxis;
    }

    /**
     * 查询的数据
     * @returns {Array}
     */
    function getData(res){
        if(!res.data) return;
        var list = [];
        for(var i=0;i<res.data.length; i++){
            list.push(res.data[i].dataCount);
        }
        return list;
    }

}
//绘制不同在岗状态饼图
function drawOnWorkByState(title){

    var elem = '#chart1';

    $(elem+' h5').text(title);

    $.get(SERVER_URL.current_typegroup, function(res){
        var list = res.data;
        if(!list) return;
        var legendData = [];
        var data = [];
        var onDutyCnt = 0, tempOffDutyPerson=0,offDutyPerson=0;
        for(var i=0;i<list.length;i++){
            legendData.push(list[i].name);
            data.push({attendType:list[i].id, value:(list[i].count || 0), name:list[i].name});
            if(list[i].id==1){
                onDutyCnt = list[i].count;
            }else if(list[i].id==2){
                tempOffDutyPerson = list[i].count;
            }else if(list[i].id==3){
                offDutyPerson = list[i].count;
            }
        }
        drawPie($(elem+" .chart")[0], legendData, data, function(param){
            var path = 'onwork';
            path += "/0/0/"+param.data.attendType;
            go(path);
        });

        // 同时填充右侧人数
        $(RIGHT_ONDUTYPERSON).text(onDutyCnt);
        $(RIGHT_TEMPOFFDUTYPERSON).text(tempOffDutyPerson);
        $(RIGHT_OFFDUTYPERSON).text(offDutyPerson);
        $(RIGHT_TOTALPERSON).text(onDutyCnt+tempOffDutyPerson+offDutyPerson);

    });
}
//绘制各个区域在岗统计饼图
function drawOnWorkByArea(title){
    var elem = '#chart2';
    $(elem+' h5').text(title);
    $.get(SERVER_URL.current_areagroup, function(res){
        var list = res.data;
        if(!list) return;
        var legendData = [];
        var data = [];
        for(var i=0;i<list.length;i++){
            legendData.push(list[i].name);
            data.push({areaId:list[i].id, value:(list[i].count || 0), name:list[i].name});
        }
        drawPie($(elem+" .chart")[0], legendData, data, function(param){
            alert(param.name);
        });

    });

}
//绘制上午下午上班时间分布饼图
function drawOnWorkByInTime(title){
    var elem = '#chart3';

    $(elem+' h5').text(title);

    var legendData = ["正常到岗人数","迟到10分中以内","迟到30分中以内","迟到60分中以内","未到岗人数"];
    var data = [];
    data.push(
        {attendType:1,deptId:1,value:85,name:"正常到岗人数"},
        {attendType:2,deptId:1,value:10,name:"迟到10分中以内"},
        {attendType:3,deptId:1,value:15,name:"迟到30分中以内"},
        {attendType:3,deptId:1,value:15,name:"迟到60分中以内"},
        {attendType:3,deptId:1,value:15,name:"未到岗人数"}
    );

    drawPie($(elem+" .chart")[0], legendData, data, function(param){
        alert(param.name);
    });


}
//绘制某个区域本单位和访客人数统计饼图
function drawStaticByUserType(){

}
//绘制某个区域各部门在岗情况统计饼图
function drawOnWorkByDept(){

}
//绘制某个区域进出人次统计饼图
function drawStaticByDirect(){

}


function drawPie(elem , legendData, data, clickEvent){
    var option={
        title:{show:false,x:'left',textStyle:{color: '#081438'}},
        tooltip:{trigger:'item',formatter:"{a} <br/>{b} : {c} 人次<br/>占比{d}%"},
        legend:{orient : 'vertical',x:'right',data:legendData,textStyle:{color:'#ffffff'}},
        color:['#24bc94','#f2a134','#888d95'],
        // color:getColors(legendData.length),
        series:[{
            name:'在岗情况',type:'pie',radius:'65%',center:['45%','50%'],
            itemStyle:{normal:{label:{show:true,position:'outer',formatter:'{c}'},labelLine:{show:true}}},
            data:data
        }]
    };
    var myChart = echarts.init(elem,"macarons");
    myChart.setOption(option)
    myChart.on('click', clickEvent);
}