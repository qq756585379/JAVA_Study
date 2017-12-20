<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/12/10
  Time: 下午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <script type="text/javascript">
        function changeImage() {
            document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time=" + new Date().getTime();
        }

        //验证油箱是否存在
        function ckEmail() {
            //得到油箱对象
            var email = document.getElementsByName("email")[0];
            var xhr = getXMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4) {
                    if (xhr.status === 200) {
                        //得到font标签
                        var font = document.getElementsByTagName("font")[0];
                        if (xhr.responseText === "true") {
                            font.innerHTML = "油箱已被使用";
                            font.style.color = "red";
                        } else {
                            font.innerHTML = "油箱可以使用";
                            font.style.color = "lime";
                        }
                    }
                }
            };
            xhr.open("get", "${pageContext.request.contextPath}/servlet/ckEmailServlet?email=" + email.value);
            xhr.send(null);
        }
    </script>
</head>

<body class="main">

<%@include file="head.jsp" %>
<%@include file="menu_search.jsp" %>

<div id="divcontent">
    <form action="${pageContext.request.contextPath}/register" method="post">
        <table width="850px" border="0" cellspacing="0">
            <tr>
                <td style="padding:30px">
                    <h1>新会员注册</h1>

                    <table width="70%" border="0" cellspacing="2" class="upline">
                        <tr>
                            <td style="text-align:right; width:20%">会员邮箱：</td>
                            <td style="width:40%">
                                <input type="text" class="textinput" name="email" onblur="ckEmail()"/>
                            </td>
                            <td><font color="#999999">请输入有效的邮箱地址</font></td>
                        </tr>
                        <tr>
                            <td style="text-align:right">会员名：</td>
                            <td>
                                <input type="text" class="textinput" name="username"/>
                            </td>
                            <td><font color="#999999">用户名设置至少6位</font></td>
                        </tr>
                        <tr>
                            <td style="text-align:right">密码：</td>
                            <td>
                                <input type="password" class="textinput" name="password"/>
                            </td>
                            <td><font color="#999999">密码设置至少6位</font></td>
                        </tr>
                        <tr>
                            <td style="text-align:right">重复密码：</td>
                            <td>
                                <input type="password" class="textinput" name="repassword"/>
                            </td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td style="text-align:right">性别：</td>
                            <td colspan="2">
                                &nbsp;&nbsp;<input type="radio" name="gender" value="男" checked="checked"/> 男
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="radio" name="gender" value="女"/> 女
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align:right">联系电话：</td>
                            <td colspan="2">
                                <input type="text" class="textinput" style="width:350px" name="telephone"/>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align:right">个人介绍：</td>
                            <td colspan="2">
                                <textarea class="textarea" name="introduce"></textarea>
                            </td>
                        </tr>

                    </table>

                    <h1>注册校验</h1>
                    <table width="80%" border="0" cellspacing="2" class="upline">
                        <tr>
                            <td style="text-align:right; width:20%">输入校验码：</td>
                            <td style="width:50%">
                                <input type="text" class="textinput"/>
                            </td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td style="text-align:right;width:20%;">&nbsp;</td>
                            <td colspan="2" style="width:50%">
                                <img src="${pageContext.request.contextPath}/imageCode" width="180"
                                     height="30" onclick="changeImage()" class="textinput" style="height:30px;"
                                     id="img"/>
                                &nbsp;&nbsp;
                                <a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
                            </td>
                        </tr>
                    </table>

                    <table width="70%" border="0" cellspacing="0">
                        <tr>
                            <td style="padding-top:20px; text-align:center">
                                <input type="image" src="images/main/signup.gif" name="submit" border="0">
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="divfoot">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td rowspan="2" style="width:10%">
                <img src="images/main/bottomlogo.gif" width="195" height="50" style="margin-left:175px"/>
            </td>
            <td style="padding-top:5px; padding-left:50px">
                <a href="#"><font color="#747556"><b>CONTACT US</b> </font> </a>
            </td>
        </tr>
        <tr>
            <td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT 2008 &copy; eShop All Rights RESERVED.</b>
            </font></td>
        </tr>
    </table>
</div>

</body>
</html>
