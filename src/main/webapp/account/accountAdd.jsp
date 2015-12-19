<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/auth/common/common.jsp"></jsp:include>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:url namespace="/auth/account" action="addSubmit.action" var="addAccountAction"></s:url>
<s:url namespace="/auth/account" action="systems.action" var="allSystemsAction"></s:url>
<s:url namespace="/auth/account" action="othersystems.action" var="otherSystemsAction"></s:url>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号新增</title>
<script type="text/javascript">

	var submitForm = function(_dialog, _grid, _$) {
		if ($('#accountForm').form('validate')) {
			$.post("${addAccountAction}", serializeObject($('#accountForm')), function(result) {
				if (result.success) {
					_grid.datagrid('load');
					_dialog.dialog('destroy');
					_$.messager.alert('提示', result.msg, 'info');
				} else {
					_$.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	}

	$(function(){

		 $("#systemId").combobox({
			url : '${allSystemsAction}',
			valueField :'id',
			textField : 'systemName',
			required : true,
			editable : false,
			panelHeight : 160,
            multiple:true,
			missingMessage : "所属系统不能为空",
			onSelect: function(value) {
				if(value.systemId == 'auth'){
                    $("#systemId").combobox("hidePanel");
					$("#systemTr").show();
					$('#systemTree').combobox({
						valueField :'id',
						textField : 'systemName',
						required : true,
						editable : false,
						panelHeight : 100,
                        multiple:true,
						url : '${otherSystemsAction}'
					});
				}
			},
			onUnselect: function(value) {
				 if(value.systemId == 'auth'){
					 $("#systemTr").hide()
					 $('#systemTree').combobox("clear");
				 }
			 }
		});

	})
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<form action="${addAccountAction }" id="accountForm">
		<table width="100%" class="table tabs-title">
			<tr>
				<th>所属系统</th>
				<td>
					<input name="subSystemId"  id="systemId" 	style="width:260px;" >
				</td>
			</tr>
			<tr style="display: none;" id="systemTr">
				<th>管控系统</th>
				<td>
					<input name="ctrlSubSystemId"  id="systemTree" 	style="width:260px;" />
				</td>
			</tr>
			<tr>
				<th>账号名称</th>
				<td>
					<input type="text" name="account.accountId" data-options="required:true,validType:['length[0,256]', 'nonChinese']"
						class="easyui-validatebox" missingMessage="账号名称不能为空"  style="width:260px"/>
				</td>
			</tr>
			<tr>
				<th>手机号码</th>
				<td>
					<input type="text" name="account.phoneNumber" data-options="required:true,validType:['length[0,256]', 'phoneNumber' ,'nonChinese']"
						class="easyui-validatebox" missingMessage="手机号码不能为空"  style="width:260px"/>
				</td>
			</tr>
			<tr>
				<th>状态</th>
				<td>
					<select id="status" class="easyui-combobox" name="account.status"
							data-options="required:true,panelHeight:'auto',editable:false"  style="width:260px;">
						<option value="1">未激活</option>
				    </select>
				</td>
			</tr>
		</table>
	</form>
	<div id="sp" style="display: none;">
		<div style="color:#99BBE8;background:#fafafa;padding:5px;">选择管控的系统</div>
		<div style="padding:10px" id="spcontent">
		</div>
	</div>
</body>
</html>