drop table if exists W_USER;

/*==============================================================*/
/* Table: W_USER                                                */
/*==============================================================*/
create table W_USER
(
   user_id              int not null auto_increment comment '用户id',
   login_name           varchar(50) comment '登陆名',
   user_name            varchar(50) not null comment '用户名',
   password             varchar(50) not null comment '密码',
   phone                varchar(15) not null comment '手机号',
   email                varchar(50) comment '邮箱',
   create_date          datetime not null default current_timestamp comment '创建时间',
   primary key (user_id)
);

alter table W_USER comment '用户表';
