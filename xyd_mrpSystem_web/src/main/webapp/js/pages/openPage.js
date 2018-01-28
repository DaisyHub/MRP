//专门用于加载显示指定的页面
function openPageAddUser() {
	//进行网络请求，从服务器获取到添加用户的页面，添加到指定的位置
	//在主页id为mainData这一个div元素中进行显示加载到的页面,执行action请求
	
	$.mask_element('#mainData');
	
	$('#mainData').load(
		getRootPath() + "/openPageAddUser.action",
		function () {	//当请求成功后，会执行这个函数
			$.mask_close('#mainData');
		}
	);
}

function openPageUserInfo() {
	$.mask_element('#mainData');
	$('#mainData').load(
		getRootPath() + "/openPageUserInfo.action",
		function () {	//当请求成功后，会执行这个函数
			$.mask_close('#mainData');
		}
	);
}

function openPage(page) {
	//显示动画
	$.mask_element('#mainData');
	$('#mainData').load(
		getRootPath() + "/openPage.action?page=" + page,
		function () {	//当请求成功后，会执行这个函数
			//关闭动画！
			$.mask_close('#mainData');
		}
	);
}