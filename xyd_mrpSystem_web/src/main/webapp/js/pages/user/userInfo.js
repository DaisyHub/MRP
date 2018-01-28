var cPage = 1;
var pSize = 5;
$(function(){
	$("table thead tr th").attr("style","text-align: center;");
	
	//JQuery分页插件
	$("#jqueryPagin").pagination({
        pageSizeOpt: [
            {'value': 5, 'text': '5条/页', 'selected': true}
        ],
        totalPage: 1,
        showPageNum: 5,
        firstPage: '首页',
        previousPage: '上一页',
        nextPage: '下一页',
        lastPage: '尾页',
        skip: '跳至',
        confirm: '确认',
        refresh: '刷新',
        totalPageText: '共{}页',
        isShowFL: true,	//首页尾页的按钮 	true为显示
        isShowPageSizeOpt: true,	//每页显示数据的下拉列表
        isShowSkip: true,		//跳转按钮
        isShowRefresh: false,	//刷新
        isShowTotalPage: true,		//是否显示总页数
        isResetPage: false,		//点击按钮后更新按钮样式
        callBack: function (currPage, pageSize) {	//点击按钮后的回调函数
            getDefaultUserData(currPage,pageSize);
            cPage = currPage;
            pSize = pageSize;
        }
    });
    
    //加载用户信息数据,显示第1页，每页显示5条数据
    getDefaultUserData(1,5);
    
    //设置分页按钮
    //$("#jqueryPagin").pagination('setPage',1,10);
    
    //点击查询按钮后进行模糊查询
    $("#query").click(function(){
    	//当前页为1，每页显示数量为：pSize
    	getDefaultUserData(1,pSize);
    });
    
});


//加载用户信息数据
function getDefaultUserData(currPage,pageSize) {
	$.ajax({
		type:"post",
		url:getRootPath() + "/pagingQueryUserData.action",
		data:{
			'pageSize':pageSize,
			'currPage':currPage,
			'column':$("#cloumn").val(),
			'keyword':$("#keyword").val()
		},
		success:function(data){
			//先清空原有的表格数据
			$("#userInfoTbody").html("");
			
			//设置表格的数据
			var context = "";
			
			$(data.data).each(function(i,item){
				var lv = "";
				switch (item.level){
					case '0':
						lv = "管理员"
						break;
					case '1':
						lv = "主管"
						break;
					case '2':
						lv = "仓储员"
						break;
					case '3':
						lv = "供应商"
						break;
					case '4':
						lv = "客户"
						break;
					default:
						break;
				}
				context += "<tr style='border-bottom: 1px double #BBBBBB;'>"
					+ '<td align="center">' + (i + 1) + '</td>'
					+ '<td class="myBorder">' + item.username + '</td>'
					+ '<td>' + lv 
					+ '<input type="hidden" id="lv-' + i + '" value="' + item.level + '" />'
					+ '</td>'
					+ '<td class="myBorder">' + item.remarks + '</td>'
					+ '<td align="center">'
					+ '<button class="btn btn-warning btn-xs" id="userInfoEdit-' + i + '"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button>&nbsp;&nbsp;&nbsp;'
					+ '<button class="btn btn-danger btn-xs" id="userInfoDel-' + i + '"><span class="glyphicon glyphicon-remove"></span>&nbsp;移除</button>'
					+ '</td></tr>'
			})
			
			//把拼接好的数据添加到表格中
			$("#userInfoTbody").html(context);
			
			//把数据绑定到分页插件上 第1个参数：功能（设置和获取） 第2个参数：当前页，第3个参数：总的页数
			$("#jqueryPagin").pagination('setPage',data.currPage,data.pageCount);
			
			initModal();
    
		},
		error:function(){
			error("网络出现异常，请稍后再试！");
		}
	});
}

function initModal () {
	//双击打开当前的表格行数据
	$("#userInfoTbody tr").each(function(index,el){
    	$(el).dblclick(function(){
    		openModal (index);
    	});
    	
    	//给表格中修改按钮绑定单击事件
    	$("#userInfoEdit-" + index).click(function () {
    		openModal (index);
    	})
    	
    	//给表格中删除按钮绑定单击事件
    	$("#userInfoDel-" + index).click(function () {
    		notie.confirm(
				"是否要删除【" + $("#userInfoTbody tr:eq(" + index + ") td:eq(1)").text() + "】用户数据？",
				'确认',
				'取消',
				function() {	//点击确认后执行的函数
					error("删除用户的功能暂未实现！")
				});
    	})
    });
}

//打开模态框并且清空原有的数据
function openModal (index) {
	//先把模态框中的数据清空
	removeModalData();
	
	//打开模态框
	$('#myModal').modal('toggle');
	
	//数据回显
	$('#username').val($("#userInfoTbody tr:eq(" + index + ") td:eq(1)").text());
	
	$('#level').val($("#lv-" + index).val());
	
	$('#remarks').val($("#userInfoTbody tr:eq(" + index + ") td:eq(3)").text());
	
	//把复选框设置成未选中状态
	$("#isEditUser").prop('checked');
}

function isEditUser () {
	$("#isEditUser").prop("checked","true");
}

function removeModalData () {
	$('#username').val("");
	
	$('#password').val("");
	$('#conPass').val("");
    		
	$('#level').val("");
	
	$('#remarks').val("");
	
}
function editUser () {
	$.ajax({
		type:"post",
		url:getRootPath() + "/editUserData.action",
		data:{
			'username':$('#username').val(),
			'password':$('#password').val(),
			'conPass': $('#conPass').val(),
			'level':   $('#level').val(),
			'remarks': $('#remarks').val(),
			'isEditUser':$('#isEditUser').prop("checked")
		},
		success:function (result) {
			if(result.state) {
				success(result.message);
				//关掉模态框
				$('#myModal').modal('toggle');
				
				//重新加载数据
				getDefaultUserData(cPage,pSize);
			}else{
				error(result.message)
			}
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}