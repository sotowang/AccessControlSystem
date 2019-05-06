use access;
create table department
(
  id   int auto_increment
    primary key,
  name varchar(128) null
);

create table identity
(
  id   int auto_increment
    primary key,
  role varchar(128) null
);

create table permission
(
  id   int auto_increment
    primary key,
  name varchar(128) null
);

create table top_locate
(
  id      int auto_increment
    primary key,
  address varchar(64) null,
  top     int         null
  comment '上一级地址',
  down    int         null
  comment '下一级地址'
)
  comment '工作区';

create table second_locate
(
  id      int auto_increment
    primary key,
  top     int         null,
  down    int         null,
  address varchar(32) null,
  constraint sec_top_fk
  foreign key (top) references top_locate (id)
    on update cascade
    on delete cascade
);

create index sec_top_fk
  on second_locate (top);

create table third_locate
(
  id      int auto_increment
    primary key,
  top     int         null,
  address varchar(32) null,
  constraint third_second_fk
  foreign key (top) references second_locate (id)
    on update cascade
    on delete cascade
);

create table facility
(
  fid        int auto_increment
  comment '主键：设备id'
    primary key,
  start_time time default '00:00:01' null
  comment '开始时间',
  end_time   time default '23:59:59' null
  comment '结束时间',
  permission int default '10'        null,
  locate     int                     null
  comment '三级工作区',
  type       int default '3'         null
  comment '类型：1,单进 2。单出 3，双进出',
  status     int default '2'         null
  comment '状态：1.关闭 2.开放',
  ip_addr    varchar(128)            null,
  server_ip  varchar(128)            null,
  name       varchar(64)             null
  comment '考勤机名称',
  constraint facility_thirdlocate_id
  foreign key (locate) references third_locate (id)
    on update cascade
    on delete set null
)
  comment '门禁';

create index facility_thirdlocate_id
  on facility (locate);

create index third_second_fk
  on third_locate (top);

create table user
(
  cardid     varchar(15)                         not null
  comment '一卡通号'
    primary key,
  name       varchar(20)                         null
  comment '姓名
',
  password   varchar(100)                        null
  comment '密码',
  permission int                                 null
  comment '1最小',
  sex        int                                 null
  comment '性别：1,男  2：女',
  status     int                                 null
  comment '状态：1.正常 2.异常',
  identity   int                                 null
  comment '身份：1，学生 2.老师 3.其他',
  department int                                 null
  comment '所在部门/院',
  time       timestamp default CURRENT_TIMESTAMP null
  on update CURRENT_TIMESTAMP
  comment '时间',
  constraint user_permission_permission
  foreign key (permission) references permission (id)
    on update cascade
    on delete set null,
  constraint user_identity_identity
  foreign key (identity) references identity (id)
    on update cascade
    on delete set null,
  constraint user_department_department
  foreign key (department) references department (id)
    on update cascade
    on delete set null
);

create table record
(
  record_id  int auto_increment
    primary key,
  fid        int                                 null
  comment '考勤机id',
  cardid     varchar(32)                         null
  comment '卡号',
  time       timestamp default CURRENT_TIMESTAMP null
  comment '刷卡时间',
  type       int(1) default '1'                  null
  comment '1。进门 2。出门',
  name       varchar(32)                         null
  comment '刷卡人姓名',
  role       int                                 null
  comment '刷卡人身份',
  department int                                 null
  comment '部门',
  locate     int                                 null
  comment '三级工作区',
  constraint record_facility_id
  foreign key (fid) references facility (fid)
    on update cascade
    on delete set null,
  constraint record_user_id
  foreign key (cardid) references user (cardid)
    on update cascade
    on delete set null,
  constraint record_identity_role
  foreign key (role) references identity (id)
    on update cascade
    on delete set null,
  constraint record_department_department
  foreign key (department) references department (id)
    on update cascade
    on delete set null,
  constraint record_third_locate_locate
  foreign key (locate) references third_locate (id)
    on update cascade
    on delete set null
)
  comment '刷卡记录表';

create index idx_cardid
  on record (cardid);

create index idx_fid
  on record (fid);

create index record_department_department
  on record (department);

create index record_identity_role
  on record (role);

create index record_third_locate_locate
  on record (locate);

create index user_department_department
  on user (department);

create index user_identity_identity
  on user (identity);

create index user_permission_permission
  on user (permission);

create table user_permission
(
  user_cardid   varchar(32) null,
  permission_id int         null,
  constraint fk_user_cardid
  foreign key (user_cardid) references user (cardid)
    on update cascade
    on delete set null,
  constraint fk_permission_id
  foreign key (permission_id) references permission (id)
    on update cascade
    on delete set null
);

create index fk_permission_id
  on user_permission (permission_id);

create index fk_user_cardid
  on user_permission (user_cardid);

create table whitelist
(
  wid        int auto_increment
    primary key,
  cardid     varchar(32) null
  comment '卡号',
  locate     int         null
  comment '工作区',
  start_date date        null,
  end_date   date        null,
  vip        int         null
  comment '0,非vip  1，是vip',
  constraint whitelist_third_locate_locate
  foreign key (locate) references third_locate (id)
    on update cascade
    on delete set null
)
  comment '白名单';

create index idx_cardid
  on whitelist (cardid);

create index whitelist_third_locate_locate
  on whitelist (locate);
