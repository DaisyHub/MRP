<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<script type="text/javascript" src="${basePath }js/pages/bom/bom.js" charset="utf-8"></script>

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
<div align="center">
	<p style="font-size: 40px; margin-top: 20px;">产 品 BOM 清 单</p>
</div>
<div id="" style="margin: 50px 0px 0px 15%; width: 70%; height: 410px;">
	<form action="" method="post">

		<div class="form-inline">
			<label for="column">请选产品名称：</label> 
			<select class="form-control" style="width: 250px;" id="product_id">
				<option value="">请选择产品名称！</option>
			</select> <label for="keyword">&nbsp;&nbsp;&nbsp;&nbsp;BOM清单编号：</label> <input
				type="text" class="form-control" style="width: 280px;"
				placeholder="XYD-20180104192713" id="bom_id"> &nbsp;&nbsp;&nbsp;&nbsp;
		</div>

		<table class="table table-hover table-condensed"
			style="margin-top: 30px; border-bottom: 1px solid #afb4db;">
			<thead>
				<tr>
					<th width="60px" style="text-align: center;">序号</th>
					<th width="290px" style="text-align: center;">配件名称</th>
					<th width="60px" style="text-align: center;">单位</th>
					<th width="120px" style="text-align: center;">数量</th>
					<th width="300px" style="text-align: center;">描述信息</th>
					<th width="70px" style="text-align: center;">操作</th>
				</tr>
			</thead>

			<tbody id="bomTbody">
				<tr>
					<td width="60px" style="text-align: center; padding-top: 12px;">
						1</td>
					<td width="320px">
						<select class="form-control" id="partsId" name="partsId">
								<option value="">请选择配件名称！</option>
						</select>
					</td>
					<td width="80px"><input class="form-control" name="unit" id="unit"></td>
					<td width="120px"><input class="form-control" name="count" id="count"></td>
					<td width="370px"><input class="form-control" name="remarks" id="remarks"></td>
					<td width="50px">
						<div align="center">
							<button type="button" class="btn btn-danger btn-xs"
								style="margin-top: 8px;" onclick="tbodyDataDel(this)">
								<span class="glyphicon glyphicon-remove"></span>
							</button>
						</div>
					</td>
				</tr>
			</tbody>

		</table>
	</form>
</div>
<div align="center">
	<button class="btn btn-info" onclick="addInput()">添加行</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button class="btn btn-info">重置</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button class="btn btn-info" onclick="saveBOM()">保存</button>
</div>


