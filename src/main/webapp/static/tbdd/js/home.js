/**
 * home页，显示主页面
 */

var RIGHT_TOTALPERSON = '#totalPerson';// 应在岗人员
var RIGHT_ONDUTYPERSON = '#onDutyPerson';//在岗人员
var RIGHT_TEMPOFFDUTYPERSON = '#tempOffDutyPerson';//临时离岗
var RIGHT_OFFDUTYPERSON = '#offDutyPerson';//不在岗人员

//初始化home页时加载的方法
function initHome() {

    //加载考勤排行数据
    setAttendRankData();
    drawOrgOnWorkBar();
    //绘制不同在岗状态饼图
    drawOnWorkByState('总体人员在岗统计', {deptPid:0});
    //绘制各个区域在岗统计饼图
    drawOnWorkByArea('在岗人员位置分布', {deptPid:0});
    //绘制上午下午上班时间分布饼图
    drawOnWorkByInTime('考勤情况统计', {deptPid:0});

    $('#totalPerson').parent('a').click(function(){
        // 实际在岗人数
        if($('#onDutyPerson').text()<=0) return;
        var path = 'onwork';
        path += "/0/0/0";
        go(path);
    });
    $('#onDutyPerson').parent('a').click(function(){
        // 实际在岗人数
        if($('#onDutyPerson').text()<=0) return;
        var path = 'onwork';
        path += "/0/0/1";
        go(path);
    });
    $('#tempOffDutyPerson').parent('a').click(function(){
        // 临时离岗
        if($('#tempOffDutyPerson').text()<=0) return;
        var path = 'onwork';
        path += "/0/0/2";
        go(path);
    });
    $('#offDutyPerson').parent('a').click(function(){
        //不在岗
        if($('#offDutyPerson').text()<=0) return;
        var path = 'onwork';
        path += "/1/0/3";
        go(path);
    });
}

//加载考勤排行数据
function setAttendRankData(){
    $.get(SERVER_URL.attend_statistics, function(result){
        var rankLength = 10;
        var data = result.data || [];
        var html = [];
        var length = data.length>rankLength?rankLength:data.length;
        for(var i=0;i<length;i++){
            var width = data[i].attendTime/35*100;
            width = (width>100)?100:width;
            width = width?width:0;
            html.push('<div class="text-left msg-block"><div class="span5"><div class=""><i class="icon icon-user paihangIcon"></i><a href="#!track/'+data[i].userId+'"><strong>'+data[i].userName+'</strong></a></div></div>');
            html.push('<div class="span6"><div class="progress progress-striped '+(i<3?"progress-success":(i<7?"":"progress-warning"))+'" title="'+data[i].attendTime+'小时"><div style="background-color:#058FFE;width: '+width+'%;">'+data[i].attendTime+'小时</div></div></div> </div>')
        }
        $('#paihang .msg-block').remove();
        $('#paihang').append(html.join(""));
    })
}
// 绘制 各部门在岗情况
function drawOrgOnWorkBar(isDraw, key,value){

    var url = SERVER_URL.org_onWorkList;
    if(key && value){
        url += "?"+key+"="+value;
    }
    $.get(url, function(ret){
        var myChart = echarts.init(document.getElementById('onWork24h'));

        var orgs = ret.data;
        if(!orgs) return;

        var xdata = [], ydata = [];
        for(var i=0;i<orgs.length;i++){
            if(!orgs[i].parentId) continue;
            xdata.push(orgs[i].deptName);
            var total = orgs[i].total==0?1:orgs[i].total;
            ydata.push({deptId:orgs[i].deptId,deptPid:orgs[i].parentId,deptName:orgs[i].deptName, value:(orgs[i].onWorkCnt/total).toFixed(2)*100,onWorkCnt:orgs[i].onWorkCnt});
        }


        // 指定图表的配置项和数据
        var option = {
            title:{show:false,text:"各部门在岗情况",textStyle:{color: '#fff'}},
            // tooltip:{trigger:"axis",formatter:"{a}<br/>{b}:{c0}人在岗<br/>占比{c}%"},
            tooltip:{trigger:"axis", axisPointer : {type : 'line'},formatter:function(params, ticket, callback){
                var data = params[0].data;
                var cnt = data.onWorkCnt;
                var content = "在岗情况<br/>"+data.deptName+"："+data.onWorkCnt+"人在岗<br/>到岗率："+params[0].value+"%";
                return content;
            }},
            color:["#79c4e7"],// 替换5ac0c8
            grid:{x:50,y:10,x2:10,y2:30,show:false},
            legend: {show:true, data:['到岗率']},
            xAxis:{type : 'category',boundaryGap:true,data:xdata,axisLabel:{textStyle:{color:"#FFFFFF"},interval:0},axisTick: {show: false},splitLine: {show: false}},
            yAxis:{type:"value",min:0, max:100,axisLabel:{textStyle:{color:"#FFFFFF"},formatter: '{value} %'},splitLine: {show: true,lineStyle:{color: ['#252d39']}},axisTick: {show: false},nameTextStyle:{color:"#FFFFFF"}},
            series: [
                {name: '在岗情况',barWidth:40,smooth:false,symbol:"none",type: 'bar',data: ydata},
                ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option, isDraw);
        myChart.off('click');//先清除事件，再创建，防止出现多次加载事件
        myChart.on('click', function(p){
            if(p.data.value<=0) return;
            var path = 'onwork';
            p.data.deptId = p.data.deptId?p.data.deptId:0;
            p.data.deptPid = p.data.deptPid?p.data.deptPid:0;
            path += "/"+p.data.deptPid+"/"+p.data.deptId+"/1";
            go(path);
        });
    });

}
//绘制24小时实时在岗数据折线图
function draw24hData(isDraw, params){
    var myChart = echarts.init(document.getElementById('onWork24h'));
    var url = SERVER_URL.current_24h;

    $.get(url, params, function(res){

        var axisLabel = {textStyle:{color:"#FFFFFF"}};

        var option={
            title:{show:false,text:"",textStyle:{color: '#fff'}},
            tooltip:{trigger:"axis",formatter:"{b} - {c}人在岗"},
            grid:{left:30,top:20,right:20,bottom :30,show:false},
            color:["#adff2f"],
            legend:{show:false,data:["在岗人数"]},
            calculable:true,
            xAxis:{type:"category",boundaryGap:false,data:getAxis(res),axisLabel:axisLabel,axisTick: {show: false},splitLine: {show: false}},
            yAxis:{type:"value",name:"人数（人）",axisLabel:axisLabel,splitLine: {show: true,lineStyle:{color: ['#252d39']}},axisTick: {show: false}},
            series:[{type:"line",showSymbol:false,smooth:true,symbolSize:4,data:getData(res)}]
            //,name:seriesName
        };

        myChart.setOption(option, isDraw);
        myChart.off('click');//先清除事件，再创建，防止出现多次加载事件
        myChart.on('click', function(p){
            if(p.data.value<=0) return;
            var path = 'onwork';
            p.data.deptId = p.data.deptId?p.data.deptId:0;
            p.data.deptPid = p.data.deptPid?p.data.deptPid:0;
            var datetime = new Date().format('yyyy-MM-dd')+" "+p.data.endDatetime+':00'
            path += "/"+p.data.deptPid+"/"+p.data.deptId+"/4/0/"+datetime;
            go(path);
        });

    });

    //x轴坐标
    function getAxis(res){
        /*if(!res.data) return;
        var list = [];
        for(var i=0;i<res.data.length; i++){
            list.push((res.data[i].dataTime));
        }
        return list;*/

        var xAxis = [];
        for(var i=0; i<24; i++){
            for(var j=4;j<60; j+=5){
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
            list.push({value:res.data[i].dataCount, deptId:params.deptId,deptPid: params.deptPid,endDatetime:res.data[i].dataTime});
        }
        return list;
    }

}
//绘制不同在岗状态饼图
function drawOnWorkByState(title, params){

    var elem = '#chart1';

    $(elem+' h5').text(title);

    $.get(SERVER_URL.current_typegroup,params, function(res){
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
        drawPie($(elem+" .chart")[0], legendData, data, function(p){
            if(p.data.value<=0) return;
            var path = 'onwork';
            if(params.deptId){
                path += "/"+params.deptPid+"/"+params.deptId+"/"+p.data.attendType;
            }else {
                path += "/"+params.deptPid+"/0/"+p.data.attendType;
            }
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
function drawOnWorkByArea(title,params){
    var elem = '#chart2';
    $(elem+' h5').text(title);
    $.get(SERVER_URL.current_areagroup,params, function(res){
        var list = res.data;
        var legendData = [];
        var data = [];
        for(var i=0;i<list.length;i++){
            legendData.push(list[i].name);
            data.push({areaId:list[i].id, value:(list[i].count || 0), name:list[i].name, deptId:list[i].deptId});
        }
        drawPie($(elem+" .chart")[0], legendData, data, function(p){
            if(p.data.value<=0) return;
            var path = 'onwork';
            if(params.deptId){
                path += "/"+params.deptPid+"/"+params.deptId+"/1/"+p.data.areaId;
            }else {
                path += "/"+params.deptPid+"/0/1/"+p.data.areaId;
            }
            go(path);
        });

    });

}
//绘制上午下午上班时间分布饼图
function drawOnWorkByInTime(title, params){
    var elem = '#chart3';

    $(elem+' h5').text(title);

    $.get(SERVER_URL.current_count_attend,params, function(ret){
        var data = ret.data;
        var legendData = [], xdata = [];
        if(data){
            for(var i=0;i<data.length;i++){
                legendData.push(data[i].name);
                xdata.push({attendType:data[i].id,value:data[i].count,name:data[i].name})
            }
        }
        drawPie($(elem+" .chart")[0], legendData, xdata, function(p){
            if(p.data.value<=0) return;
            var deptId = params.deptId?params.deptId:0;
            var deptPid = params.deptPid?params.deptPid:0;
            var path = 'attendpass/'+p.data.attendType+"/"+deptId+"/"+deptPid;
            go(path);
        });
    });




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
    myChart.off('click');//先清除事件，再创建，防止出现多次加载事件
    myChart.on('click', clickEvent);
}