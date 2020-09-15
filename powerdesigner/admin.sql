/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/8/30 10:32:32                           */
/*==============================================================*/


drop table if exists shop_admin;

/*==============================================================*/
/* Table: shop_admin                                            */
/*==============================================================*/
create table shop_admin
(
   id                   int not null,
   account              varchar(128) not null,
   password             varchar(128) not null,
   isvalid              bool not null,
   primary key (id)
);

