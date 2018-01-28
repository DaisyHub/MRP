$(function () {
	//加载显示供应商数据
	getSupplier();
	
	getType();
	
	getUnit();
	
	initDate();
	
	getPartsDanhao() ;
	
	//当指定模态框关闭时，执行的函数
	$('#myModal_1').on('hidden.bs.modal', function (e) {
  		$("#supplierForm")[0].reset();
	})
	$('#myModal').on('hidden.bs.modal', function (e) {
  		$("#typeModalForm")[0].reset();
	})
	
});

function getPartsDanhao () {
	$("#partsDanhao").val(
		"XYD-" 
		//替换的使用，默认只替换一次，如果要全部替换，要使用g
		+ $("#dateinfo").val().replace(/-/g,"").replace(/ /g,"").replace(/:/g,"")
		+ "-" + uuid(5,10)
	);
}

function initDate () {
	jeDate({
		dateCell : "#dateinfo",
		format : "YYYY-MM-DD hh:mm:ss",
		isinitVal : true,
		isTime : true, //isClear:false,
		minDate : "2014-09-19 00:00:00",
		choosefun:function(val) {  //选中日期后的回调
			getPartsDanhao() ;
		}, 
		okfun : function(val) {		//点击确定执行的回调
			getPartsDanhao() ;
		}
	})
}

//加载配件单位数据并显示到下拉选择框中
function getUnit() {
	$.ajax({
		type:"get",
		url:getRootPath() + "/getAllUnit.action",
		success:function (result) {
			//清空原有的数据
			$("#unit").html("");
			$("#unit").append('<option value="">请选择单位！</option>');
			
			$(result.data).each(function (i,item) {
				$("#unit").append(
					'<option value="' + item.unitName + '">' + item.unitName + '</option>'
				);
			})
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}
//加载物料类型数据并显示到下拉选择框中
function getType() {
	$.ajax({
		type:"get",
		url:getRootPath() + "/getAllType.action",
		success:function (result) {
			//清空原有的数据
			$("#typeNum").html("");
			$("#typeNum").append('<option value="">请选择物料类型！</option>');
			
			$(result.data).each(function (i,item) {
				$("#typeNum").append(
					'<option value="' + item.typeNum + '">' + item.typeName + '</option>'
				);
			})
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}
//加载供应商数据并显示到下拉选择框中
function getSupplier() {
	$.ajax({
		type:"get",
		url:getRootPath() + "/getAllSupplier.action",
		success:function (result) {
			//清空原有的数据
			$("#supplierId").html("");
			$("#supplierId").append('<option value="">请选择供应商！</option>');
			
			$(result.data).each(function (i,item) {
				$("#supplierId").append(
					'<option value="' + item.supplierId + '">' + item.supplierName + '</option>'
				);
			})
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}

//保存配件数据
function saveParts () {
	//打开加载动画
	$.mask_element('#mainData');
	
	$.ajax({
		type:"post",
		url:getRootPath() + "/addParts.action",
		data:$("#partsForm").serialize(),
		success:function (result) {
			if(result.state) {
				success(result.message);
				
				//把表单恢复原状
				$("#partsForm")[0].reset();
				
				initDate();
	
				getPartsDanhao() ;
			}else{
				error(result.message);
			}
			
			//关闭加载动画
			$.mask_close('#mainData');
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
	
	
	
}

//保存供应商数据
function saveSupplier () {
	
	$.ajax({
		type:"post",
		url:getRootPath() + "/addSupplier.action",
		data:{
			'supplierId':"XYD-" + $("#sId").val(),
			'supplierName':$("#supplierName").val(),
			'supplierContacts':$("#supplierContacts").val(),
			'supplierCall':$("#supplierCall").val(),
			'supplierAddress':$("#supplierAddress").val(),
			'remarks':$("#modalRemarks").val()
		},
		success:function (result) {
			if(result.state) {
				success(result.message);
				$("#myModal_1").modal("toggle");
				getSupplier();
			}else{
				error(result.message);
			}
			
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}

//保存供应商数据
function saveType () {
	
	$.ajax({
		type:"post",
		url:getRootPath() + "/addType.action",
		data:{
			'typeId':$("#typeId").val(),
			'typeNum':"XYD-" + $("#myModal_typeNum").val(),
			'typeName':$("#myModal_typeName").val(),
			'typeDesc':$("#typeDesc").val()
		},
		success:function (result) {
			if(result.state) {
				success(result.message);
				
				$("#myModal").modal("toggle");
				getType();
			}else{
				error(result.message);
			}
			
		},
		error:function () {
			error("网络出现异常，请稍后再试！");
		}
	});
}

//键盘事件，获取供应商相应的拼音首字母
function getSId (id,value) {
	$("#" + id).val(makePy(value.trim())[0]);
}

