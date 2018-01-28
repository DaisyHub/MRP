<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${basePath}js/pages/user/addUser.js" type="text/javascript" charset="utf-8"></script>

<h3 align="center">添加用户数据</h3>
			<br />
			<br />
			
		<div style="margin-left: 25%;">
			
		<form class="form-horizontal" action="#" id="addUserForm">
			
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-5" >
					<input class="form-control " id="username" name="username" placeholder="请输入用户名！">
				</div>
				<label class="control-label " id="usernameError"></label>
			</div>
			
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">用户密码：</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="password" name="password" placeholder="请输入用户密码！">
				</div>
				<label class="control-label" id="passwordError"></label>
			</div>
			<div class="form-group">
				<label for="conPass" class="col-sm-2 control-label">确认密码：</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="conPass" name="conPass"  placeholder="请再次输入密码！">
				</div>
				<label class="control-label" id="conPassError"></label>
			</div>
			
			<div class="form-group">
				<label for="level" class="col-sm-2 control-label">权限设置：</label>
				<div class="col-sm-5">
					<select class="form-control" id="level" name="level">
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
				<label for="remarks" class="col-sm-2 control-label">用户信息描述：</label>
				<div class="col-sm-5">
					<textarea class="form-control" style="resize: none;" rows="5" id="remarks" name="remarks"></textarea>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<input type="submit" class="btn btn-default" value="提 交" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="btn btn-default" value="清 空" />
				</div>
			</div>
			
		</form>
	</div>