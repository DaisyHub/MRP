<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="css/layui/css/layui.css" />
		<jsp:include page="/WEB-INF/publicPage/public.jsp" />
		<title>信盈达_MRP管理系统</title>
	</head>

	<body>
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<div style="height: 136px;background: url(${basePath}img/10901054.jpeg);">
					<jsp:include page="/WEB-INF/publicPage/head.jsp" />
				</div>
			</div>
			
			<div class="layui-col-md12" style="background: url(${basePath}img/login_bgx.gif);heigt: 40px;line-height:40px; padding-left: 10px;height: 40px;" >
				首页/用户管理/添加用户
				<%-- <jsp:include page="/WEB-INF/publicPage/headModal.jsp" /> --%>
			</div>
			
			<!--菜单-->
			<div class="layui-side layui-bg-black" style="margin-top: 116px;width: 215px;">
				<div class="layui-side-scroll" >
					<jsp:include page="/WEB-INF/publicPage/menu.jsp" />
				</div>
			</div>
			<div class="layui-body" style="margin-top: 117px;margin-left: 16px;" id="mainData">
				<!-- 内容主体区域 -->
				<jsp:include page="/WEB-INF/pages/def_page.jsp" />
				
			</div>

			<div class="layui-footer" style="background: url(${basePath}img/login_bgx.gif);">
				<!-- 底部固定区域 -->
				<jsp:include page="/WEB-INF/publicPage/footer.jsp" />
			</div>

		</div>
	</body>

</html>