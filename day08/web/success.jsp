<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
${param.userName }==request.getParamemter("userName");
--%>
欢迎你：${param.userName }

${paramValues.hobby[0] }

${header["User-agent"] }

${cookie.JSESSIONID.value }

</body>
</html>
