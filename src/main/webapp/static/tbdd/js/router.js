/* 启动函数 */



Q.reg('index',function(){
    checkLogin();
    load('home', "initHome");
}).reg('pass', function(){//记录查询
    load('pass',  "initPass");
}).reg('attendpass', function(type, deptId, deptPid){//记录查询
    load('attendpass',  "initAttendpass", {type:type, deptId:deptId, deptPid:deptPid});
}).reg('attend', function() {//综合考勤
    load('attend', "initAttend");
}).reg('track', function(userId, start, end) {//个人轨迹
    load('track', "initTrack", {userId: userId, starttime:start, endtime:end});
}).reg('onwork', function(pid, id, type,areaId, endDatetime){// 部门在岗情况
    load('onwork', "initOnwork", {deptPid:pid, deptId:id, type:type, areaId:areaId, endDatetime:endDatetime});
});


Q.init({
    key:'!',/* url里#和url名之间的分割符号 默认为感叹号 */
    index:'index',/* 首页地址 如果访问到不能访问页面也会跳回此页 */
    pop:function(L,arg){/* 每次有url变更时都会触发pop回调 */
        // console.log(L);
        layer.closeAll()
        checkLogin();

    }
});

function checkLogin(){
    var token = getUrlParams('access_token');
    // 校验登陆
    $.ajax({
        url:SERVER_URL.checklogin,
        data:{token:token},
        success:function(res){
            var user = res.data;
            if(user){
                setCahceObj(SESSION_USER, user);
            }else {
                layer.msg('登陆信息已失效，请重新登陆');
                setTimeout(function(){
                    window.location.href=DOMAIN+HTML_PATH+"login.html";
                },1000);
            }
        },
        async:false
    })
}
