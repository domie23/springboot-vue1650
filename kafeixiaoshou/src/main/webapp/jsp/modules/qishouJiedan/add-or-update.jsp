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
                    <h3 class="block-title">编辑骑手接单</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">骑手接单管理</li>
                        <li class="breadcrumb-item active">编辑骑手接单</li>
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
                        <h3 class="widget-title">骑手接单信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa goods_order">
                                        <label>商品订单</label>
                                        <div>
                                            <select style="width: 450px" id="goodsOrderSelect" name="goodsOrderSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 goods_order">
                                        <label>订单号</label>
                                        <input style="width: 450px" id="goodsOrderUuidNumber" name="goodsOrderUuidNumber" class="form-control"
                                               placeholder="订单号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods_order">
                                        <label>购买的数量</label>
                                        <input style="width: 450px" id="buyNumber" name="buyNumber" class="form-control"
                                               placeholder="购买的数量" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods_order">
                                        <label>实付价格</label>
                                        <input style="width: 450px" id="goodsOrderTruePrice" name="goodsOrderTruePrice" class="form-control"
                                               placeholder="实付价格" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods_order">
                                        <label>订单类型</label>
                                        <input style="width: 450px" id="goodsOrderValue" name="goodsOrderValue" class="form-control"
                                               placeholder="订单类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6 goods_order">
                                        <label>支付类型</label>
                                        <input style="width: 450px" id="goodsOrderPaymentValue" name="goodsOrderPaymentValue" class="form-control"
                                               placeholder="支付类型" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa qishou">
                                        <label>骑手</label>
                                        <div>
                                            <select style="width: 450px" id="qishouSelect" name="qishouSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 qishou">
                                        <label>骑手姓名</label>
                                        <input style="width: 450px" id="qishouName" name="qishouName" class="form-control"
                                               placeholder="骑手姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 qishou">
                                        <label>头像</label>
                                        <img id="qishouPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6 qishou">
                                        <label>骑手手机号</label>
                                        <input style="width: 450px" id="qishouPhone" name="qishouPhone" class="form-control"
                                               placeholder="骑手手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 qishou">
                                        <label>骑手身份证号</label>
                                        <input style="width: 450px" id="qishouIdNumber" name="qishouIdNumber" class="form-control"
                                               placeholder="骑手身份证号" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="qishouId" name="qishouId" type="hidden">
                                <input id="goodsOrderId" name="goodsOrderId" type="hidden">
                                    <div class="form-group col-md-6 qishouJiedanTypesDiv">
                                        <label>送单状态</label>
                                        <select style="width: 450px" id="qishouJiedanTypesSelect" name="qishouJiedanTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
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
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "qishouJiedan";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var qishouJiedanTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var goodsOrderOptions = [];
    var qishouOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '骑手'){//当前登录用户不为这个
                if($("#qishouId") !=null){
                    var qishouId = $("#qishouId").val();
                    if(qishouId == null || qishouId =='' || qishouId == 'null'){
                        alert("骑手不能为空");
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '商品订单'){//当前登录用户不为这个
                if($("#goodsOrderId") !=null){
                    var goodsOrderId = $("#goodsOrderId").val();
                    if(goodsOrderId == null || goodsOrderId =='' || goodsOrderId == 'null'){
                        alert("订单不能为空");
                        return;
                    }
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
            httpJson("qishouJiedan/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addqishouJiedan');
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
        function qishouJiedanTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=qishou_jiedan_types", "GET", {}, (res) => {
                if(res.code == 0){
                    qishouJiedanTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function goodsOrderSelect() {
            //填充下拉框选项
            http("goodsOrder/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    goodsOrderOptions = res.data.list;
                }
            });
        }

        function goodsOrderSelectOne(id) {
            http("goodsOrder/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                goodsOrderShowImg();
                goodsOrderShowVideo();
                goodsOrderDataBind();
            }
        });
        }
        function qishouSelect() {
            //填充下拉框选项
            http("qishou/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    qishouOptions = res.data.list;
                }
            });
        }

        function qishouSelectOne(id) {
            http("qishou/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                qishouShowImg();
                qishouShowVideo();
                qishouDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationQishoujiedantypesSelect(){
            var qishouJiedanTypesSelect = document.getElementById('qishouJiedanTypesSelect');
            if(qishouJiedanTypesSelect != null && qishouJiedanTypesOptions != null  && qishouJiedanTypesOptions.length > 0 ){
                for (var i = 0; i < qishouJiedanTypesOptions.length; i++) {
                    qishouJiedanTypesSelect.add(new Option(qishouJiedanTypesOptions[i].indexName,qishouJiedanTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationgoodsOrderSelect() {
            var goodsOrderSelect = document.getElementById('goodsOrderSelect');
            if(goodsOrderSelect != null && goodsOrderOptions != null  && goodsOrderOptions.length > 0 ) {
                for (var i = 0; i < goodsOrderOptions.length; i++) {
                        goodsOrderSelect.add(new Option(goodsOrderOptions[i].goodsOrderName, goodsOrderOptions[i].id));
                }

                $("#goodsOrderSelect").change(function(e) {
                        goodsOrderSelectOne(e.target.value);
                });
            }

        }

        function initializationqishouSelect() {
            var qishouSelect = document.getElementById('qishouSelect');
            if(qishouSelect != null && qishouOptions != null  && qishouOptions.length > 0 ) {
                for (var i = 0; i < qishouOptions.length; i++) {
                        qishouSelect.add(new Option(qishouOptions[i].qishouName, qishouOptions[i].id));
                }

                $("#qishouSelect").change(function(e) {
                        qishouSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var qishouJiedanTypesSelect = document.getElementById("qishouJiedanTypesSelect");
        if(qishouJiedanTypesSelect != null && qishouJiedanTypesOptions != null  && qishouJiedanTypesOptions.length > 0 ) {
            for (var i = 0; i < qishouJiedanTypesOptions.length; i++) {
                if (qishouJiedanTypesOptions[i].codeIndex == ruleForm.qishouJiedanTypes) {//下拉框value对比,如果一致就赋值汉字
                        qishouJiedanTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var goodsOrderSelect = document.getElementById("goodsOrderSelect");
            if(goodsOrderSelect != null && goodsOrderOptions != null  && goodsOrderOptions.length > 0 ) {
                for (var i = 0; i < goodsOrderOptions.length; i++) {
                    if (goodsOrderOptions[i].id == ruleForm.goodsOrderId) {//下拉框value对比,如果一致就赋值汉字
                        goodsOrderSelect.options[i+1].selected = true;
                        $("#goodsOrderSelect" ).selectpicker('refresh');
                    }
                }
            }
            var qishouSelect = document.getElementById("qishouSelect");
            if(qishouSelect != null && qishouOptions != null  && qishouOptions.length > 0 ) {
                for (var i = 0; i < qishouOptions.length; i++) {
                    if (qishouOptions[i].id == ruleForm.qishouId) {//下拉框value对比,如果一致就赋值汉字
                        qishouSelect.options[i+1].selected = true;
                        $("#qishouSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addqishouJiedan');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                qishouId: "required",
                goodsOrderId: "required",
                qishouJiedanTypes: "required",
            },
            messages: {
                qishouId: "骑手不能为空",
                goodsOrderId: "订单不能为空",
                qishouJiedanTypes: "送单状态不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addqishouJiedan = window.sessionStorage.getItem("addqishouJiedan");
        if (addqishouJiedan != null && addqishouJiedan != "" && addqishouJiedan != "null") {
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
            http("qishouJiedan/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
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
        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        goodsOrderDataBind();
        qishouDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#qishouId").val(ruleForm.qishouId);
        $("#goodsOrderId").val(ruleForm.goodsOrderId);

    }
    <!--  级联表的数据回显  -->
    function goodsOrderDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#goodsOrderId").val(ruleForm.id);

        $("#goodsOrderUuidNumber").val(ruleForm.goodsOrderUuidNumber);
        $("#addressId").val(ruleForm.addressId);
        $("#goodsId").val(ruleForm.goodsId);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#buyNumber").val(ruleForm.buyNumber);
        $("#goodsOrderTruePrice").val(ruleForm.goodsOrderTruePrice);
        $("#goodsOrderValue").val(ruleForm.goodsOrderValue);
        $("#goodsOrderPaymentValue").val(ruleForm.goodsOrderPaymentValue);
    }

    function qishouDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#qishouId").val(ruleForm.id);

        $("#qishouName").val(ruleForm.qishouName);
        $("#qishouPhone").val(ruleForm.qishouPhone);
        $("#qishouIdNumber").val(ruleForm.qishouIdNumber);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        goodsOrderShowImg();
        qishouShowImg();
    }


    <!--  级联表的图片  -->

    function goodsOrderShowImg() {
    }


    function qishouShowImg() {
        $("#qishouPhotoImg").attr("src",ruleForm.qishouPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        goodsOrderShowVideo();
        qishouShowVideo();
    }


    <!--  级联表的视频  -->

    function goodsOrderShowVideo() {
    }

    function qishouShowVideo() {
        $("#qishouPhotoV").attr("src",ruleForm.qishouPhoto);
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
            qishouJiedanTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            goodsOrderSelect();
            qishouSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationQishoujiedantypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationgoodsOrderSelect();
            initializationqishouSelect();

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
        window.sessionStorage.removeItem('addqishouJiedan');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events: none;');
        }
		else if (window.sessionStorage.getItem('role') == '用户') {
            // $(".aaaaaa").remove();
            $(".yonghu").remove();//删除当前用户的信息
        }
		else if (window.sessionStorage.getItem('role') == '骑手') {
            // $(".aaaaaa").remove();
            $(".qishou").remove();//删除当前用户的信息
        }
		else if (window.sessionStorage.getItem('role') == '员工') {
            // $(".aaaaaa").remove();
            $(".yuangong").remove();//删除当前用户的信息
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
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
