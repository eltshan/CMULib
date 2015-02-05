# --- First database schema

# --- !Ups

create table computer (
  id                        bigint not null,
  name                      varchar(255),
  lastconnection            varchar(255),
  ipaddress                 varchar(255),
  portnum                   bigint,
  constraint pk_computer primary key (id))
;

create sequence computer_seq start with 1000;


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists computer;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists computer_seq;

