<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/auth/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<s:url namespace="/auth/account" action="grantRoleSubmit.action" var="grantRoleAction"></s:url>
<s:url namespace="/auth/account" action="roleTree.action" var="roleTreeAction"></s:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号角色分配</title>
<script type="text/javascript">

	/*选择授权的权限所属的系统id*/
	var grant_perm_systemId = null;
	var submitForm = function(_dialog, _grid, _$) {
		var nodes = $('#roleTree2').tree('getChecked', [ 'checked', 'indeterminate' ]);
		var ids = [];
		for (var i = 0; i < nodes.length; i++) {
			if(nodes[i].attributes && nodes[i].attributes.isModule) {
				continue;
			}
			ids.push(nodes[i].id);
		}
		if(ids.length == 0) {
			parent.$.messager.confirm('询问', '本次未选择任何角色，提交之后将清空原所有授权角色，确定提交吗？', function(r) {
				if (r) {
					submitFun(ids, _dialog, _grid, _$);
				}
			});	
		}else{
			submitFun(ids, _dialog, _grid, _$);
		}
		
	};
	
	
	var submitFun = function(ids, _dialog, _grid, _$) {
		$.post("${grantRoleAction}", {
			'account.id' : '${account.id}',
			roleIds : ids.join(','),
			systemId:grant_perm_systemId
		}, function(result) {
			if (result.success) {
				_dialog.dialog('destroy');
				_$.messager.alert('提示', result.msg, 'info');
			} else {
				_$.messager.alert('提示', result.msg, 'error');
			}
		}, 'json');
	}
	
	$(function() {
		parent.$.messager.progress({
			text : '数据加载中....'
		});
		var data = [];
		<c:forEach items="${account.subSystemSet}" var="system">
			data.push({id:${system.id},text:'${system.systemName}',accountId:${account.id}})
		</c:forEach>
		$('#roleTree').tree({
			checkbox : false,
			data: data,
			onLoadSuccess : function(node, data) {
				parent.$.messager.progress('close');
				if(data.length == 0){
					parent.$.messager.alert('提示', '数据异常', 'info');
				}
			},
			onSelect:function(node){
				grant_perm_systemId = node.id;
				$('#roleTree2').tree({
					url : '${roleTreeAction}?systemId='+node.id+'&account.id='+node.accountId ,
					checkbox : true,
					onlyLeafCheck : false,
					onLoadSuccess : function(node, data) {
						parent.$.messager.progress('close');
						if(data.length == 0){
							parent.$.messager.alert('提示', '该系统下未建立角色!', 'info');
							$("#tips").hide();
						}else{
							$("#tips").show();
						}
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<ul id="roleTree"></ul>
	<span class="tree-title" id="tips" style="display: none;">请设置角色</span>
	<ul id="roleTree2"></ul>
</body>
</html>