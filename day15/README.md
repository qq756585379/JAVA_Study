# BookManager

## 1、创建数据库表，并向表中添加测试数据
```

mysql -h localhost -u root -p

CREATE DATABASE day14 DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

create database bookStore DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use bookStore;

show tables;

SHOW CREATE database bookStore;

SHOW CREATE TABLE user;

alter database bookStore character set utf8;

ALTER TABLE products DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

**********************用户表*****************************

CREATE TABLE `user` (
  `id` INT(11) AUTO_INCREMENT,
  `username` VARCHAR(20) ,
  `PASSWORD` VARCHAR(20) ,
  `gender` VARCHAR(10) ,
  `email` VARCHAR(50) ,
  `telephone` VARCHAR(20) ,
  `introduce` VARCHAR(100),
  `activeCode` VARCHAR(50) ,
  `state` INT(11) ,
  `role` VARCHAR(10) DEFAULT '普通用户' ,
  `registTime` TIMESTAMP ,
  PRIMARY KEY (`id`)
)character set utf8 collate utf8_general_ci;

**********************商品表*****************************
CREATE TABLE `products` (
  `id` VARCHAR(100) ,
  `name` VARCHAR(40) ,
  `price` DOUBLE ,
  `category` VARCHAR(40) ,
  `pnum` INT(11) ,
  `imgurl` VARCHAR(100) ,
  `description` VARCHAR(255) ,
  PRIMARY KEY (`id`)
)character set utf8 collate utf8_general_ci;

*********************订单表******************************
CREATE TABLE `orders` (
  `id` VARCHAR(100) ,
  `money` DOUBLE ,
  `receiverAddress` VARCHAR(255) ,
  `receiverName` VARCHAR(20) ,
  `receiverPhone` VARCHAR(20) ,
  `paystate` INT(11) ,
  `ordertime` TIMESTAMP ,
  `user_id` INT(11) ,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
)character set utf8 collate utf8_general_ci;

*********************订单项表******************************

CREATE TABLE `orderitem` (
  `order_id` VARCHAR(100) ,
  `product_id` VARCHAR(100),
  `buynum` INT(11) ,
  PRIMARY KEY (`order_id`,`product_id`),
  FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
)character set utf8 collate utf8_general_ci;

*********************************************************




create table book(
	id varchar(50) primary key,
	name varchar(50),
	price double,
	pnum int,
	category varchar(30),
	description varchar(200)
)character set utf8 collate utf8_general_ci;

***************************************************
CREATE TABLE 'author' (
    'authorid' char(20) NOT NULL,
    'name' char(20) NOT NULL,
    'age' char(20) NOT NULL,
    'country' char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

****************************************************
修改数据库字符集

alter database 数据库名 character set utf8;

ps:修改完数据库字符集，需要重启mysql数据库。

修改表字符集

ALTER TABLE  表名 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci

****************************************************

insert into book(id,name, price, pnum, category, description) 

values('1111222','金品梅',28,100,'动作','好书');


insert into book(id,name, price, pnum, category, description) 

values('1111223','iOS',28,100,'动作','好书');

insert into book(id,name, price, pnum, category, description) 

values('1111225','i like u',28,100,'动作','好书');

select * from book;


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

