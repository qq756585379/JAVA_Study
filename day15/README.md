# BookManager

## 1、创建数据库表，并向表中添加测试数据
```
create database day14;
use day14;

create table book(
	id varchar(50) primary key,
	name varchar(50),
	price double,
	pnum int,
	category varchar(30),
	description varchar(200)
)character set utf8 collate utf8_general_ci;

insert into book(id,name, price, pnum, category, description) 

values('1111222','金品梅',28,100,'动作','好书');


select * from book;


在上面员工表的基本上增加一个money列。
ALTER TABLE book ADD money double;
SHOW CREATE TABLE book;

```

