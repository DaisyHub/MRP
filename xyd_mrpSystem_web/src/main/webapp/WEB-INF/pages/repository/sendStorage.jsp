<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${basePath}js/jedate/jedate.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${basePath }js/pages/bom/bom.js" charset="utf-8"></script>
<script src="${basePath}js/pages/repository/sendStorage.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
	.table thead tr {
		display: block;
	}
	
	.table tbody {
		font-size: 16px;
		display: block;
		height: 300px;
		overflow: auto;
	}
</style>
<div align="center" style="margin:20px 0;">
	<p style="font-size: 40px;">物 料 出 库 卡 片</p>
</div>
<div style="width: 900px; padding-left: 10px;margin-left: 13%; margin-top: 30px;">
	<form action="" method="post">
		
		<div class="form-inline">
			<label for="productName">产品名称：</label>
			<div class="input-group">
				<select class="form-control" style="width: 250px;" id="product_id" name="product_id" onchange="getProductBom()">
					<option value="0">请选择产品名称！</option>
				</select>
				<span class="input-group-btn">
					<button class="btn btn-info" type="button" data-toggle="modal" data-target="#myModal_1">添加
					</button>
				</span>
			</div>
			
			<label for="productName">&nbsp;&nbsp;&nbsp;&nbsp;BOM清单编号：</label>
			<div class="input-group">
				<input name="bomNum" id="bomNum" style="width: 250px;" readonly class="form-control" placeholder="XYD-BOM-20180104-54654">
				<span class="input-group-btn">
					<button class="btn btn-info" type="button" onclick="openPage('bom/bom.jsp')">添加
					</button>
				</span>
			</div>

		</div>
		<br />
		<div class="form-inline">
			<label for="column">出库日期：</label>
			<input name="date" id="dateinfo" style="width: 200px;" class="form-control" placeholder="请选择入库日期！">

			<label for="keyword">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						出库单号：</label>
			<input name="partsDanhao" id="partsDanhao" readonly style="width: 303px;" class="form-control" placeholder="XYD-CK-20180105152917-87616">
		</div>
		
		<br	 />
		<div class="form-inline">
			<label for="partsSummary">出库摘要：</label>
			<input name="partsSummary" id="partsSummary" style="width: 734px;" class="form-control" placeholder="请输入摘要！" >
		</div>

		<table class="table table-hover table-condensed" style="margin-top: 10px; border-bottom:1px solid #afb4db;">
			<thead>
				<tr>
					<th width="60px" style="text-align: center;">序号</th>
					<th width="290px" style="text-align: center;">配件名称</th>
					<th width="90px" style="text-align: center;">单位</th>
					<th width="90px" style="text-align: center;">数量</th>
					<th width="360px" style="text-align: center;">描述信息</th>
					<th width="70px" style="text-align: center;">操作</th>
				</tr>
			</thead>

			<tbody id="StorageTbody">
				<tr>
					<td width="60px" style="text-align: center;padding-top: 12px;">
						1
					</td>
					<td width="320px">
						<input class="form-control">
					</td>
					<td width="80px">
						<input class="form-control">
					</td>
					<td width="120px">
						<input class="form-control">
					</td>
					<td width="370px">
						<input class="form-control">
					</td>
				</tr>
			</tbody>

		</table>
	</form>
	<div align="center">
		<button class="btn btn-info" onclick="outputParts()">保&emsp;存</button> &emsp;&emsp;
		<button class="btn btn-info">重&emsp;置</button>
	</div>
</div>

<div style="margin-left: 17%;margin-top: 15px;">

</div>

<div class="modal fade" id="myModal_1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel" style="font-size: 20px;">
					添 加 商 品 名 称
				</h4>
			</div>
			<form action="" id="productNameModalForm" >
				<div class="modal-body" style="text-align: left;">
					<div class="form-group">
						<div class="form-group has-feedback">
							<div class="input-group">
								<span class="input-group-addon ">成品</span>
								<input type="text" name="pname" class="form-control" placeholder="请输入产品名称！">
							</div>
						</div>
		
					</div>
					
					<h4 style="font-size: 19px;">请输入产品描述：</h4>
					<div class="form-group">
						<textarea class="form-control" rows="4" name="remarks" style="resize:none;"></textarea>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="saveProductName()">提交更改</button>
			</div>
		</div>
	</div>
</div>
