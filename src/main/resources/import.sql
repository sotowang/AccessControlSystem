insert into permission(id,name)
values (1,'ADMIN');
insert into identity (id,role) values (1,'普通用户');

insert into department (id,name) values (1,'未知部门');

INSERT into user(cardid, name, password, permission, sex, status, "identity", department)
values ('admin','管理员','123456',1,1,1,1,1);
