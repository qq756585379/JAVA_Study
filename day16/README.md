# Ajax

JavaScript中XMLHttpRequest对象是整个Ajax技术的核心，它提供了异步发送请求的能力 
- 构造方法

```
不同浏览器，甚至相同浏览器的不同版本，获取该对象的方式是不同的。
function getXMLHttpRequest() {
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}

```


- 方法：


```
open()  "get|post" ，"url?name=tom" ，"true|false"
   
send()  发送请求 。可以带参数 或 null
   
setRequestHeader()

```

- 属性


```
readyState：类型short；只读
responseText：类型String；只读
responseXML：类型Document；只读
status：类型short；只读
```

- 事件处理器

onreadystatechange


## 常用方法 

open(method,URL,async)  

```
建立与服务器的连接
method参数指定请求的HTTP方法,典型的值是GET或POST
URL参数指请求的地址
async参数指定是否使用异步请求，其值为true或false
```

send(content) 

```
发送请求
content参数指定请求的参数 
```

setRequestHeader(header,value) 

```
设置请求的头信息 
```