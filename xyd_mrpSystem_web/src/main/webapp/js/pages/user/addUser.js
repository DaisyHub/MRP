//操作的是添加用户数据的功能
//使用JQuery Validation校验框架，页面加载完成，就给表单绑定验证功能
$(function() {
	$('#addUserForm').validate({
		/*每个元素出现验证错误，就会被执行*/
		errorPlacement:function(error, element){
			$("#" + $(element).attr("name") + "Error").text($(error).text()).attr("style","color: red;").addClass("glyphicon glyphicon-remove");
			
			$(element).parent().addClass("has-error");
		},
		
		/*当每个元素验证成功的时候，就被执行*/
		success:function(label,element){
			$("#" + $(element).attr("name") + "Error").text(" 通过！").removeClass("glyphicon-remove").addClass("glyphicon-ok").attr("style","color: green;");
			
			$(element).parent().removeClass("has-error").addClass("has-success");
		},
		
		/*当所有的表单元素都验证通过之后，提交表单中的数据*/
		submitHandler:function(form){
			//form.submit();	
			//执行一个预定的函数，封装一个JQuery Ajax操作
			addUser2();
		},
		
		rules:{
			username:{
				required:true,
				rangelength:[6,12]
			},
			password:{
				required:true,
				rangelength:[6,12]
			},
			conPass:{
				required:true,
				equalTo:"#password"
			},
			level:{
				required:true
			}
		},
		messages:{
			username:{
				required:" 用户名不能为空！",
				rangelength:" 请输入长度为{0}到{1}的用户名！"
			},
			password:{
				required:" 用户密码不能为空！",
				rangelength:" 请输入长度为{0}到{1}的用户密码！"
			},
			conPass:{
				required:" 请确认密码！",
				equalTo:" 您输入的两次密码不一致！"
			},
			level:{
				required:" 请给当前添加的用户选择权限！"
			}
		}		
	});
});


function addUser() {
	//执行添加用户网络请求
	$.ajax({
		type:"post",	//设置请求的方式
		url:getRootPath() + "/addUser.action",			//这是添加用户的请求地址
		dataType:"json",	//指定返回的数据类型
		data:{				//请求的参数
			//把表单中的数据进行提交
			//key=value  key=后台接收的参数名称，value=页面表单的元素值
			"username":$("#username").val(),
			"password":$("#password").val(),
			"conPass":$("#conPass").val(),
			"level":$("#level").val(),
			"remarks":$("#remarks").val()
		},
		success:function(data){		//可以在函数中接收请求成功返回的数据
			//请求成功后执行的函数
			success("请求成功！");
		},
		error:function() {
			//请求失败后执行的函数
			error("网络出现问题，请稍后再试！")
		}
		
	});
}

function addUser2() {
	//执行添加用户网络请求
	$.ajax({
		type:"post",	//设置请求的方式
		url:getRootPath() + "/addUser.action",			//这是添加用户的请求地址
		dataType:"json",	//指定返回的数据类型
		data:$("#addUserForm").serialize(),
		success:function(data){		//可以在函数中接收请求成功返回的数据
			//请求成功后执行的函数
			//console.log(data);
			if(data.state) {
				success(data.message);
			}else{
				error(data.message)
			}
			
		},
		error:function() {
			//请求失败后执行的函数
			error("网络出现问题，请稍后再试！")
		}
		
	});
}