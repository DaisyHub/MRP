<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<script src="${basePath}js/jqueryPagination.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${basePath}js/pages/user/userInfo.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css" href="${basePath}css/jqueryPagination.css" />

<div id="" style="margin-top: 30px;margin-left:11%; width: 80%;">
	<h2 style="text-align: center;">用户信息查询</h2>

	<div id="" style="margin-top: 30px;" align="left">
		<form class="form-inline">
			<div class="form-group">
				<label for="column">请选择查询条件：</label>
				<select class="form-control" id="cloumn" name="column" style="width: 190px;">
					<option value="username">用户名</option>
					<option value="level">用户权限</option>

				</select>
			</div>
			<div class="form-group">
				<label for="keyword">请输入查询内容：</label>
				<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon ">🔍</span>
						<input type="text" class="form-control" id="keyword" name="keyword" placeholder="请输入查询内容">
					</div>
				</div>

			</div>
			<button type="button" class="btn btn-info" id="query">查询</button>
		</form>
	</div>

	<div class="panel panel-info" style="margin-top: 30px;height: 313px;">
		<div class="panel-heading">
			<span class="glyphicon glyphicon-list" aria-hidden="true"></span> &nbsp;用户列表
		</div>
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th width="60px">序号</th>
					<th class="myBorder">用户名</th>
					<th>用户权限</th>
					<th class="myBorder">用户信息</th>
					<th width="200px">操作</th>
				</tr>
			</thead>
			<tbody id="userInfoTbody" title="双击可以打开当前行的用户详情！">
				<tr style="border-bottom: 1px double #BBBBBB;">
					<td align="center">1</td>
					<td class="myBorder">xyd</td>
					<td>管理员
						<input type="hidden" id="lv-0" value="" />
					</td>
					<td class="myBorder">就是管理员</td>
					<td align="center">
						<button class="btn btn-warning btn-xs" id="userInfoEdit-uid">
							<span class="glyphicon glyphicon-edit"></span>&nbsp;修改
						</button>

						<button class="btn btn-danger btn-xs" id="userInfoDel-uid">
							<span class="glyphicon glyphicon-remove"></span>&nbsp;移除
						</button>
					</td>
				</tr>

			</tbody>
		</table>
	</div>
	<div align="center">
		<div id="jqueryPagin" title="每页显示5条数据！"></div>
	</div>

	<!--使用Bootstrap的模态框插件-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">用户信息详情</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="#" id="addUserForm">

						<div class="form-group">
							<label for="username" class="col-sm-3 control-label">用户名：</label>
							<div class="col-sm-5">
								<input class="form-control " id="username" name="username" placeholder="请输入用户名！" readonly="readonly">
							</div>
							<label class="control-label " id="usernameError"></label>
						</div>

						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">用户密码：</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" id="password" name="password" placeholder="请输入用户密码！" onchange="isEditUser()">
							</div>
							<label class="control-label" id="passwordError"></label>
						</div>
						<div class="form-group">
							<label for="conPass" class="col-sm-3 control-label">确认密码：</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" id="conPass" name="conPass" placeholder="请再次输入密码！">
							</div>
							<label class="control-label" id="conPassError"></label>
						</div>

						<div class="form-group">
							<label for="level" class="col-sm-3 control-label">权限设置：</label>
							<div class="col-sm-5">
								<select class="form-control" id="level" name="level" onchange="isEditUser()">
									<option value="">请选择用户权限</option>
									<option value="1">主管</option>
									<option value="2">仓储员</option>
									<option value="3">供应商</option>
									<option value="4">客户</option>
								</select>
							</div>
							<label class="control-label" id="levelError"></label>
						</div>

						<div class="form-group">
							<label for="remarks" class="col-sm-3 control-label">用户信息描述：</label>
							<div class="col-sm-5">
								<textarea class="form-control" style="resize: none;" rows="5" id="remarks" name="remarks" onchange="isEditUser()"></textarea>
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<!--当用户修改了数据之后，复选框被选中-->
					<input type="checkbox" style="display: none;" name="isEditUser" id="isEditUser" />
					
					<button class="btn btn-default btn-xs" data-dismiss="modal">
						<span class="glyphicon glyphicon-log-out"></span>&nbsp;退 出
					</button>
					<button class="btn btn-warning btn-xs" onclick="editUser()">
						<span class="glyphicon glyphicon-edit"></span>&nbsp;修 改
					</button>
				</div>
			</div>
		</div>
	</div>
</div>