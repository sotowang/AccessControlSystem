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

# User
整体API
```markdown
GET /users  展现用户列表   list.html
GET  /users/{id}  展现用户  view.html
GET /users/form 新增或修改用户 form.html
POST /users 用于新增或修改用户请求处理 成功后重定向到list.html页面
GET /users/delete/{id} 删除用户  成功后重定向到list.html页面
GET /users/modify/{id} 根据cardId 获取相应用户，返回form页面来执行修改

```