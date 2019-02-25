
var lastPasstime = '';
$(function(){
	//检测心跳程序
	hearBeat();
	//时间
	calendar();
});

function calendar(){
	setInterval(function(){
		var curDate = new Date();
		var time = curDate.format("hh:mm:ss")
		$("#screen #hourAndMin").html(time);
		var date = curDate.format('yyyy年MM月dd日')
		$("#screen #dateWeekTime").html(date+"&nbsp;&nbsp;"+curDate.getWeek());
	}, 1000);
}

function hearBeat(){
	setInterval(function(){
		$.get(SERVER_URL.screen_heartbeat,function(result){
			var data = result.data;//最新一条数据的时间
			if(data.passDatetime>lastPasstime){
				show(data.passRecordId);
				lastPasstime = data.passDatetime;
			}
		});
	},1000);
}

function show(recordId){
	$.get(SERVER_URL.screen_data,{passRecordId:recordId}, function(result){
			var data = result.data;
			var username = '',picUrl = '',direct = '';
			username= data.userName;
			picUrl = data.picUrl;
			direct = data.direct=='进'?'进入':'离开';
			passtime = data.passDateTime;
			passtime = passtime.substr(11,5);
			if(!username){
				username = '<font color="red">访客</font>';
			}
			$("#screen #screenTitle").html(data.title);
			$("#screen #header").attr("src",picUrl);
			$("#screen #topOneInfo").html(username+'已于'+passtime+'<br>'+direct+data.areaName);
			$("#screen #allTotal").html('截至目前，'+data.areaName+'域已进入 <span style="color: #FFFF00">'+data.allTotalCnt+'</span>人次，'+data.cmpName+'<span style="color: #FFFF00">'+data.allSelfCnt+'</span>人次，访客<span style="color: #FFFF00">'+data.allOtherCnt+'</span>人次。');
			$("#screen #todayTotal").html('今日进入'+data.areaName+'<span style="color: #FFFF00">'+data.todayTotalCnt+'</span>人次，'+data.cmpName+'<span style="color: #FFFF00">'+data.todaySelfCnt+'</span>人次，访客<span style="color: #FFFF00">'+data.todayOtherCnt+'</span>人次。');

			var lis = $('.btn-ul>li');
			if(lis.length<5){
				$('#screen .btn-ul').prepend('<li><img src="'+picUrl+'"></li>');
			}else{
				$('#screen .btn-ul li:last-child').remove();
				$('#screen .btn-ul').prepend('<li><img src="'+picUrl+'"></li>');
			}
	});
}
