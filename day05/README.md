# request/response

请求转发重定向

get/post乱码解决

```
System.out.println(request.getMethod());//  GET
System.out.println(request.getRequestURL()); // 	http://localhost:8080/day05/servlet/demo1
System.out.println(request.getRequestURI()); //   	/day05/servlet/demo1
System.out.println(request.getContextPath()); // 	/day05
System.out.println(request.getQueryString()); //  	username=tom

```