
// 加载头部时初始化方法
var QUERY_UNAME = "#addPassWrap select[name='userId']"; // 用户名
var QUERY_AREA = "#addPassWrap select[name='areaId']";//区域
var QUERY_DIRECT = "#addPassWrap select[name='direct']";//进出方向

var PASS_DATETIME = "#addPassWrap #passDatetime";//开始时间

var PASS_ADD_WRAP = "#addPassWrap";// 新增记录，编辑记录弹出框

function initHead(){

    $('#header li').on('mouseover', function(){
        $(this).children('div').css('display','block');
    });

    $('#header li').on('mouseleave', function(){
        $(this).children('div').css('display','none');
    });

    $('#logout').on('click', function(e){
        $.post(SERVER_URL.logout, function(res){
            if(res.code==200){
                localStorage.setItem(SESSION_USER, '');
                window.location.href=DOMAIN+HTML_PATH+"login.html";
            }
        });
    });

    // 初始化公用部分
    renderSelect($(QUERY_UNAME),'姓名', SERVER_URL.code_user);
    renderSelect($(QUERY_AREA),'区域', SERVER_URL.code_area);
    renderSelect($(QUERY_USERGROUP),'人员类型', SERVER_URL.code_usergroup);
    renderSelect($(QUERY_DIRECT),'进出方向', SERVER_URL.code_direct);
    laydate.render({ elem: PASS_DATETIME, type: 'datetime'});

    setData();

}

function setData(){
    //设置用户名
    var user = getCacheObj(SESSION_USER);
    if(user){
        $('#headerUserName').text(user.userName);
    }

}