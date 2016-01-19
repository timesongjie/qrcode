<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="/common/common.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">

<c:forEach var="service" items="${services}" varStatus="status">
    <c:if test="${status.index  == 0 }">
        设备编号:${service.deviceCode}
    </c:if>
    <table width="100%" class="table tabs-title">
        <tr>
            <th>服务类型</th>
            <td>
                <c:if test="${service.serviceTypeId == 1}">
                    售前
                </c:if>
                <c:if test="${service.serviceTypeId == 2}">
                    售中
                </c:if>
                <c:if test="${service.serviceTypeId == 3}">
                    售后
                </c:if>
            </td>
        </tr>
        <tr>
            <th>服务名称</th>
            <td>
                    ${service.serviceName}
            </td>
        </tr>
        <tr>
            <th>服务时间</th>
            <td>
                    ${service.serviceDate}
            </td>
        </tr>
        <tr>
            <th>服务位置</th>
            <td>
                    ${service.serviceLocation}
            </td>
        </tr>
        <tr>
            <th witdh="35%">服务内容</th>
            <td width="65%">
                    ${service.serviceContent}
            </td>
        </tr>
        <tr>
            <th witdh="35%">备注</th>
            <td width="65%">
                    ${service.bak}
            </td>
        </tr>
    </table>
</c:forEach>

</body>
</html>