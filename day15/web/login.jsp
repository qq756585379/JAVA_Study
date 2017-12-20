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
    <title>登录</title>
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
</head>
<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divcontent">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div style="height:470px">
            <table width="85%" border="0" cellspacing="0">
                <tr>
                    <td>
                        <div id="logindiv">
                            <table width="100%" border="0" cellspacing="0">
                                <tr>
                                    <td style="text-align:center; padding-top:20px">
                                        <img src="images/main/logintitle.gif" width="150" height="30"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:center;padding-top:20px;">
                                        <font color="#ff0000">${requestScope["register_message"]}</font>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:center">
                                        <table width="80%" border="0" cellspacing="0"
                                               style="margin-top:15px ;margin-left:auto; margin-right:auto">
                                            <tr>
                                                <td style="text-align:right; padding-top:5px; width:25%">
                                                    用户名：
                                                </td>
                                                <td style="text-align:left">
                                                    <input name="username" type="text"
                                                           class="textinput"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right; padding-top:5px">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                                                <td style="text-align:left">
                                                    <input name="password" type="password"
                                                           class="textinput"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" style="text-align:center">
                                                    <input type="checkbox" name="checkbox"
                                                           value="checkbox"/>
                                                    记住用户名&nbsp;&nbsp;
                                                    <input type="checkbox" name="checkbox"
                                                           value="checkbox"/> 自动登录
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" style="padding-top:10px; text-align:center">
                                                    <input name="image" type="image"
                                                           onclick="return formcheck()"
                                                           src="images/main/loginbutton.gif" width="83"
                                                           height="22"/>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2" style="padding-top:10px">
                                                    <img src="images/main/loginline.gif" width="183"
                                                         height="10"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" style="padding-top:10px; text-align:center">
                                                    <a href="register.jsp">
                                                        <img name="image" src="images/main/signupbutton.gif"
                                                             width="135" height="33"/>
                                                    </a>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td style="text-align:left; padding-top:30px; width:60%"><h1>您还没有注册？</h1>
                        <p>注册新会员，享受更优惠价格!</p>
                        <p>千种图书，供你挑选！注册即享受丰富折扣和优惠，便宜有好货！超过万本图书任您选。</p>
                        <p>超人气社区！精彩活动每一天。买卖更安心！支付宝交易超安全。</p>
                        <p style="text-align:right">
                            <a href="register.jsp">
                                <img src="images/main/signupbutton.gif" width="135" height="33"/>
                            </a>
                        </p>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>

<jsp:include page="foot.jsp"/>

</body>
</html>



