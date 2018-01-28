<%
	//获取当前项目的路径
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="<%=basePath%>css/muyu.css" rel="stylesheet">
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

<!--加载数据的动画插件-->
<script src="<%=basePath%>css/loading/load.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/loading/load.css"/>

<script src="<%=basePath%>js/validation/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>js/validation/additional-methods.min.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>js/validation/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" src="<%=basePath%>js/pages/openPage.js"></script>

<script type="text/javascript" src="<%=basePath%>js/muyu.js"></script>


