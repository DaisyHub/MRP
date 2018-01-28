<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="/WEB-INF/publicPage/public.jsp" />
		<title>信盈达_MRP管理系统</title>

	</head>

	<body>
		<!-- 页头 -->
		<div class="header" style="background: url(${basePath}img/10901054.jpeg);">
			<jsp:include page="/WEB-INF/publicPage/head.jsp" />
		</div>

		<!-- 内容部分 -->
		<div class="content">
			<div id="navbar" style="background: url(${basePath}img/login_bgx.gif);heigt: 40px;line-height:40px; padding-left: 10px;">
				首页/用户管理/添加用户
			</div>

			<!-- 菜单 -->
			<div class="main main_left" style="width:270px; margin: 0;padding: 0;">
				<jsp:include page="/WEB-INF/publicPage/menu.jsp" />
			</div>
			<!-- 主要内容显示区域 -->
			<div id="mainData" class="main main_right" style="overflow: auto;">
				<jsp:include page="/WEB-INF/pages/def_page.jsp" />
			</div>
		</div>

		<!-- 页脚 -->
		<div class="footer" style="background: url(${basePath}img/login_bgx.gif);">
			<jsp:include page="/WEB-INF/publicPage/footer.jsp" />
		</div>
	</body>

</html>