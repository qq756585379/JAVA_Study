## 目录

### day01 - jdbc
### day02 - xml解析
### day03 - 读取本地文件，请求转发重定向
### day04 - 验证码jar，请求转发重定向
### day05 - post和get乱码问题，请求转发重定向
### day09 - 注册登录小demo,BeanUtils
### day10 - 事物，连接池
连接池
- 目的：解决建立数据库连接耗费资源和时间很多的问题，提高性能，day10之前都没有使用连接池

### day11 - DBCP/c3p0 框架，自动创建连接池

用JavaWeb服务器管理数据源：Tomcat (了解)

开发JavaWeb应用，必须使用一个JavaWeb服务器，JavaWeb服务器都内置数据源。
Tomcat：（DBCP）

数据源只需要配置服务器即可。

配置数据源的步骤：
 
1、拷贝数据库连接的jar到tomcatlib目录下

2、配置数据源XML文件

a)如果把配置信息写在tomcat下的conf目录的context.xml中，那么所有应用都能使用此数据源。

b)如果是在当前应用的META-INF中创建context.xml, 编写数据源，那么只有当前应用可以使用。




