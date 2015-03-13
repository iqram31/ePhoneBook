/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     11/04/2008 15:08:26                          */
/*==============================================================*/


drop table if exists TEMAN;

/*==============================================================*/
/* Table: TEMAN                                                 */
/*==============================================================*/
create table TEMAN
(
   ID_TEMAN             integer not null auto_increment,
   NAMA_TEMAN           varchar(64) not null,
   NO_TELEPON_1         varchar(25) not null,
   NO_TELEPON_2         varchar(25) not null,
   NO_TELEPON_3         varchar(25) not null,
   KETERANGAN           varchar(64) not null,
   primary key (ID_TEMAN)
)
type = InnoDB;

