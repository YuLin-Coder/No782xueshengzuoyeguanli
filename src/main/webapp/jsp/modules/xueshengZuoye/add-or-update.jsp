<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑学生作业</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">学生作业管理</li>
                        <li class="breadcrumb-item active">编辑学生作业</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">学生作业信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <%--<div class="form-group col-md-6">--%>
                                        <%--<label>老师</label>--%>
                                        <%--<div>--%>
                                            <%--<select id="laoshiSelect" name="laoshiSelect"--%>
                                                    <%--class="selectpicker form-control"  data-live-search="true"--%>
                                                    <%--title="请选择" data-header="请选择" data-size="5">--%>
                                            <%--</select>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <div class="form-group col-md-6">
                                        <label>老师姓名</label>
                                        <input id="laoshiName" name="laoshiName" class="form-control"
                                               placeholder="姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>老师身份证号</label>
                                        <input id="laoshiIdNumber" name="laoshiIdNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>老师手机号</label>
                                        <input id="laoshiPhone" name="laoshiPhone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <%--<div class="form-group col-md-6">--%>
                                        <%--<label>学生</label>--%>
                                        <%--<div>--%>
                                            <%--<select id="yonghuSelect" name="yonghuSelect"--%>
                                                    <%--class="selectpicker form-control"  data-live-search="true"--%>
                                                    <%--title="请选择" data-header="请选择" data-size="5">--%>
                                            <%--</select>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <div class="form-group col-md-6">
                                        <label>学生姓名</label>
                                        <input id="name" name="name" class="form-control"
                                               placeholder="姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>学生身份证号</label>
                                        <input id="idNumber" name="idNumber" class="form-control"
                                               placeholder="身份证号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>手机号</label>
                                        <input id="phone" name="phone" class="form-control"
                                               placeholder="手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>班级</label>
                                        <input id="banjiValue" name="banjiValue" class="form-control"
                                               placeholder="班级" readonly>
                                    </div>
                                    <%--<div class="form-group col-md-6">--%>
                                        <%--<label>作业</label>--%>
                                        <%--<div>--%>
                                            <%--<select id="zuoyeSelect" name="zuoyeSelect"--%>
                                                    <%--class="selectpicker form-control"  data-live-search="true"--%>
                                                    <%--title="请选择" data-header="请选择" data-size="5">--%>
                                            <%--</select>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <div class="form-group col-md-6">
                                        <label>作业名字</label>
                                        <input id="zuoyeName" name="zuoyeName" class="form-control"
                                               placeholder="作业名字" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>发布作业时间</label>
                                        <input id="insertTime" name="insertTime" class="form-control"
                                               placeholder="发布作业时间" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>作业截止时间</label>
                                        <input id="endTime" name="endTime" class="form-control"
                                               placeholder="作业截止时间" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="yonghuId" name="yonghuId" type="hidden">
                                <input id="zuoyeId" name="zuoyeId" type="hidden">
                                    <div class="form-group col-md-6 bbbbbbbbb">
                                        <label>学生完成作业</label>
                                        <input name="file" type="file" class="form-control-file" id="xueshengZuoyeFileupload">
                                        <label id="xueshengZuoyeFileName"></label>
                                        <input name="xueshengZuoyeFile" id="xueshengZuoyeFile-input" type="hidden">
                                    </div>
                                   <div class="form-group col-md-6 aaaaaaa bbbbbbbbb">
                                       <label>学生完成作业时间</label>
                                       <input id="xueshengZuoyeTime-input" name="xueshengZuoyeTime" type="text" class="form-control layui-input">
                                   </div>
                                <input id="laoshiId" name="laoshiId" type="hidden">
                                    <div class="form-group col-md-6 aaaaaaa">
                                        <label>老师批改作业</label>
                                        <input name="file" type="file" class="form-control-file" id="laoshiZuoyeFileupload">
                                        <label id="laoshiZuoyeFileName"></label>
                                        <input name="laoshiZuoyeFile" id="laoshiZuoyeFile-input" type="hidden">
                                    </div>
                                   <div class="form-group  col-md-6 aaaaaaa">
                                       <label>老师批改作业备注</label>
                                       <input id="laoshiZuoyeContentupload" name="file" type="file">
                                       <script id="laoshiZuoyeContentEditor" type="text/plain"
                                               style="width:100%;height:230px;"></script>
                                       <script type = "text/javascript" >
                                       //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                       //相见文档配置属于你自己的编译器
                                       var laoshiZuoyeContentUe = UE.getEditor('laoshiZuoyeContentEditor', {
                                           toolbars: [
                                               [
                                                   'undo', //撤销
                                                   'bold', //加粗
                                                   'redo', //重做
                                                   'underline', //下划线
                                                   'horizontal', //分隔线
                                                   'inserttitle', //插入标题
                                                   'cleardoc', //清空文档
                                                   'fontfamily', //字体
                                                   'fontsize', //字号
                                                   'paragraph', //段落格式
                                                   'inserttable', //插入表格
                                                   'justifyleft', //居左对齐
                                                   'justifyright', //居右对齐
                                                   'justifycenter', //居中对
                                                   'justifyjustify', //两端对齐
                                                   'forecolor', //字体颜色
                                                   'fullscreen', //全屏
                                                   'edittip ', //编辑提示
                                                   'customstyle', //自定义标题
                                               ]
                                           ]
                                       });
                                       </script>
                                       <input type="hidden" name="laoshiZuoyeContent" id="laoshiZuoyeContent-input">
                                   </div>
                                   <%--<div class="form-group col-md-6">--%>
                                       <%--<label>老师批改作业时间</label>--%>
                                       <%--<input id="laoshiZuoyeTime-input" name="laoshiZuoyeTime" type="text" class="form-control layui-input">--%>
                                   <%--</div>--%>
                                <div class="form-group col-md-6 aaaaaaa">
                                    <label>作业分数</label>
                                    <input id="zuoyeNumber" name="zuoyeNumber" class="form-control"
                                           onchange="zuoyeNumberChickValue(this)"  placeholder="作业分数">
                                </div>

                                <div class="form-group col-md-12 mb-3 ">
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "xueshengZuoye";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
        <!-- 级联表的下拉框数组 -->
    var laoshiOptions = [];
    var yonghuOptions = [];
    var zuoyeOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#xueshengZuoyeFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('xueshengZuoyeFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('xueshengZuoyeFileName').innerHTML = "上传成功!";
            }
        });


        $('#laoshiZuoyeFileupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                document.getElementById('laoshiZuoyeFile-input').setAttribute('value', baseUrl + 'file/download?fileName=' + data.result.file);
                document.getElementById('laoshiZuoyeFileName').innerHTML = "上传成功!";
            }
        });


        $('#laoshiZuoyeContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('laoshiZuoyeContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#yonghuId") !=null){
               var yonghuId = $("#yonghuId").val();
               if(yonghuId == null || yonghuId =='' || yonghuId == 'null'){
                   alert("学生不能为空");
                   return;
               }
           }
           if($("#zuoyeId") !=null){
               var zuoyeId = $("#zuoyeId").val();
               if(zuoyeId == null || zuoyeId =='' || zuoyeId == 'null'){
                   alert("作业不能为空");
                   return;
               }
           }
           if($("#laoshiId") !=null){
               var laoshiId = $("#laoshiId").val();
               if(laoshiId == null || laoshiId =='' || laoshiId == 'null'){
                   alert("老师不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';
            }
            httpJson("xueshengZuoye/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addxueshengZuoye');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        <!-- 查询级联表的所有列表 -->
        function laoshiSelect() {
            //填充下拉框选项
            http("laoshi/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    laoshiOptions = res.data.list;
                }
            });
        }

        function laoshiSelectOne(id) {
            http("laoshi/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                laoshiShowImg();
                laoshiDataBind();
            }
        });
        }
        function yonghuSelect() {
            //填充下拉框选项
            http("yonghu/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    yonghuOptions = res.data.list;
                }
            });
        }

        function yonghuSelectOne(id) {
            http("yonghu/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                yonghuShowImg();
                yonghuDataBind();
            }
        });
        }
        function zuoyeSelect() {
            //填充下拉框选项
            http("zuoye/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    zuoyeOptions = res.data.list;
                }
            });
        }

        function zuoyeSelectOne(id) {
            http("zuoye/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                zuoyeShowImg();
                zuoyeDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
        function initializationlaoshiSelect() {
            var laoshiSelect = document.getElementById('laoshiSelect');
            if(laoshiSelect != null && laoshiOptions != null  && laoshiOptions.length > 0 ) {
                for (var i = 0; i < laoshiOptions.length; i++) {
                        laoshiSelect.add(new Option(laoshiOptions[i].name, laoshiOptions[i].id));
                }

                $("#laoshiSelect").change(function(e) {
                        laoshiSelectOne(e.target.value);
                });
            }

        }

        function initializationyonghuSelect() {
            var yonghuSelect = document.getElementById('yonghuSelect');
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                        yonghuSelect.add(new Option(yonghuOptions[i].name, yonghuOptions[i].id));
                }

                $("#yonghuSelect").change(function(e) {
                        yonghuSelectOne(e.target.value);
                });
            }

        }

        function initializationzuoyeSelect() {
            var zuoyeSelect = document.getElementById('zuoyeSelect');
            if(zuoyeSelect != null && zuoyeOptions != null  && zuoyeOptions.length > 0 ) {
                for (var i = 0; i < zuoyeOptions.length; i++) {
                        zuoyeSelect.add(new Option(zuoyeOptions[i].name, zuoyeOptions[i].id));
                }

                $("#zuoyeSelect").change(function(e) {
                        zuoyeSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->
        <!--  级联表的下拉框回显  -->
            var laoshiSelect = document.getElementById("laoshiSelect");
            if(laoshiSelect != null && laoshiOptions != null  && laoshiOptions.length > 0 ) {
                for (var i = 0; i < laoshiOptions.length; i++) {
                    if (laoshiOptions[i].id == ruleForm.laoshiId) {//下拉框value对比,如果一致就赋值汉字
                        laoshiSelect.options[i+1].selected = true;
                        $("#laoshiSelect" ).selectpicker('refresh');
                    }
                }
            }
            var yonghuSelect = document.getElementById("yonghuSelect");
            if(yonghuSelect != null && yonghuOptions != null  && yonghuOptions.length > 0 ) {
                for (var i = 0; i < yonghuOptions.length; i++) {
                    if (yonghuOptions[i].id == ruleForm.yonghuId) {//下拉框value对比,如果一致就赋值汉字
                        yonghuSelect.options[i+1].selected = true;
                        $("#yonghuSelect" ).selectpicker('refresh');
                    }
                }
            }
            var zuoyeSelect = document.getElementById("zuoyeSelect");
            if(zuoyeSelect != null && zuoyeOptions != null  && zuoyeOptions.length > 0 ) {
                for (var i = 0; i < zuoyeOptions.length; i++) {
                    if (zuoyeOptions[i].id == ruleForm.zuoyeId) {//下拉框value对比,如果一致就赋值汉字
                        zuoyeSelect.options[i+1].selected = true;
                        $("#zuoyeSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.laoshiZuoyeContent != null && ruleForm.laoshiZuoyeContent != 'null' && ruleForm.laoshiZuoyeContent != '' && $("#laoshiZuoyeContentupload").length>0) {

            var laoshiZuoyeContentUeditor = UE.getEditor('laoshiZuoyeContentEditor');
            laoshiZuoyeContentUeditor.ready(function () {
                var mes = '' + ruleForm.laoshiZuoyeContent;
                laoshiZuoyeContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#laoshiZuoyeContentupload").length>0){
            var laoshiZuoyeContentEditor =UE.getEditor('laoshiZuoyeContentEditor');
            if (laoshiZuoyeContentEditor.hasContents()) {
                    $('#laoshiZuoyeContent-input').attr('value', laoshiZuoyeContentEditor.getPlainTxt());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function zuoyeNumberChickValue(e){
            var this_val = e.value || 0;
            /*if(this_val == 0){
                e.value = "";
                alert("0不允许输入");
                return false;
            }*/
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addxueshengZuoye');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                yonghuId: "required",
                zuoyeId: "required",
                xueshengZuoyeFile: "required",
                xueshengZuoyeTime: "required",
                laoshiId: "required",
                laoshiZuoyeFile: "required",
                laoshiZuoyeContent: "required",
                laoshiZuoyeTime: "required",
                zuoyeNumber: "required",
            },
            messages: {
                yonghuId: "学生不能为空",
                zuoyeId: "作业不能为空",
                xueshengZuoyeFile: "学生完成作业不能为空",
                xueshengZuoyeTime: "学生完成作业时间不能为空",
                laoshiId: "老师不能为空",
                laoshiZuoyeFile: "老师批改作业不能为空",
                laoshiZuoyeContent: "老师批改作业备注不能为空",
                laoshiZuoyeTime: "老师批改作业时间不能为空",
                zuoyeNumber: "作业分数不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addxueshengZuoye = window.sessionStorage.getItem("addxueshengZuoye");
        if (addxueshengZuoye != null && addxueshengZuoye != "" && addxueshengZuoye != "null") {
            window.sessionStorage.removeItem('addxueshengZuoye');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("xueshengZuoye/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#xueshengZuoyeTime-input'
                ,type: 'datetime'
            });
            laydate.render({
                elem: '#laoshiZuoyeTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        laoshiDataBind();
        yonghuDataBind();
        zuoyeDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#zuoyeId").val(ruleForm.zuoyeId);
        $("#xueshengZuoyeFile").val(ruleForm.xueshengZuoyeFile);
        $("#xueshengZuoyeTime-input").val(ruleForm.xueshengZuoyeTime);
        $("#laoshiId").val(ruleForm.laoshiId);
        $("#laoshiZuoyeFile").val(ruleForm.laoshiZuoyeFile);
        $("#laoshiZuoyeContent").val(ruleForm.laoshiZuoyeContent);
        $("#laoshiZuoyeTime-input").val(ruleForm.laoshiZuoyeTime);
        $("#zuoyeNumber").val(ruleForm.zuoyeNumber);

    }
    <!--  级联表的数据回显  -->
    function laoshiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#laoshiId").val(ruleForm.id);

        $("#username").val(ruleForm.username);
        $("#password").val(ruleForm.password);
        $("#laoshiName").val(ruleForm.laoshiName);
        $("#sexValue").val(ruleForm.sexValue);
        $("#laoshiIdNumber").val(ruleForm.laoshiIdNumber);
        $("#laoshiPhone").val(ruleForm.laoshiPhone);
        $("#laoshiNation").val(ruleForm.laoshiNation);
        $("#politicsValue").val(ruleForm.politicsValue);
        $("#laoshiAddress").val(ruleForm.laoshiAddress);
    }

    function yonghuDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#yonghuId").val(ruleForm.id);

        $("#username").val(ruleForm.username);
        $("#password").val(ruleForm.password);
        $("#name").val(ruleForm.name);
        $("#sexValue").val(ruleForm.sexValue);
        $("#idNumber").val(ruleForm.idNumber);
        $("#phone").val(ruleForm.phone);
        $("#nation").val(ruleForm.nation);
        $("#politicsValue").val(ruleForm.politicsValue);
        $("#address").val(ruleForm.address);
        $("#banjiValue").val(ruleForm.banjiValue);
    }

    function zuoyeDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#zuoyeId").val(ruleForm.id);

        $("#banjiKechengId").val(ruleForm.banjiKechengId);
        $("#zuoyeName").val(ruleForm.zuoyeName);
        $("#zuoyeFile").val(ruleForm.zuoyeFile);
        $("#zuoyeContent").val(ruleForm.zuoyeContent);
        // var insertTimeDate = new Date();
        // insertTimeDate.setTime();
        $("#insertTime").val(ruleForm.insertTime);//把时间戳转换为日期带时分秒格式
        // var endTimeDate = new Date();
        // endTimeDate.setTime();
        $("#endTime").val(ruleForm.endTime);//把时间戳转换为日期带时分秒格式
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        laoshiShowImg();
        yonghuShowImg();
        zuoyeShowImg();
    }


    <!--  级联表的图片  -->

    function laoshiShowImg() {
        $("#laoshiPhotoImg").attr("src",ruleForm.laoshiPhoto);
    }


    function yonghuShowImg() {
        $("#yonghuPhotoImg").attr("src",ruleForm.yonghuPhoto);
    }


    function zuoyeShowImg() {
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            laoshiSelect();
            yonghuSelect();
            zuoyeSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            <!--  初始化级联表的下拉框  -->
            initializationlaoshiSelect();
            initializationyonghuSelect();
            initializationzuoyeSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        // alert(window.sessionStorage.getItem('role')+"999999999999 ")
        if (window.sessionStorage.getItem('role') == '用户') {
            $("#laoshiZuoyeFileupload").remove();
            $("#laoshiZuoyeContentupload").remove();
            $("#xueshengZuoyeTime-input").remove();
            $("#zuoyeNumber").remove();
            $(".aaaaaaa").remove();
        }else if(window.sessionStorage.getItem('role') == '老师'){
            // $("#xueshengZuoyeFileupload").remove();
            $(".bbbbbbbbb").remove();
            $('#xueshengZuoyeTime-input').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>