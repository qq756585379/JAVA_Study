<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/myJS.js"></script>
    <title>Insert title here</title>
    <script type="text/javascript">
        function ckName() {
            //获取用户名
            var name = document.getElementsByTagName("input")[0];
            //创建XMLHttpRequest对象
            var xhr = getXMLHttpRequest();
            //处理结果
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {//请求一切正常
                    if (xhr.status === 200) {//服务器响应一切正常
                        var msg = document.getElementById("msg");
                        if (xhr.responseText === "true") {
                            msg.innerHTML = "<font color='red'>用户名已存在</font>";
                            //msg.innerText = "<font color='red'>用户名已存在</font>";
                        } else {
                            msg.innerHTML = "可以使用";
                        }
                    }
                }
            };
            //创建连接
            xhr.open("get", "${pageContext.request.contextPath }/servlet/ckNameServlet?name=" + name.value);
            //发送请求
            xhr.send(null);
        }

        window.onload = function () {
            var nameElement = document.getElementsByName("userName")[0];
            nameElement.onblur = function () {
                var name = this.value;//this等价于nameElement
                //创建XMLHttpRequest对象
                var xhr = getXMLHttpRequest();
                //处理结果
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4) {//请求一切正常
                        if (xhr.status === 200) {//服务器响应一切正常
                            var msg = document.getElementById("msg");
                            if (xhr.responseText === "true") {
                                msg.innerHTML = "<font color='red'>用户名已存在</font>";
                                //msg.innerText = "<font color='red'>用户名已存在</font>";
                            } else {
                                msg.innerHTML = "可以使用";
                            }
                        }
                    }
                };
                //创建连接
                xhr.open("get", "${pageContext.request.contextPath }/servlet/ckNameServlet?name=" + name.value);
                //发送请求
                xhr.send(null);
            }
        }
    </script>
</head>

<body>
用户名：<input type="text" name="userName"/><span id="msg"></span>
<br/>
密码<input type="password" name="pwd"/>
<br/>
<a onclick="ckName()" style="border: solid 1px red">提交</a>

</body>
</html>