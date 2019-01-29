
var SESSION_USER = "session_user";
//---------- 页面ID
var INDEX_MAIN_ID = "#main";
var HOME_TREE_ID = "#deptTree";

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
        console.log("load "+url);
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
        backColor:'#2a3747',
        selectable: true,
        borderColor:'#2a3747',
        expandIcon: 'glyphicon glyphicon-plus',
        collapseIcon: 'glyphicon glyphicon-minus',
        emptyIcon:'glyphicon',
        onhoverColor:"rgba(39, 169, 227, 0.3)",

    });

    $(HOME_TREE_ID).on('nodeSelected', function(event, data) {
        selected(event, data);
    });

    $(HOME_TREE_ID).on('click', '.list-group-item .badge', function(event, data) {
        event.stopPropagation();
        var $li = $(this).parent('li');
        var nodeid = $li.attr('data-nodeid');
        var node = $(HOME_TREE_ID).treeview('getNode',nodeid);
        clickBadge(event, node);
    });

}

function renderSelect(elem, placeholder, data, params,change) {
    elem.val('');
    var options = {
        minimumInputLength: 5,
        tags: false,//允许手动添加
        allowClear: true,//允许清空
        language: "zh-CN",
        minimumInputLength: 0
    }

    options.placeholder = placeholder?placeholder:'';

    if(typeof data == 'array'){
        options.data = data;
    }else {
        var url = data;
        options.ajax = {
            url: url,
            delay: 250,
            dataType: 'json',
            quietMillis: 250,
            data: function (term) {
                var p = params?params:{};
                p.limit = 10;
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

    if(typeof change == 'function'){
        elem.on('change', function(e){
            change(e);
        });
    }


}

function renderTable(elem, url, data, options){
    if(!url) return;
    options = options?options:{};
    options.bJQueryUI = true;
    options.pagingType = 'full_numbers';
    options.sDom = 't<"row-fluid"lipB>';
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
                json.draw = json.data;
                json.recordsTotal = json.total;
                json.recordsFiltered = json.total;

                return json.data;
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

Date.prototype.curdate = function (){
    return this.format('yyyy-MM-dd');
}

Date.prototype.minOfCurdate = function(){
    return this.format('yyyy-MM-dd 00:00:00');
}

Date.prototype.maxOfCurdate = function(){
    return this.format('yyyy-MM-dd 23:59:59');
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
    if(hash === path) {
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
    switch (type){
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
            color = "#fff";
    }
    return color;
}

var tipIndex;
function tip(data, elem){
    tipIndex = layer.tips(data, elem, {tips: [2, '#6d7cb8'],time:0});
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


