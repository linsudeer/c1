
var SESSION_USER = "session_user";
//---------- 页面ID
var INDEX_MAIN_ID = "#main";
var HOME_TREE_ID = "#deptTree";

var SENIOR_DEPT_ID = 5;// senior对应的部门权限，多了一个军事办，这里是军事办的部门id

var ROLE = {
    /**
     * 拥有最大权限，可以查看系统所有数据，以及所有修改权限；可以查看后台管理系统
     */
    admin: "admin",

    /**
     * 拥有高级权限，可以查看所有数据，但是可以修改大队领导和军事办的权限
     */
    senior: "senior",

    /**
     * 拥有中级权限，可以查看本部门以及修改所有本部门的数据
     */
    middle: "middle",

    /**
     * 拥有普通用户的权限，可以查看1.本部门所有数据，但不可以修改数据2.可以查看其他部门的基本数据，除过与通行记录有关的数据
     */
    general: "general",

    /**
     * 可以查看所有数据，但是不能修改任何数据
     */
    role_view: "view"
}



var SUCCESS = 200;
var NOLOGIN = -1;

// 权限角色
var ROLE = {
    admin:"admin",
    senior:"senior",
    middle:"middle",
    general:"general"
}

$(function(){
    layer.config({
        // skin: 'purple-class',
        zIndex:100
    })

    $.ajaxSetup( {
        url: "/index.html" , // 默认URL
        aysnc: false , // 默认同步加载
        beforeSend: function(xhr){

        },
        error: function(jqXHR, textStatus, errorMsg){ // 出错时默认的处理函数
            // alert( '发送AJAX请求到"' + this.url + '"时出错[' + jqXHR.status + ']：' + errorMsg );
        }
    });

});

/**
 * 加载html页面
 * @param path 页面路径
 * @param callback 回调函数
 * @param params 页面参数
 */
function load(path, callback, params){
    var url = DOMAIN+HTML_PATH+path+'.html';
    $(INDEX_MAIN_ID).load(url,'',function(response,status,xhr){
        if(typeof callback == 'function'){
            callback(params);
        }
    });
}

/**
 * 渲染树结构
 * @param data
 */
function renderTree(data, selected, clickBadge){
    $(HOME_TREE_ID).treeview({
        data: data,
        showTags: true,
        backColor:'rgba(47,60,80,0.5)',
        selectable: true,
        borderColor:'rgba(47,60,80,0)',
        expandIcon: 'glyphicon glyphicon-plus',
        collapseIcon: 'glyphicon glyphicon-minus',
        emptyIcon:'glyphicon',
        onhoverColor:"rgba(39, 169, 227, 0.3)",

    });

    $(HOME_TREE_ID).on('nodeSelected', function(event, data) {
        if(typeof selected == 'function'){
            selected(event, data);
        }

    });

    $(HOME_TREE_ID).on('click', '.list-group-item .badge', function(event, data) {
        event.stopPropagation();
        var $li = $(this).parent('li');
        var nodeid = $li.attr('data-nodeid');
        var node = $(HOME_TREE_ID).treeview('getNode',nodeid);
        clickBadge(event, node);
    });

}

function renderSelect(elem, placeholder, data, params,change, load) {
    elem.val('');
    var options = {
        minimumInputLength: 0,
        tags: false,//允许手动添加
        allowClear: true,//允许清空
        language: "zh-CN"
    }

    options.placeholder = placeholder?placeholder:'';

    if(typeof data == 'array'){
        options.data = data;
    }else {
        var url = data;

        // 先加载
        /*var p = params?params:{};
        $.ajax({
            dataType : 'json',
            type : 'get',
            url : url,
            async : false,
            data:p,
            success: function(ret){
                options.data = ret.data;
            }
        });*/

        // 后加载
        options.ajax = {
            url: url,
            delay: 250,
            dataType: 'json',
            quietMillis: 250,
            data: function (term) {
                var p = params?params:{};
                p.limit = 50;
                p.key = term.term;
                return p;
            },
            processResults: function (res, params) {

                return {
                    results: res.data
                };
            },
            cache: true
        }
    }
    elem.select2(options);

    // 改变事件
    elem.on('change', function(e){
        if(typeof change == 'function'){
            change(e);
        }
    });
}

/**
 * 给select2设置值
 * @param elem
 * @param value
 */
function setSelect2Val(elem, key, value){
    elem.append('<option value="'+key+'">'+value+'</option>');
    elem.val(key).trigger("change")
}

function renderTable(elem, url, data, options){
    if(!url) return;
    options = options?options:{};
    options.bJQueryUI = true;
    options.pagingType = 'full_numbers';
    options.sDom = 't<"row-fluid"lipB>';//'t<"row-fluid"lipB>';
    options.bFilter = false;
    options.processing = true;
    options.bPaginate=true;
    options.iDisplayLength = 8;
    options.iDisplayStart = 0;
    options.aLengthMenu = [8, 20, 50, 100 ];
    options.autoWidth = true;
    options.asStripeClasses = ['strip1','strip2'];
    options.oLanguage = {
        sSearch: "筛选:",
        sEmptyTable:"没有数据",
        sInfoEmpty:"显示第 0 条到第 0 条数据，共有 0 条数据",
        sInfo: "显示第 _START_ 条到第 _END_ 条数据，共有 _TOTAL_ 条数据",
        sLengthMenu: '显示 _MENU_ 条记录',
        oPaginate: {
            "sPrevious": "上页","sNext": "下页","sLast": "末页","sFirst": "首页"
        }
    }
    if(!options.buttons){
        options.buttons = [];
    }
    if(Array.isArray(url)){
        options.serverSide = false;
        options.data = url;
    }else {
        if(typeof options.serverSide == 'undefined'){
            options.serverSide = true;
        }
        options.ajax = {
            url: url,
            data:data,
            dataSrc: function (json) {
                if(json.data && json.data.length>0){
                    json.draw = json.data;
                }

                json.recordsTotal = json.total;
                json.recordsFiltered = json.total;

                return json.data || [];
            }

        }
    }


    return elem.DataTable(options);
}

function xh(data, type,row,meta){
    return meta.row+1;
}

function thumb_onerror(img){
    img.oldSrc = img.oldSrc || img.src;
    img.oldHref=img.oldHref || $(img).parent("a[data-lightbox]").attr("href");
    img.onclick = function(){
        if(this.src != this.oldSrc)
        {
            this.src = this.oldSrc;
            //下面这个代码会在点击重新加载图片时，跳转到大图
            //$(img).parent("a[data-lightbox]").attr("href",img.oldHref);
            img.onclick = undefined;
        }
        event && event.stopPropagation && event.stopPropagation();
    }
    img.src ="../img/image-error.jpg";
    $(img).parent("a[data-lightbox]").attr("href","#");
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.format = function(fmt){
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

Date.prototype.getWeek = function() {
    var day = this.getDay();
    var weeks = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    var week = weeks[day];
    return week;
}

Date.prototype.curdate = function (){
    return this.format('yyyy-MM-dd');
}

Date.prototype.minOfCurdate = function(){
    return this.format('yyyy-MM-dd 00:00:00');
}

Date.prototype.maxOfCurdate = function(){
    return this.format('yyyy-MM-dd 23:59:59');
}
//上周周一
Date.prototype.getPreMonday = function(){
    return this.getMonday(-1);
}
//上周周日
Date.prototype.getPreSunday = function(){
    return this.getSunday(-1);
}

/**
 * 获得当前周 前n周周一（+n）或后n周周一（-n）
 */
Date.prototype.getMonday = function(n){
    var c = n<0?-6:6;
    this.setDate(this.getDate()+(n*this.getDay()+c));
    return this;
}
/**
 * 获得当前周 前n周周日（+n）或后n周周日（-n）
 */
Date.prototype.getSunday = function(n){
    this.setDate(this.getDate()+(n*this.getDay()));
    return this;
}
function parseDate(str){
    return new Date(Date.parse(str.replace(/\-/g,"/")));
}


function getColor(){
    var colors=['#fffc79ee',"#06f1c9ee","#04b4f0ee", "#FFB90F", "#FF3030", "#F0F8FF", "#EEA2AD", "#C71585", "#CAE1FF", "#8B8989"];
    var n = parseInt(Math.random()*10);
    return colors[n];
}

function getColors(n){
    var colors = [];
    for(var i=0;i<n;i++){
        colors.push(getColor());
    }
    return colors;
}

function go(path) {
    var hash = location.hash.replace('#!', '');
    if(hash == path) {
        location.reload(true);
    }else {

        Q.go(path);
    }

}

/**
 * 根据类型显示不同颜色
 * @param type 正常，补休，出差
 */
function getLeaveColor(type){
    var color = "";
    /*switch (type){
        case '病假':
            color = 'orange';
            break;
        case '临时外出':
            color = "purple";
            break;
        case '联指值勤':
            color = "purple";
            break;
        case '补休':
            color = "#48D1CC";
            break;
        case '借调':
            color = "#AFEEEE";
            break;
        case '事假':
            color = "#EE82EE";
            break;
        case '调学':
            color = "#6495ED";
            break;
        case '休假':
            color = "#FF7F50";
            break;
        case '外执任务':
            color = "purple";
            break;
        case '出差':
            color = "#4169E1";
            break;
        case '见习锻炼':
            color = "purpul";
            break;
        default:
            color = "";
    }*/
    return color;
}

var tipIndex;
function tip(content, elem, pos){
    tipIndex = layer.tips(content, elem, {tips: [pos?pos:2, '#6d7cb8'],time:0});
}

function closeTip() {
    layer.close(tipIndex);
}

/**
 * 存储到localstorage
 * @param key
 * @param value
 */
function setCahceObj(key, value){
    localStorage.setItem(key, JSON.stringify(value));
}

/**
 * 从缓存获取
 * @param key
 * @returns {any}
 */
function getCacheObj(key) {
    var value = localStorage.getItem(key);
    if(value){
        return JSON.parse(value);
    }
}

function auth(){
    var user = getCacheObj(SESSION_USER);
    if(!user){
        layer.msg('您没有权限登陆');
        setTimeout(function(){
            window.location.href=DOMAIN+HTML_PATH+"login.html";
        },1000);
    }else {

    }

}


