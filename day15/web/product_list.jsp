<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/12/17
  Time: 上午12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css"/>
</head>

<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divpagecontent">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td>
                <div style="text-align:right; margin:5px 10px 5px 0">
                    <a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;
                    计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
                </div>
                <table cellspacing="0" class="listcontent">
                    <tr>
                        <td>
                            <h1>商品目录</h1>
                            <hr/>
                            <h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
                            <hr/>
                            <div style="margin-top:20px; margin-bottom:5px">
                                <img src="${pageContext.request.contextPath }/images/main/productlist.gif" width="631"
                                     height="38"/>
                            </div>

                            <table cellspacing="0" class="booklist">
                                <tr>
                                    <c:forEach items="${pb.products }" var="b">
                                        <td>
                                            <div class="divbookpic">
                                                <p>
                                                    <a href="#">
                                                        <img src="${pageContext.request.contextPath }/upload/${b.img_url}"
                                                             width="115" height="129" border="0"/>
                                                    </a>
                                                </p>
                                            </div>
                                            <div class="divlisttitle">
                                                <a href="${pageContext.request.contextPath }/servlet/findBookInfoServlet?id=${b.id}">
                                                    书名:${b.name }<br/>售价:${b.price }
                                                </a>
                                            </div>
                                        </td>
                                    </c:forEach>
                                </tr>
                            </table>

                            <div class="pagination">
                                <ul>
                                    <li class="disablepage">
                                        <a href="${pageContext.request.contextPath  }/pageServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}&category=${pb.category}">&lt;&lt;上一页</a>
                                    </li>
                                    <li>第${pb.currentPage }页/共${pb.totalPage }页</li>
                                    <li class="nextPage">
                                        <a href="${pageContext.request.contextPath  }/pageServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}&category=${pb.category}">&lt;&lt;下一页</a>
                                    </li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>

<jsp:include page="foot.jsp"/>

</body>
</html>
