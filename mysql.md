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

## 数据库中文乱码问题

```
MySQL中默认字符集的设置有四级:服务器级，数据库级，表级 。最终是字段级 的字符集设置。注意前三种均为默认设置，
并不代码你的字段最终会使用这个字符集设置。所以我们建议要用show create table table ; 
或show full fields from tableName; 来检查当前表中字段的字符集设置。

MySQL中关于连接环境的字符集设置有  Client端，connection, results 通过这些参数，
MySQL就知道你的客户端工具用的是什么字符集，结果集应该是什么字符集。这样MySQL就会做必要的翻译，
一旦这些参数有误，自然会导致字符串在转输过程中的转换错误。基本上99%的乱码由些造成。
```

查看系统字符集设置，包括所有的字符集设置：
>show variables like '%char%';

查看数据表中字符集设置：
>show full columns from tablename;

查看数据库编码：
>show create database dbname;
>show create table tablename;


1.服务器级：
在安装MySQL时可以设置服务器的默认编码格式，也可对my.ini做修改，
修改[mysqld]里面的character_set_server=utf8，则可设置character_set_server的值。

2.数据库级：
CREATE DATABASE db_name DEFAULT CHARACTER SET utf8;

3.表级：
CREATE TABLE db_name.tb_name (id VARCHAR(20) NOT NULL,name VARCHAR(20) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
从下图可看出，定义表的默认字符集为utf8，即使character_set_database为gbk，但是表的列都未utf8

## 修改字符集命令

```
1.修改character_set_connection、character_set_client、character_set_results三值：

对于某一个连接来说，可以使用：
SET NAMES 'charset_name' [COLLATE 'collation_name']
命令
SET NAMES 'charset_name' [COLLATE 'collation_name']
相当于
SET character_set_client = charset_name; 
SET character_set_results = charset_name;
 SET character_set_connection = charset_name;
另外、还可以修改配置文件，对[mysql]下增加default-character-set=utf8，配置成你想要的字符集。
2.修改character_set_database字段：
ALTER DATABASE db_name [[DEFAULT] CHARACTER SET charset_name] [[DEFAULT] COLLATE collation_name]

3.修改character_set_server字段：
最简单的方法是直接改my.ini配置文件里面[mysqld]的字段，增加character-set-server=gbk，
然后重启mysqld，则可改为你想要的字符集。
4.修改表的字符集：
ALTER TABLE tbl_name [[DEFAULT] CHARACTER SET charset_name] [COLLATE collation_name]
5.修改列的字符集：
col_name {CHAR | VARCHAR | TEXT} (col_length) [CHARACTER SET charset_name] [COLLATE collation_name]
例如：
ALTER TABLE t1 MODIFY col1 VARCHAR(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci;

```


参考链接：
http://www.cnblogs.com/sunzn/archive/2013/03/14/2960248.html

https://www.jianshu.com/p/19b2a6e9ed90

