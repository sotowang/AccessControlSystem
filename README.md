# AccessControlSystem
Spring Boot + Spring Data JPA

# 创建表
* user表

```sql
create table user
(
	id int auto_increment
		primary key,
	cardid varchar(15) null comment '一卡通号',
	name varchar(20) null comment '姓名
',
	sex int null comment '性别：1,男  2：女',
	status int null comment '状态：1.正常 2.异常',
	permission int null comment '1最小',
	department varchar(120) null comment '所在部门/院',
	identity int null comment '身份：1，学生 2.老师 3.其他',
	constraint user_cardid_uindex
		unique (cardid)
)
;



```
