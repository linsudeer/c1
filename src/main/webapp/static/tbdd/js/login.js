
$(function(){
    $(".loginInput").on('keyup', function(e){
        var account = $('#account').val();
        var password = $('#password').val();
        if(account && password){
            $('#loginSubmit').attr('disabled',false);
        }else {
            $('#loginSubmit').attr('disabled',true);
        }
    });

    $('#loginSubmit').on('click', function(e){
        login();
    });

    document.onkeydown=function(event){

        var e = event || window.event || arguments.callee.caller.arguments[0];


        if(e && e.keyCode==13){ // enter 键
            login();
        }
    };
});

function login(){
    var account = $('#account').val();
    var password = $('#password').val();
    $.post(SERVER_URL.login_valil,{username:account, password:password}, function (res) {
        if(res.code == 200){//登陆成功
            var user = res.data;
            setCahceObj(SESSION_USER, user);
            window.location.href=DOMAIN+HTML_PATH+"index.html";
        }else {
            layer.msg(res.msg);
        }
    })
}