/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/8/20 19:44:20                           */
/*==============================================================*/


drop table if exists SuperRoot;

drop table if exists Article;

drop table if exists Action;

drop table if exists Department;

drop table if exists ClubUser;

drop table if exists Club;

drop table if exists User;

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
( 
   uid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   phone               varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   uname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   IDCard               varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   faculty              varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   className            varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   heardImg             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   password             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   sex                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   primary key (uid)
);

alter table `User` comment '普通成员信息';

/*==============================================================*/
/* Table: Club                                                  */
/*==============================================================*/
create table Club
(
   cid                  int not null auto_increment,
   cname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   chairman             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   vicechairman         varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   cintro                varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   buildTime            datetime,
   primary key (cid)
);

alter table Club comment '社团信息';


/*==============================================================*/
/* Table: ClubUser                                                  */
/*==============================================================*/
create table ClubUser
(
   uid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   cid                  int not null, 
   did                  int not null,
   position             varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   joinTime             datetime,
   primary key (uid,cid)
);

alter table ClubUser comment '社团成员信息';

/*==============================================================*/
/* Table: Department                                                  */
/*==============================================================*/
create table Department
(
   did                  int not null auto_increment,
   dname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   cid                  int,
   dintro               varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   primary key (did)
);

alter table Department comment '社团部门信息';


/*==============================================================*/
/* Table: Action                                                  */
/*==============================================================*/
create table Action
(
   aid                  int not null auto_increment,
   aname                varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   cid                  int,
   dintro               varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   aImg                 varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   startTime           datetime,
   endTime             datetime,
   primary key (aid)
);

alter table Action comment '活动信息';


/*==============================================================*/
/* Table: Article                                                 */
/*==============================================================*/
create table Article
(
   artid                int not null auto_increment,
   cid                  int,
   uid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   content              text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   title                varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   createTime           datetime,
   primary key (artid)
);

alter table Article comment '发布文章信息';


/*==============================================================*/
/* Table: SuperRoot                                                 */
/*==============================================================*/
create table SuperRoot
(
   superid                  varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci not null ,
   superpassword            varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
   primary key (superid)
);

alter table SuperRoot comment '超级管理员';

ALTER TABLE SuperRoot DEFAULT CHARACTER SET utf8;
ALTER TABLE Article DEFAULT CHARACTER SET utf8;
ALTER TABLE Action DEFAULT CHARACTER SET utf8;
ALTER TABLE Department DEFAULT CHARACTER SET utf8;
ALTER TABLE ClubUser DEFAULT CHARACTER SET utf8;
ALTER TABLE Club DEFAULT CHARACTER SET utf8;
ALTER TABLE User DEFAULT CHARACTER SET utf8;





alter table ClubUser add constraint FK_Relationship_1 foreign key (uid)
      references User (uid) on delete restrict on update restrict;

alter table ClubUser add constraint FK_Relationship_2 foreign key (cid)
      references Club (cid) on delete restrict on update restrict;

