<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${basePath}js/pages/publicPage/head.js" type="text/javascript" charset="utf-8"></script>
<div >
		<div style="float: left;margin: 20px;">
			<img alt="信盈达电子科技有限公司" src="${basePath}/img/logo_1.png" width="330px">
		</div>
		<div style="float: right;color: #fff;font-size: 20px; margin: 20px;" >
			欢迎您的到来：【${currUser.username}】
			<button class="btn btn-warning btn-xs" onclick="editCurrUser()">
				<span class="glyphicon glyphicon-edit"></span>&nbsp;用户信息
			</button>
			<button class="btn btn-danger btn-xs" onclick="exit()">
				<span class="glyphicon glyphicon-log-out"></span>&nbsp;退 出
			</button> 
		</div>
	
</div>

<div class="modal fade" id="headModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">用户信息详情</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="#" id="headUserForm">

					<div class="form-group">
						<label for="headusername" class="col-sm-3 control-label">用户名：</label>
						<div class="col-sm-5">
							<input class="form-control " id="headusername" placeholder="请输入用户名！" value="${currUser.username}" readonly>
						</div>
						<label class="control-label " id="headusernameError"></label>
					</div>

					<div class="form-group">
						<label for="headpassword" class="col-sm-3 control-label">用户密码：</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="headpassword" placeholder="请输入用户密码！" onchange="isEditUser()">
						</div>
						<label class="control-label" id="headpasswordError"></label>
					</div>
					<div class="form-group">
						<label for="conPass" class="col-sm-3 control-label">确认密码：</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="headconPass"  placeholder="请再次输入密码！">
						</div>
						<label class="control-label" id="headconPassError"></label>
					</div>

					<div class="form-group">
						<label for="headlevel" class="col-sm-3 control-label">权限设置：</label>
						<div class="col-sm-5">
							<select class="form-control" id="headlevel" onchange="isEditUser()" disabled>
								<option <c:if test="${currUser.level eq '0'}">selected</c:if> value="11">管理员</option>
								<option <c:if test="${currUser.level eq '1'}">selected</c:if> value="1">主管</option>
								<option <c:if test="${currUser.level eq '2'}">selected</c:if> value="2">仓储员</option>
								<option <c:if test="${currUser.level eq '3'}">selected</c:if> value="3">供应商</option>
								<option <c:if test="${currUser.level eq '4'}">selected</c:if> value="4">客户</option>
							</select>
						</div>
						<label class="control-label" id="headlevelError"></label>
					</div>

					<div class="form-group">
						<label for="remarks" class="col-sm-3 control-label">用户信息描述：</label>
						<div class="col-sm-5">
							<textarea class="form-control" style="resize: none;" rows="5" id="headremarks"  onchange="isEditUser()" >${currUser.remarks}</textarea>
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<input type="checkbox" style="display: none;" id="isEditUser1" />
				
				<button class="btn btn-default btn-xs" data-dismiss="modal">
					<span class="glyphicon glyphicon-log-out"></span>&nbsp;退 出
				</button>
				<button class="btn btn-warning btn-xs" onclick="modalEditUser()">
					<span class="glyphicon glyphicon-edit"></span>&nbsp;修 改
				</button>
			</div>
		</div>
	</div>
</div>