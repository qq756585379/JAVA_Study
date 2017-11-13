## 1、创建数据库表，并向表中添加测试数据
```
终端登录数据库，末尾不要加分号;
mysql -h localhost -u root -p123123

Create database day09 character set utf8 collate utf8_general_ci;
use day09;

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

```

