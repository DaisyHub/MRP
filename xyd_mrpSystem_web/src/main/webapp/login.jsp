<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信盈达 MRP管理系统</title>
<jsp:include page="/WEB-INF/publicPage/public.jsp" />
<script type="text/javascript" src="${basePath}js/login.js"></script>
<link href="css/style_log.css" rel="stylesheet">
<style type="text/css">
input::-webkit-input-placeholder{
    color: #92e1eb;
}
/*图片自适应*/
.myBack {
	width:100%;
	height:100%;
	padding:0px;
	margin:0px;
	background-image: url(img/login_bj.jpg); /*图片地址*/
	background-origin: content; /*从content区域开始显示背景*/
	background-size: 100% 100%;/* 保持图像本身的宽高比例，将图片缩放到宽度或高度正好适应定义背景的区域  */
	background-repeat: no-repeat; /* 图像不重复显示  */
}
</style>
</head>
<body >
	 <div class="myBack">
		<div class="login_logo">
			<img src="img/logo_1.png" width="40%" style="margin-top: 10%;"/>
		</div>
		<div class="login_boder" style="width: 35%;color: #FFF;margin-top: 3% ;margin-left: 33%;" >
			<form action="login.action" id="loginForm" method="post">
				<h4 style="font-size: 19px;">用户名：<span style="color: red;">${dataResult.message}</span> </h4>
				<input type="text" name="username" value="admin1"  class="txt_input"  placeholder="请输入您的用户名！">
				<h4 style="font-size: 19px;">用户密码：</h4>
				<input type="text" name="password" value="123456"  class="txt_input" placeholder="请输入您的密码！" >

				<div class="rem_sub" align="center">
				<br><br>
					<input type="submit" class="btn btn-info" value="登陆 Login">
				</div>
			</form>
		</div>
	</div>
</body>
</html>