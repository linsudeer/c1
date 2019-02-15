
// 加载头部时初始化方法
var PASS_UNAME = "#addPassWrap select[name='userId']"; // 用户名
var PASS_AREA = "#addPassWrap select[name='areaId']";//区域
var PASS_DIRECT = "#addPassWrap select[name='direct']";//进出方向
var PASS_RECORD_ID ="#addPassWrap input[name='recordId']";
var PASS_REMARK = "#addPassWrap input[name='remark']";



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
    renderSelect($(PASS_UNAME),'姓名', SERVER_URL.code_user);
    renderSelect($(PASS_AREA),'区域', SERVER_URL.code_area);
    renderSelect($(PASS_DIRECT),'进出方向', SERVER_URL.code_direct);
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

function savePass(){
    var params = $("addPassWrap>form").serializeJSON();
    if(!params.userId){
        layser.msg("请选择姓名");
        return;
    }
    if(!params.areaId){
        layser.msg("请选择区域");
        return;
    }
    if(!params.direct){
        layser.msg("请选择方向");
        return;
    }
    if(!params.passDatetime){
        layser.msg("请选择时间");
        return;
    }

    var recordId = $(PASS_RECORD_ID).val();
    if(recordId){// 编辑
        $.post(SERVER_URL.pass_edit,params, function(ret){
            var record = ret.data;
            layser.msg('修改成功!');
            // 这里首页更新一行记录
            table.row(index).data(record);
        });
    }else {//新增
        $.post(SERVER_URL.pass_add,params, function(ret){
            var record = ret.data;
            layser.msg('成功!');
            // 这里首页新增一行记录
            table.row.add(record);
        });
    }
}