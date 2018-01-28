$(function(){
	getAllProduct();
	
	initDate();
	
	setPartsDanhao ();
})

function initDate(){
	jeDate({
		dateCell: "#dateinfo",
		format: "YYYY-MM-DD hh:mm:ss",
		isinitVal: true,
		isTime: true, //isClear:false,
		minDate: "2014-09-19 00:00:00",
		choosefun: function(val) { //选中日期后的回调
			setPartsDanhao ();
		},
		okfun: function(val) {
			setPartsDanhao ();
		}
	})
}

//设置出库单号
function setPartsDanhao () {
	$("#partsDanhao").val(
		"XYD-CK-" 
		//替换的使用，默认只替换一次，如果要全部替换，要使用g
		+ $("#dateinfo").val().replace(/-/g,"").replace(/ /g,"").replace(/:/g,"")
		+ "-" + uuid(5,10)
	);
}

//添加产品
function saveProductName() {
	$.ajax({
		type:"post",
		url:getRootPath() + "/addProductName.action",
		data:$("#productNameModalForm").serialize(),
		success:function (result) {
			if(result.state) {
				success(result.message)
			}else{
				error(result.message)
			}
		},
		error:function () {
			error("网络异常，请稍后再试！");
		}
	});
}

function getProductBom(){
	
	$.ajax({
		type:"get",
		url:getRootPath()+"/getBomData.action",
		data:{
			"productId":$("#product_id option:selected").val()
		},
		success:function(result){
			$("#StorageTbody").html("");
			$(result.data).each(function(i,item){
				$("#StorageTbody").append(
						'<tr><td width="60px" style="text-align: center;padding-top: 12px;">' 
						+ (i + 1)
						+ '</td><td width="290px">' 
						+'<input class="form-control" name="partsName" readonly value="' + item.partsName + '"></td><td width="90px">'
							
						+ '<input class="form-control" name="unit" readonly value="' + item.unit + '"></td><td width="90px">'
						+ '<input class="form-control" name="count" value="' + item.count + '"></td><td width="360px">'
							
						+ '<input class="form-control"  name="remarks" value="' + item.remarks + '">'
						
						+ '<input type="hidden" name="supplierId" value="' + item.supplierId + '">'
						
						+ '<input type="hidden" name="typeNum" value="' + item.typeNum + '">'
						
						+ '</td>'
						+ '<td width="70px"><div align="center"><button type="button" class="btn btn-danger btn-xs" style="margin-top: 8px;" onclick="tbodyDataDel(this)"><span class="glyphicon glyphicon-remove"></span></button></div></td></tr>'
						
				)
			});
			//设置清单号
			$("#bomNum").val(result.data[0].bomId);
		},
		error:function(){
			error("请求失败!")
		}
	});
}


//物料出库
function outputParts(){
	//创建一个数组
	var partsList = new Array();
	
	$("#StorageTbody tr ").each(function (i,item) {
		partsList.push({
			partsName:$("#StorageTbody tr:eq(" + i + ") td [name=partsName]").val(),	//配件名称
			unit:$("#StorageTbody tr:eq(" + i + ") td [name=unit]").val(),				//单位
			count:$("#StorageTbody tr:eq(" + i + ") td [name=count]").val(),			//数量
			supplierId:$("#StorageTbody tr:eq(" + i + ") td [name=supplierId]").val(),			//供应商ID
			typeNum:$("#StorageTbody tr:eq(" + i + ") td [name=typeNum]").val(),			//类型编号
			remarks:$("#StorageTbody tr:eq(" + i + ") td [name=remarks]").val()			//描述
		});	
	})
	
	console.log(partsList)
	
	$.ajax({
		type:"post",
		url:getRootPath() + "/addManyParts.action",
		data:{
			"partsSummary":$("#partsSummary").val(),
			
			"partsDanhao":$("#partsDanhao").val(),
			
			"date":$("#dateinfo").val(),
			"flag":2,
			
			//以JSON的数据格式进行传递,把JS对象转换成JSON数据
			"datas":JSON.stringify(partsList)		
		},
		success:function (result) {
			if(result.state) {
				success(result.message)			
			}else {
				error(result.message);
			}
		},
		error:function () {
			error("网络异常，请稍后再试！")
		}
	});
}