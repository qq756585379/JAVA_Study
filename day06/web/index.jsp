<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/10
  Time: 下午11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript">
        function changeCode() {
            //得到图片元素
            var img = document.getElementsByTagName("img")[0];
            //img.setAttribute("src","/day06/servlet/codeServlet");//XML Dom 语法
            img.src = "/day06/servlet/codeServlet?time=" + new Date().getTime();
        }
    </script>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null) {
        out.print(msg);
    }
%>

<form action="/day06/servlet/DoLogin" method="post">
    用户名：<input type="text" name="userName"/><br>
    密码：<input type="password" name="pwd"/><br>
    验证码：<input type="text" name="code"/>
    <img src="/day06/servlet/codeServlet" onclick="changeCode()"/><a href="javascript:changeCode()">看不清换一张</a><br>
    <input type="submit" value="登录"/><br>
</form>
</body>
</html>
