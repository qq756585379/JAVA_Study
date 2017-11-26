<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/25
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<script type="text/javascript">
    function addFile() {
        //得到div容器
        var div1 = document.getElementById("div1");
        div1.innerHTML += "<div><input type='file' name='photo' /><input type='button' value='删除' onclick='delFile(this)'/><br /></div>";
    }

    function delFile(input) {
        //使用input对象的爷爷删除他的爸爸
        input.parentNode.parentNode.removeChild(input.parentNode);
    }
</script>
<body>

<form enctype="multipart/form-data" action="${pageContext.request.contextPath }/servlet/uploadServlet2" method="post">
    <input type="text" name="name"/><br/>
    <div id="div1">
        <div>
            <input type="file" name="photo"/><input type="button" value="添加" onclick="addFile()"/><br/>
        </div>
    </div>
    <input type="submit" value="上传"/><br/>
</form>

</body>
</html>
