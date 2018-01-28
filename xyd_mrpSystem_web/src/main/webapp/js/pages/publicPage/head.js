function editCurrUser () {
	removeHeadModalData();
	$('#headModal').modal('toggle');
	
	$("#isEditUser1").prop("checked","");
}

function exit() {
	notie.confirm(
		"是否要退出系统应用？",
		'确认',
		'取消',
		function() {	//点击确认后执行的函数
			success("成功退出系统！")
			window.location.href = getRootPath() + "/logout.action";
		});
	
}

function isEditUser() {
	$("#isEditUser1").prop("checked","true");
}

function removeHeadModalData () {
	//清除密码
	$('#headpassword').val("");
	$('#headconPass').val("");
}

//点击修改按钮后提交数据进行修改
function modalEditUser () {
	$.ajax({
		type:"post",
		url:getRootPath() + "/editUserData.action",
		data:{
			'username':$('#headusername').val(),
			'password':$('#headpassword').val(),
			'conPass': $('#headconPass').val(),
			'level':   $('#headlevel').val(),
			'remarks': $('#headremarks').val(),
			'isEditUser':$('#isEditUser1').prop("checked")
		},
		success:function (result) {
			if(result.state) {
				success(result.message);
				
				//关掉模态框
				$('#headModal').modal('toggle');
				
				$("#isEditUser1").prop("checked");
			}else{
				error(result.message)
			}
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}