## 创建数据库表，并向表中添加测试数据
```

mysql -h localhost -u root -p

查询
查看有多少张表
show tables; 
查看表信息
SHOW CREATE TABLE book;

select * from book;



删除表
DROP TABLE user;

CREATE DATABASE day14 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use day14;

create table book(
	id varchar(50) primary key,
	name varchar(50),
	price double,
	pnum int,
	category varchar(30),
	description varchar(200),
	img_url varchar(200)
)character set utf8 collate utf8_general_ci;

***************************************************************************************
CREATE TABLE 'author' (
    'authorid' char(20) NOT NULL,
    'name' char(20) NOT NULL,
    'age' char(20) NOT NULL,
    'country' char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

***************************************************************************************
修改数据库字符集

alter database 数据库名 character set utf8;

ps:修改完数据库字符集，需要重启mysql数据库。

修改表字符集

ALTER TABLE  表名 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci

***************************************************************************************

insert into book(id,name, price, pnum, category, description) 

values('1111222','金品梅',28,100,'动作','好书');


insert into book(id,name, price, pnum, category, description) 

values('1111223','iOS',28,100,'动作','好书');

insert into book(id,name, price, pnum, category, description) 

values('1111225','i like u',28,100,'动作','好书');


在上面员工表的基本上增加一个money列。
ALTER TABLE book ADD money double;
ALTER TABLE book ADD img_url varchar(50);
1.增加一个字段
alter table user add COLUMN new1 VARCHAR(20) DEFAULT NULL; //增加一个字段，默认为空
alter table user add COLUMN new2 VARCHAR(20) NOT NULL;  //增加一个字段，默认不能为空  www.2cto.com  
 
2.删除一个字段
alter table user DROP COLUMN new2; 　 //删除一个字段
 
3.修改一个字段
alter table user MODIFY new1 VARCHAR(10); 　//修改一个字段的类型
 
alter table user CHANGE new1 new4 int;　 //修改一个字段的名称，此时一定要重新指定该字段的类型

```

