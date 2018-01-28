<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript" src="${basePath}js/multiple.js"></script>
<link href="${basePath}css/menu.css" rel="stylesheet">
<style>
.topnav {
	width: 185px;
	padding: 0px 0px 0px 0;
	font-family: 宋体;
}
</style>
<div class="container"
	style="background: url(${basePath}img/bg_grid.png);">

	<div class="main clearfix" >
		<div class="bb-custom-wrapper" style="margin-top: 10px;">
			<ul class="topnav">
				<li><a href="javascript:void(0);">库存管理</a>
					<ul>
						<li><a href="javascript:void(0);">物料仓储</a>
							<ul>
								<li><a href="javascript:void(0)" onclick="openPage('repository/storage.jsp')">物料入库</a></li>
								<li><a href="javascript:void(0)" onclick="openPage('repository/sendStorage.jsp')">生产发出</a></li>
								<li><a href="javascript:void(0)" onclick="openPage('repository/queryStorage.jsp')">信息查询</a></li>
							</ul></li>
						<li><a href="javascript:void(0);">成品仓储</a>
							<ul>
								<li><a href="javascript:void(0);">成品入库</a></li>
								<li><a href="javascript:void(0);">销售发出</a></li>
								<li><a href="javascript:void(0);">信息查询</a></li>
							</ul></li>
					</ul></li>

				<li><a href="javascript:void(0);">供应商信息</a>
					<ul>
						<li><a href="javascript:void(0);">数据查询</a></li>
					</ul></li>
				<li><a href="javascript:void(0);">客户信息</a>
					<ul>
						<li><a href="javascript:void(0);">数据查询</a></li>
					</ul></li>
				<li><a href="javascript:void(0);">系统设置</a>
					<ul>
						<li><a href="javascript:void(0);">用户管理</a>
							<ul>
								<li><a href="javascript:openPageUserInfo()">用户信息查询</a></li>
								<li><a href="javascript:void(0)" onclick="openPageAddUser()">添加用户</a></li>
							</ul></li>
						<li><a href="javascript:void(0);">数据初始化</a>
							<ul>
								<li><a href="javascript:void(0);" onclick="openPage('bom/bom.jsp')">添加BOM清单</a></li>
								<li><a href="javascript:void(0);">物料期初数据</a></li>
								<li><a href="javascript:void(0);">成品期初数据</a></li>
							</ul></li>
						<li><a href="javascript:void(0);">系统初始化</a>
							<ul>
								<li><a href="javascript:void(0); " >数据库初始化</a></li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
	</div>

</div>
<!-- /container -->
<script language="JavaScript">
	$(document).ready(function() {
		$(".topnav").accordion({
			accordion : false,
			speed : 300,
			closedSign : '+',
			openedSign : '-'
		});
	});
</script>