<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/13
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/calendar.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/css/calendar.js"></script>
</head>
<body>

${msg }

<form action="${pageContext.request.contextPath }/servlet/regServlet" method="post">
    用户名：<input type="text" name="name" value="${uf.name }"/>${uf.msg.name }${error }<br/>
    密码：<input type="password" name="password"/>${uf.msg.password }<br/>
    确认密码：<input type="password" name="repassword"/>${uf.msg.repassword }<br/>
    油箱：<input type="text" name="email" value="${uf.email }"/>${uf.msg.email }<br/>

    <%-- 这个日期选择器无效，手动输入 1991-02-09 --%>
    生日：<input type="text" name="birthday" value="${uf.birthday }"
              onclick="return showCalendar('birthday', 'y-mm-dd');"/>

    ${uf.msg.birthday }<br/>

    <input type="submit" value="注册"/><br/>
</form>

</body>
</html>
