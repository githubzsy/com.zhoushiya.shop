/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/8/24 22:32:09                           */
/*==============================================================*/


drop table if exists third_party;

drop table if exists user;

drop table if exists user_third;

/*==============================================================*/
/* Table: third_party                                           */
/*==============================================================*/
create table third_party
(
   id                   int not null,
   name                 varchar(32) not null
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   account              varchar(32) not null,
   nick_name            varchar(32) not null,
   mobile               int,
   password             varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: user_third                                            */
/*==============================================================*/
create table user_third
(
   id                   int not null auto_increment,
   user_id              int not null,
   third_party_id       int not null,
   mark                 varchar(128) not null,
   primary key (id)
);

