<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>$Title$</title>
</head>
<body>

<!-- 声明一个变量 num -->
<c:set var="num" value="10" scope="session"></c:set>

输出变量： <c:out value="${num }"></c:out>

<br>
${num }

<c:remove var="num" scope="session"/>

输出变量：<c:out value="${num }" default="aaa"></c:out>

</body>
</html>
