<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${5>3}">
    aaaaaaaaaaa
</c:if>

<c:if test="${5<3}">
    bbbbbb
</c:if>

<c:set var="num" value="${8 }"></c:set>

<c:choose>
    <c:when test="${num==1 }">aaa</c:when>
    <c:when test="${num==2 }">bbb</c:when>
    <c:when test="${num==3 }">ccc</c:when>
    <c:otherwise>
        dddd
    </c:otherwise>
</c:choose>

</body>
</html>
