/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/8/24 22:24:51                           */
/*==============================================================*/


drop table if exists goods;

drop table if exists goods_pic;

drop table if exists goods_stock;

drop table if exists goods_type;

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   id                   int not null,
   name                 varchar(128) not null,
   goods_type_id        int not null,
   description          text,
   primary key (id)
);

/*==============================================================*/
/* Table: goods_pic                                             */
/*==============================================================*/
create table goods_pic
(
   id                   int not null,
   goods_id             int not null,
   pic_url              varchar(512) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: goods_stock                                           */
/*==============================================================*/
create table goods_stock
(
   goods_id             int not null,
   stock                int not null,
   primary key (goods_id)
);

/*==============================================================*/
/* Table: goods_type                                            */
/*==============================================================*/
create table goods_type
(
   id                   int not null auto_increment,
   name                 varchar(128) not null,
   parent_id            int,
   primary key (id)
);

