<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="/auth/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:url namespace="/auth/account" action="editSubmit.action" var="editAccountAction"></s:url>
<s:url namespace="/auth/account" action="othersystems.action" var="otherSystemsAction"></s:url>
<s:url namespace="/auth/account" action="systems.action" var="allSystemsAction"></s:url>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <script type="text/javascript">

        var submitForm = function (_dialog, _grid, _$) {
            if ($('#accountForm').form('validate')) {
                $.post("${editAccountAction}", serializeObject($('#accountForm')),
                        function (result) {
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

        $(function () {
            $('#status').combobox('setValue', '${account.status}');
            $('#subsystemTree').combobox({
                valueField: 'id',
                textField: 'systemName',
                required: true,
                editable: false,
                panelHeight: 100,
                multiple: true,
                url: '${allSystemsAction}',
                onLoadSuccess: function () {
                    <c:forEach items="${account.subSystemSet}" var="system">
                        $('#subsystemTree').combobox('select', ${system.id});
                    </c:forEach>
                },
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
            <c:if test="${account.ctrlSubSystemSet != null && fn:length(account.ctrlSubSystemSet) > 0}">
                $('#systemTr').show();
                $('#systemTree').combobox({
                    valueField: 'id',
                    textField: 'systemName',
                    editable: false,
                    panelHeight: 100,
                    multiple: true,
                    url: '${otherSystemsAction}',
                    onLoadSuccess: function () {
                        <c:forEach items="${account.ctrlSubSystemSet}" var="system">
                            $('#systemTree').combobox('select', ${system.id});
                        </c:forEach>
                    }
                });
            </c:if>
        })
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<form action="${editAccountAction }" id="accountForm">
    <input type="hidden" name="account.id" value="${account.id }" id="id">
    <table width="100%" class="table tabs-title">
        <tr>
            <th>所属系统</th>
            <td>
                <%--<select name="account.subSystem.id"  id="systemId" 	style="width:200px;" disabled="disabled" class="easyui-combobox">--%>
                <%--<option value="${account.subSystem.id }" selected="selected">${account.subSystem.systemName }</option>--%>
                <%--</select>--%>
                <input name="subSystemId" id="subsystemTree" style="width:260px;"/>
            </td>
        </tr>
        <tr style="display:none;" id="systemTr">
            <th>管控系统</th>
            <td>
                <input name="ctrlSubSystemId" id="systemTree" style="width:260px;"/>
            </td>
        </tr>
        <tr>
            <th>账号名称</th>
            <td>
                <input type="text" name="account.accountId" value="${account.accountId }"
                       data-options="required:true,validType:['length[0,256]', 'nonChinese']"
                       class="easyui-validatebox" missingMessage="账号名称不能为空"
                       style="width:260px" disabled="disabled"/>
            </td>
        </tr>
        <tr>
            <th>手机号码</th>
            <td>
                <input type="text" name="account.phoneNumber" value="${account.phoneNumber }"
                       data-options="required:true,validType:['length[0,256]', 'phoneNumber' ,'nonChinese']"
                       class="easyui-validatebox" missingMessage="手机号码不能为空" style="width:260px"/>
            </td>
        </tr>
        <tr>
            <th>状态</th>
            <td>
                <select id="status" name="account.status" class="easyui-combobox"
                        data-options="required:true,panelHeight:'auto',editable:false" style="width:260px;">
                    <option value="0">激活</option>
                    <option value="1">未激活</option>
                    <option value="2">冻结</option>
                </select>
            </td>
        </tr>
    </table>
</form>
</body>
</html>