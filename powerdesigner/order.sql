/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/8/25 10:17:44                           */
/*==============================================================*/


drop table if exists "order";

drop table if exists order_extra;

drop table if exists order_pay;

drop table if exists pay_channel;

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table "order"
(
   id                   int not null auto_increment,
   goods_id             int not null,
   total_price          decimal(15,2) not null,
   user_id              int not null,
   order_time           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: order_extra                                           */
/*==============================================================*/
create table order_extra
(
   order_id             int not null,
   address              varchar(1024) not null,
   buyer                varchar(128) not null,
   mobile               int not null,
   status_id            int not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: order_pay                                             */
/*==============================================================*/
create table order_pay
(
   order_id             int not null,
   pay_channel_id       int not null,
   pay_time             datetime not null,
   outer_order_no       varchar(128) not null,
   primary key (order_id)
);

/*==============================================================*/
/* Table: pay_channel                                           */
/*==============================================================*/
create table pay_channel
(
   id                   int not null,
   name                 varchar(128) not null,
   is_valid             bool not null,
   primary key (id)
);

