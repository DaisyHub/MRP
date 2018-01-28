<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/publicPage/public.jsp" />

<script src="${basePath}js/jedate/jedate.js"></script>
<script src="${basePath}GridManager_2.4.2/js/GridManager.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${basePath}GridManager_2.4.2/css/GridManager.min.css"/>

<script src="${basePath}js/pages/repository/queryStorage.js" type="text/javascript" charset="utf-8"></script>

<script src="${basePath}js/jqueryPagination.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${basePath}css/jqueryPagination.css" />


    <div align="center" style="margin-top: 10px;">
		 <div style="width:90%;">
	        <div >
	        	<span style="font-size:30px; color: blue;">物 料 出 入 库 查 询</span><br>
	        </div>
	        <div style="margin-top: 10px;">
	        	<form action="" method="post" >
	        		
					<table style="border-collapse:separate; border-spacing:0px 10px;">
						<tbody>
							<tr>
								<th style="text-align: right;font-size: 18px;" >出入库查询：</th>
								<td style="font-size: 18px;" colspan="3">
										<input type="radio" name="flag" value="1" checked>入库
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="flag" value="2">出库
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" name="flag" value="0">全部
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input class="btn btn-info" type="button" value="查询" onclick="search(10,1)">
								</td>
							</tr>
							<tr>
								<th style="text-align: right;font-size: 18px;" >日期查询：</th>
								<td>
									<input name="dateStart" id="dateStart" class="form-control" placeholder="请选择起始日期！" readonly >
								</td>
								<th style="text-align: right;font-size: 18px;">&nbsp;至&nbsp;</th>
								<td>
									<input name="dateEnd" id="dateEnd" class="form-control" placeholder="请选择截止日期！" readonly>
								</td>
							</tr>
							<tr>
								<th style="text-align: right;font-size: 18px;" >单号查询：</th>
								<td style="font-size: 18px;" colspan="3">
										<input name="partsDanhao" id="partsDanhao" class="form-control" placeholder="请输入单号的关键字！">
								</td>
							</tr>
							<tr>
								<th style="text-align: right;font-size: 18px;" >供应商查询：</th>
								<td style="font-size: 18px;" colspan="3">
										<input name="supplierId1" id="supplierId1" class="form-control" placeholder="请输入供应商的关键字！">
								</td>
							</tr>
							<tr>
								<th style="text-align: right;font-size: 18px;" >配件类型查询：</th>
								<td style="font-size: 18px;" colspan="3">
										<input name="typeNum" id="typeNum" class="form-control" placeholder="请输入物料名称的关键字！">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
	        </div>
	    </div>
	</div>
	<div style="margin: 0 50px 0 50px;">
		<table grid-manager="queryStorage"></table>
	</div>
	
	<!-- 分页按钮 -->
	<div align="center" style="margin-top: 10px;">
		<div id="jqueryPagin" title="每页显示10条数据！"></div>
	</div>
