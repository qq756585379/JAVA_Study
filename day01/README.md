# JDBC

## 1、创建数据库表，并向表中添加测试数据

```
mysql -h localhost -u root -p123123

create database day01;
use day01;

create table users(
	id int primary key auto_increment,
	name varchar(40),
	password varchar(40),
	email varchar(60),
	birthday date
)character set utf8 collate utf8_general_ci;

insert into users(name,password,email,birthday) values('zs','123456','zs@sina.com','1980-12-04');
insert into users(name,password,email,birthday) values('lisi','123456','lisi@sina.com','1981-12-04');
insert into users(name,password,email,birthday) values('wangwu','123456','wangwu@sina.com','1979-12-04');

在上面员工表的基本上增加一个money列。
ALTER TABLE users ADD money float;
SHOW CREATE TABLE users;

update users set password = MD5(password) where id = 1;
```

