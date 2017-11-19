<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/myJS.js"></script>
    <title>Insert title here</title>
</head>
<script type="text/javascript">
    window.onload = function () {
        //1、获取XMLHttpRequest对象
        var req = getXMLHttpRequest();
        //4、处理响应结果
        req.onreadystatechange = function () {
            if (req.readyState === 4) {
                if (req.status === 200) {//服务器响应一切正常
                    alert(req.responseText);
                }
            }
        };
        //2、建立一个连接
        req.open("get", "${pageContext.request.contextPath }/servlet/servletDemo1");
        //3、发送请求
        req.send(null);
    }
</script>

<body>

</body>
</html>