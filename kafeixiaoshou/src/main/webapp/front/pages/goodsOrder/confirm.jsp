
























<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!-- 个人中心 -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>确认下单</title>
        <link rel="stylesheet" href="../../layui/css/layui.css">
        <!-- 样式 -->
        <link rel="stylesheet" href="../../css/style.css" />
        <!-- 主题（主要颜色设置） -->
        <link rel="stylesheet" href="../../css/theme.css" />
        <!-- 通用的css -->
        <link rel="stylesheet" href="../../css/common.css" />
        <script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
    </head>
    <body>

        <div id="app">
            <!-- 轮播图 -->
            <div class="layui-carousel" id="swiper">
                <div carousel-item id="swiper-item">
                    <div v-for="(item,index) in swiperList" v-bind:key="index">
                        <img class="swiper-item" :src="item.img">
                    </div>
                </div>
            </div>
            <!-- 轮播图 -->

            <!-- 标题 -->
            <h2 style="margin-top: 20px;" class="index-title">CONFIRM / ORDER</h2>
            <div class="line-container">
                <p class="line"> 确认下单 </p>
            </div>
            <!-- 标题 -->

            <div class="container">
    				<h2 >选择收货地址</h2>
				<table class="layui-table address-table" lay-skin="nob">
                    <thead>
                        <tr>
                            <th>选择</th>
                        	<th>主键</th>
                        	<th>收货人</th>
                        	<th>电话</th>
                        	<th>地址</th>
                        	<th>是否默认地址</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item,index) in addressList" v-bind:key="index" @click="addressOnChecked(index)">
                            <td><input type="radio" :value="index" name="address" :checked="item.isdefaultTypes == 2?true:false" /></td>
                        	<td>{{item.id}}</td>
                        	<td>{{item.addressName}}</td>
                        	<td>{{item.addressPhone}}</td>
                        	<td>{{item.addressDizhi}}</td>
                        	<td>{{item.isdefaultValue}}</td>
                        </tr>
                    </tbody>
                </table>
                <h2>清单列表</h2>
                <table class="layui-table" lay-skin="nob" style="border: 3px dotted #EEEEEE;margin: 20px 0;">
                    <thead>
                        <tr>
                            <th>名称</th>
                            <th>现价</th>
                            <th>数量</th>
                            <th>总价</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(item,index) in dataList" v-bind:key="index">
                            <td style="display: flex;text-align: left;">
                                <img :src="item.goodsPhoto" style="width: 100px;height: 100px;object-fit: cover;">
                                <div style="margin-left: 10px;margin-top: 10px;">
                                    {{item.goodsName}}
                                </div>
                            </td>
                            <td  style="width: 150px;">{{item.goodsNewMoney}} RMB</td>
                            <td style="width: 140px;">
                                {{item.buyNumber}}
                            </td>
                            <td style="width: 100px;">{{item.goodsNewMoney*item.buyNumber}} RMB</td>
                        </tr>
                    </tbody>
                </table>

                <div class="btn-container">
                    <div v-if="this.goodsOrderPaymentTypes == 1" style="margin-right: 150px">
                        <span style="font-size: 15px;font-weight: bold;color: #ce0b07;text-decoration:line-through">
                            总价：{{totalMoney.toFixed(2)}}RMB
                        </span>
                        </br>
                        <span style="font-size: 18px;font-weight: bold;color: #ce0b07">
                            实付价：{{(totalMoney * zhekou).toFixed(2)}}RMB
                        </span>
                    </div>
                    <button @click="payClick()" type="button" style="margin-top: -65px" class="layui-btn layui-btn-lg btn-theme">
                        <i class="layui-icon">&#xe657;</i> 支付
                    </button>
                </div>
            </div>
        </div>

		<!-- layui -->
		<script src="../../layui/layui.js"></script>
		<!-- vue -->
		<script src="../../js/vue.js"></script>
        <!-- 引入element组件库 -->
        <script src="../../xznstatic/js/element.min.js"></script>
        <!-- 引入element样式 -->
        <link rel="stylesheet" href="../../xznstatic/css/element.min.css">
		<!-- 组件配置信息 -->
		<script src="../../js/config.js"></script>
		<!-- 扩展插件配置信息 -->
		<script src="../../modules/config.js"></script>
		<!-- 工具方法 -->
		<script src="../../js/utils.js"></script>
		<!-- 校验格式工具类 -->
		<script src="../../js/validate.js"></script>

		<script>
			var vue = new Vue({
				el: '#app',
				data: {
					// 轮播图
					swiperList: [{
						img: '../../img/banner.jpg'
					}],
					dataList: [],
					addressList: [],
                    goodsOrderPaymentTypes: 1,
                    zhekou:1,
					// 当前用户信息
					user: {}
				},
				computed: {
					totalMoney: function() {
						var total = 0;
						for (var item of this.dataList) {
							total += item.goodsNewMoney * item.buyNumber
						}
						return total;
					}
				},
				methods: {
					jump(url) {
						jump(url)
					}
					//鼠标点击让地址改为已选择
                    ,addressOnChecked(e){
						var address = layui.jquery("[name='address']");
						for(var i=0;i<address.length;i++){
							if(address[i].value==e){
								address[i].checked=true;
								layui.jquery("#"+i).addClass("selected")
							}else{
								address[i].checked=false;
								layui.jquery("#"+i).removeClass("selected")
							}

						}
					}
					// 正常下单，生成订单，减少余额，添加积分，减少库存，修改状态已支付
					,payClick() {
						var index = layui.jquery('input[name=address]:checked').val();
						if (!index) {
                            layui.layer.msg('请选择收货地址', {
                                time: 2000,
                                icon: 5
                            });
                            return false;
                        }
						let data={
                            addressId: vue.addressList[index].id,
                            goodss:localStorage.getItem('goodss'),
                            yonghuId: localStorage.getItem('userid'),
                            goodsOrderPaymentTypes: vue.goodsOrderPaymentTypes,
						}
                        // 获取商品详情信息
                        layui.http.request(`goodsOrder/order`, 'POST', data, (res) => {
                            // 订单编号
                            var orderId = genTradeNo();
							if(res.code == 0){
                                alert("下单成功，点击确定后跳转 我的订单页面");
                                window.location.href='../goodsOrder/list.jsp';
							}
                       		 window.location.href='../goodsOrder/list.jsp';
					    });
					}
            	}
			});

			layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload'], function() {
				var layer = layui.layer;
				var element = layui.element;
				var carousel = layui.carousel;
				var http = layui.http;
				var jquery = layui.jquery;
				var form = layui.form;
				var upload = layui.upload;

				// 充值
				jquery('#btn-recharge').click(function(e) {
					layer.open({
						type: 2,
						title: '用户充值',
						area: ['900px', '600px'],
						content: '../recharge/recharge.jsp'
					});
				});

				// 获取轮播图 数据
				http.request('config/list', 'get', {
					page: 1,
					limit: 5
				}, function(res) {
					if (res.data.list.length > 0) {
						var swiperItemHtml = '';
						for (let item of res.data.list) {
							if (item.value && item.value != "" && item.value != null) {
								swiperItemHtml +=
									'<div>' +
									'<img class="swiper-item" src="' + item.value + '">' +
									'</div>';
							}
						}
						jquery('#swiper-item').html(swiperItemHtml);
						// 轮播图
						carousel.render({
							elem: '#swiper',
							width: swiper.width,height:swiper.height,
							arrow: swiper.arrow,
							anim: swiper.anim,
							interval: swiper.interval,
							indicator: "none"
						});
					}
				});

                // 获取地址数据
				http.request('address/page', 'get', {
					yonghuId: localStorage.getItem('userid')
                }, function(res) {
                    vue.addressList = res.data.list
                });

                // 获取商品信息购买的清单列表
				var goodss = localStorage.getItem('goodss');
				// 转换成json类型，localstorage保存的是string数据
				vue.dataList = JSON.parse(goodss);

				// 用户当前用户信息
				let table = localStorage.getItem("userTable");
                if (!table) {
                    layer.msg('请先登录', {
                        time: 2000,
                        icon: 5
                    }, function () {
                        window.parent.location.href = '../login/login.jsp';
                    });
                }
				http.request(`yonghu/session`, 'get', {}, function(data) {
					vue.user = data.data;
					// 用户当前用户折扣信息
					http.request('dictionary/page', 'get', {
						dicCode: "huiyuandengji_types",
						dicName: "会员等级类型名称",
                        codeIndexStart: vue.user.huiyuandengjiTypes,
                        codeIndexEnd: vue.user.huiyuandengjiTypes,
					}, function(res) {
					    if(res.data.list.length >0){
							vue.zhekou = res.data.list[0].beizhu;
                        }
					})
				});
			});
		</script>
	</body>
</html>
