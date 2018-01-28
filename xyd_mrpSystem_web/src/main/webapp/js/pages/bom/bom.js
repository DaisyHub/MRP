$(function(){
	//得到所有的产品
	getAllProduct();
	
	//得到所有的配件
	getAllParts();
	
	//设置清单编号
	setBomID();
});


function setBomID(){
	var myDate = new Date();
	$("#bom_id").val("XYD-" + 
			myDate.getFullYear() + (myDate.getMonth()+1) + myDate.getDate() +"-"+ uuid(5, 10));
}

function getAllParts(){
	$.ajax({
		type:"get",
		url:getRootPath()+"/getAllParts.action",
		success:function(result){
			$("#partsId").html("");
			$("#partsId").append("<option value=''>请选择配件名称！</option>");
			$(result.data).each(function(i, item){
				$("#partsId").append('<option value="' + item.partsId  + '">' + item.partsName + '</option>');
				
			});
		},
		error:function () {
			error("我也不知道发生了什么...");
		}
	});
}

function getAllProduct(){
	$.ajax({
		type:"get",
		url:getRootPath()+"/getAllProduct.action",
		success:function(result){
			$("#product_id").html("");
			$("#product_id").append("<option value=''>请选择产品名称！</option>");
			$(result.data).each(function (i,item) {
				$("#product_id").append('<option value="' + item.product.productId  + '">' + item.productName.pname + '</option>');
			})
		},
		error:function () {
			error("我也不知道发生了什么...");
		}
	});
}

// 复制表单组
function addInput(){
	$("#bomTbody tr:eq(0)").before("<tr>" + $("#bomTbody tr:eq(0)").html() + "</tr>");
	resetTbodyID();
}

// 重置表单序号
function resetTbodyID(){
	for (var i = $("#bomTbody tr").length; i >= 0 ; i--) {
		$("#bomTbody tr:eq(" + i + ") td:eq(0)").text(i + 1);
	}
}

// 删除表单组
function tbodyDataDel(el) {
	if($("#bomTbody tr").length == 1) {
		error("you cannot delete the last form!");
	}else {
		$(el).parents('tr').remove();
		resetTbodyID ();
	}
}

// 保存数据
function saveBOM () {
	alert("hello");
	var bomList = new Array();
	$("#bomTbody tr").each(function(i, item){
		bomList.push({
			partsId:$("#bomTbody tr:eq(" + i + ") td [name=partsId]").val(),
			unit:$("#bomTbody tr:eq(" + i + ") td [name=unit]").val(),
			count:$("#bomTbody tr:eq(" + i + ") td [name=count]").val(),
			remarks:$("#bomTbody tr:eq(" + i + ") td [name=remarks]").val()
		});
	})
	
	console.log(JSON.stringify(bomList));
	$.ajax({
		type:"post",
		url:getRootPath() + "/addBom.action",
		data:{
			"bomId":$("#bom_id").val(),
			"productId":$("#product_id").val(),
			"datas":JSON.stringify(bomList)		//以JSON的数据格式进行传递,把JS对象转换成JSON数据
		},
		success:function (dataResult) {
			if(dataResult.state) {
				success(dataResult.message)			
			}else {
				error(dataResult.message);
			}
			
		},
		error:function () {
			error("网络异常，请稍后再试！")
		}
	});
}

// 选择配件名称后，显示出对应的单位
function setUnit (el) {
	console.log($(el).html());
}
