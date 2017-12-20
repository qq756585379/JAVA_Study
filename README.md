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
```

用JavaWeb服务器管理数据源：Tomcat (了解)

开发JavaWeb应用，必须使用一个JavaWeb服务器，JavaWeb服务器都内置数据源。
Tomcat：（DBCP）

数据源只需要配置服务器即可。

配置数据源的步骤：
 
1、拷贝数据库连接的jar到tomcatlib目录下

2、配置数据源XML文件

a)如果把配置信息写在tomcat下的conf目录的context.xml中，那么所有应用都能使用此数据源。

b)如果是在当前应用的META-INF中创建context.xml, 编写数据源，那么只有当前应用可以使用。
```

DBUtils介绍  apache

```
DBUtils是java编程中的数据库操作实用工具，小巧简单实用。
DBUtils封装了对JDBC的操作，简化了JDBC操作。可以少写代码。
1.对于数据表的读操作，他可以把结果转换成List，Array，Set等java集合，便于程序员操作；
2.对于数据表的写操作，也变得很简单（只需写sql语句）
3.可以使用数据源，使用JNDI，数据库连接池等技术来优化性能--重用已经构建好的数据库连接对象

```

DBUtils的三个核心对象

```
> QueryRunner类
> ResultSetHandler接口
> DBUtils类

QueryRunner类
QueryRunner中提供对sql语句操作的API.
它主要有三个方法
query() 用于执行select 
update() 用于执行insert update delete
batch() 批处理
ResultSetHandler接口
用于定义select操作后，怎样封装结果集.
DbUtils类
它就是一个工具类,定义了关闭资源与事务处理的方法

```

Dbutils快速入门


```
> 导入jar包			
> 创建QueryRunner对象
> 使用query方法执行select语句
> 使用ResultSetHandler封装结果集
> 使用DbUtils类释放资源

Dbutils快速入门实现步骤：
创建数据库及表
CREATE DATABASE day14;
USE day14;

create table account(
	id int primary key auto_increment,
	name varcar(50),
	money float
);

insert into account(name,money) values('aaa',1000);
insert into account(name,money) values('bbb',1000);
insert into account(name,money) values('ccc',1000);

SELECT * FROM account;

第一步:导入jar包,注意: c3p0与mysql驱动jar也要导入。
//创建QueryRunner对象
//使用query方法执行select语句
//使用ResultSetHandler封装结果集
//使用DbUtils类释放资源



```


### day15 - BookManager

```
> 动态验证码
> 文件上传,文件打散
```

### day16 - Ajax
### day17 - 过滤器解决乱码问题，自动登录demo

### day19 - Uploadload/download