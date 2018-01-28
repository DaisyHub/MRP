<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${basePath}js/jedate/jedate.js" type="text/javascript" charset="utf-8"></script>
<script src="${basePath}js/pinying.js" type="text/javascript" charset="utf-8"></script>

<script src="${basePath}js/pages/repository/storage.js" type="text/javascript" charset="utf-8"></script>
<div>
	
	<form action="" id="partsForm" name="partsForm">
		<input type="hidden" name="flag" value="1" />
		<div class="mu_div" align="center" style="margin-top: 30px;">
			<span style="font-size: 30px;">物 料 入 库 卡 片</span>
			<div style="margin:0 auto;border:1px solid #afb4db; width: 70%; margin-top: 20px;" >
				<table style="border-collapse:separate; border-spacing:0px 10px;" >
					<tbody>
						<tr>
							<th style="text-align: right;font-size: 18px; width: 100px;" >入库日期：</th>
							<td style="width: 220px;">
								<!-- 日期 -->
								<input name="date" id="dateinfo" class="form-control" placeholder="请选择入库日期！" >
							</td>
							<th style="text-align: right;font-size: 18px; width: 130px;">&nbsp;&nbsp;&nbsp;入库单号：</th>
							<td colspan="3"  >
								<!-- 单号 -->
								<input name="partsDanhao" id="partsDanhao" placeholder="XYD-WLRK-" class="form-control">
							</td>
						</tr>
						<tr>
							<th style="text-align: right; font-size: 18px;" >摘 要：</th>
							<td colspan="5">
								<!-- 摘要 -->
								<input name="partsSummary" id="partsSummary" class="form-control" placeholder="请输入摘要！" >
							</td>
						</tr>
						<tr>
							<th style="text-align: right; font-size: 18px;" >供应商：</th>
							<td colspan="4">
								<!-- 供应商 -->
								<select class="form-control" id="supplierId" name="supplierId">
									<option value="">请选择供应商！</option>
								</select>
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal_1">添加</button>
							</td>
						</tr>
						<tr>
							<th style="text-align: right; font-size: 18px;" >物料类型：</th>
							<td colspan="4">
								<!-- 编号 -->
								<select class="form-control" name="typeNum" id="typeNum">
									<option id="0" value="0">请选择物料类型！</option>
								</select>
							</td>
							<td>
								&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">添加</button>
							</td>
						</tr>
						<tr>
							<th style="text-align: right; font-size: 18px;" >配件名称：</th>
							<td colspan="3">
								<!-- 配件名称 -->
								<input name="partsName" id="partsName" placeholder="请输入配件名称！" class="form-control">
							</td>
						</tr>
						<tr>
							<th style="text-align: right;font-size: 18px;" >单位：</th>
							<td>
								<!-- 单位 -->
								<select class="form-control" name="unit" id="unit">
									<option id="0" value="">请选择配件单位！</option>
								</select>
							</td>
							
							<th style="text-align: right;font-size: 18px;">&nbsp;&nbsp;&nbsp;数量：</th>
							<td>
								<!-- 数量 -->
								<input name="count" id="count" placeholder="请输入数量！" class="form-control" >
							</td>
						</tr>
						<tr>
							<th style="text-align: right; font-size: 18px;" >备 注：</th>
							<td colspan="3">
								<textarea  class="form-control" rows="4" name="remarks" id="remarks" style="resize:none;"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
	<div style="margin-left: 45%;margin-top: 20px;">
		<button type="button" class="btn btn-primary" onclick="saveParts()">添 加</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="btn btn-info" >重 置</button>
	</div>
</div>

	<script type="text/javascript">
		
	</script>
	
<!-- 以下是模态框 -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel" style="font-size: 20px;">
					添 加 物 料 类 型
				</h4>
			</div>
			<form action="" id="typeModalForm" name="typeModalForm">
				<div class="modal-body" style="text-align: left;">
					<h4 style="font-size: 19px;">类别：</h4>
					<select class="form-control" name="typeId" id="typeId" >
						<option id="1" value="1">成品</option>
						<option id="2" value="2" selected>配件</option>
					</select><br>
					
					<h4 style="font-size: 19px;">物料类型编号：</h4>
					<div class="form-group has-feedback">
						<div class="input-group">
							<span class="input-group-addon ">XYD-</span>
							<input name="typeNum" id="myModal_typeNum" class="form-control">
						</div>
					</div>
					
					<h4 style="font-size: 19px;">类型名称：</h4>
					<h4 style="color: red;" id="msg"></h4>
					<input name="typeName" id="myModal_typeName" class="form-control" placeholder="请输入类型名称！" onkeyup="getSId('myModal_typeNum',this.value)"><br>
					
					<h4 style="font-size: 19px;">请输入物料类型的描述信息：</h4>
					<div class="form-group" >
						<textarea class="form-control" rows="4" name="typeDesc" id="typeDesc" style="resize:none;"></textarea>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="saveType()">提交更改</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<div class="modal fade" id="myModal_1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="myModalLabel" style="font-size: 20px;">
					添 加 供  应 商 信 息
				</h4>
			</div>
			<form action="" id="supplierForm" name="supplierForm">
				<div class="modal-body" style="text-align: left;">
					<h4 style="font-size: 19px;">供应商编号：</h4>
					<div class="form-group has-feedback">
						<div class="input-group">
							<span class="input-group-addon ">XYD-</span>
							<input name="supplierId" id="sId" class="form-control">
						</div>
					</div>
					
					<h4 style="font-size: 19px;">供应商名称：</h4>
					<input name="supplierName" id="supplierName" class="form-control"  placeholder="请输入3到15位中英文的供应商名称！" onkeyup="getSId('sId',this.value)">
					<br />
					<h4 style="font-size: 19px;">联系人：</h4>
					<input  name="supplierContacts" id="supplierContacts" class="form-control" placeholder="请输入供应商联系人！">
					<br />
					
					<h4 style="font-size: 19px;">联系电话：</h4>
					<input name="supplierCall" id="supplierCall" class="form-control" placeholder="请输入供应商联系电话！">
					<br />
					
					<h4 style="font-size: 19px;">联系地址：</h4>
					<input name="supplierAddress" id="supplierAddress" class="form-control" placeholder="请输入供应商办公地址！">
					<br />
					
					<h4 style="font-size: 19px;">请输入供应商备注信息：</h4>
					<div class="form-group" >
						<textarea class="form-control" rows="4" name="remarks" id="modalRemarks" style="resize:none;" ></textarea>
					</div>
				</div>
			</form>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="saveSupplier()">提交更改</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
