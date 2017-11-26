<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/25
  Time: 下午11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>

<form enctype="multipart/form-data" action="${pageContext.request.contextPath }/servlet/uploadServlet2" method="post">
    <input type="text" name="name"/><br/>
    <input type="file" name="photo"/><br/>
    <input type="submit" value="上传"/><br/>
</form>

</body>
</html>
