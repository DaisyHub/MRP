var table;
$(function () {
	//初始化日期
	initDate ();
	
	//初始化分页插件
	initpagination();
	
	//初始化表格插件
	queryStorageData();
})

//初始化表格插件
function queryStorageData () {
	table = document.querySelector('table[grid-manager="queryStorage"]')
	table.GM({		//使用Ajax的请求方式
	    ajax_url: getRootPath() + '/queryLikeParts.action'
	    ,ajax_type: 'POST'	//设置Ajax的请求类型
	    ,query: {			//设置请求参数
	    	'pageSize': 4,	//设置分页显示的数据量
	    	'currPage':1,	//默认显示第1页
	    	'flag':0,		//默认查询所有数据，1查询入库数据，2查询出库数据
	    	'startDate':$("#dateStart").val(),	//开始日期
	    	'endDate':$("#dateEnd").val(),		//结束日期
	    	'pdKword':$("#partsDanhao").val(),	//单号
	    	'supplierKword':$("#supplierId").val(),	//供应商
	    	'typeKword':$("#typeNum").val(),	//类型
	    	
	    }
	    ,supportCheckbox: false		//是否显示多选择框
	    ,supportAdjust: true	//禁止调整宽度
	    ,supportDrag: false		//禁止拖动
	    ,height:'270px'
	    ,columnData: [			//表格字段
	        {
	            key: 'partsSummary',
	            text: '摘要'
	        },
	        {
	            key: 'partsDanhao',
	            text: '出入库单号'
	        },
	        {
	            key: 'supplierId',
	            text: '供应商'
	        },
	        {
	            key: 'typeNum',
	            text: '配件类型'
	        },
	        {
	            key: 'partsName',
	            text: '配件名称'
	        },
	        {
	            key: 'unit',
	            text: '单位'
	        },
	        {
	            key: 'count',
	            text: '数量'
	        },
	        {
	            key: 'flag',
	            text: '出入库类型',
	            //自定义显示的页面元素
	            template: function(nodeData, rowData){
	            	if(nodeData == 1) {
			        	 return  '<span>入库</span>';
			        }else if(nodeData == 2){
			        	return  '<span>出库</span>';
			        }
			    }

	        },
	        {
	            key: 'date',
	            text: '日期'
	        },
	        {
	            key: 'remarks',
	            text: '描述'
	        }
	    ]
	    //请求成功执行的函数
	    ,ajax_success:function (data) {
	    	
	    	//把请求到和数据转换成对象	返回的是JSON  在这里，不可以直接使用data.currPage
	    	var obj = JSON.parse(data)
	    	
	    	//把数据绑定到分页插件上 第1个参数：功能（设置和获取） 第2个参数：当前页，第3个参数：总的页数
	    	//对象.属性
			$("#jqueryPagin").pagination('setPage',obj.currPage,obj.pageCount);
	    }
	    //请求失败执行的函数
	    ,ajax_error:function (errorThrown) {
	    	error("请求失败：" + errorThrown);
	    }
	})
}


//查询按钮  
function search (pageSize,currPage) {
	//使用表格插件的查询功能，setQuery()函数，是把指定的参数传递给table.GM对象，再次执行请求
	//可以理解为再次执行queryStorageData()函数，只是参数改变了。
	table.GM(
		'setQuery',
		{
			'pageSize': pageSize,
			'currPage':currPage,
	    	'flag':$("input[name=flag]:checked").val(),
	    	'startDate':$("#dateStart").val(),
	    	'endDate':$("#dateEnd").val(),
	    	'pdKword':$("#partsDanhao").val(),
	    	'supplierKword':$("#supplierId1").val(),
	    	'typeKword':$("#typeNum").val(),
		}
	);
	
}

//初始化日期插件
function initDate () {
	jeDate({
		dateCell : "#dateStart",
		format : "YYYY-MM-DD",
		isinitVal : true,
		minDate : "2008-08-08",
		choosefun:function(val) {  //选中日期后的回调
			
		}, 
		okfun : function(val) {
			//alert(val)
		}
	})
	jeDate({
		dateCell : "#dateEnd",
		format : "YYYY-MM-DD",
		isinitVal : true,
		minDate : "2008-08-08",
		choosefun:function(val) {  //选中日期后的回调
			
		}, 
		okfun : function(val) {
			//alert(val)
		}
	})
}

//初始化分页插件
function initpagination() {
	$("#jqueryPagin").pagination({
        pageSizeOpt: [
            {'value': 10, 'text': '10条/页', 'selected': true}
        ],
        totalPage: 1,
        showPageNum: 10,
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
            search (pageSize,currPage);
        }
    });
}