# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table item (
  item_id                   bigint not null,
  name                      varchar(255),
  category                  varchar(255),
  price_in_cents            float,
  merchant_name             varchar(255),
  constraint pk_item primary key (item_id))
;

create table merchant (
  name                      varchar(255) not null,
  password                  varchar(255),
  constraint pk_merchant primary key (name))
;

create table shopper (
  username                  varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  gender                    varchar(255),
  age                       integer,
  num_likes                 float,
  num_dislikes              float,
  constraint pk_shopper primary key (username))
;

create table shopper_like_item (
  like_id                   bigint not null,
  item_item_id              bigint,
  shopper_username          varchar(255),
  did_like                  boolean,
  constraint pk_shopper_like_item primary key (like_id))
;

create sequence item_seq;

create sequence merchant_seq;

create sequence shopper_seq;

create sequence shopper_like_item_seq;

alter table item add constraint fk_item_merchant_1 foreign key (merchant_name) references merchant (name);
create index ix_item_merchant_1 on item (merchant_name);
alter table shopper_like_item add constraint fk_shopper_like_item_item_2 foreign key (item_item_id) references item (item_id);
create index ix_shopper_like_item_item_2 on shopper_like_item (item_item_id);
alter table shopper_like_item add constraint fk_shopper_like_item_shopper_3 foreign key (shopper_username) references shopper (username);
create index ix_shopper_like_item_shopper_3 on shopper_like_item (shopper_username);



# --- !Downs

drop table if exists item cascade;

drop table if exists merchant cascade;

drop table if exists shopper cascade;

drop table if exists shopper_like_item cascade;

drop sequence if exists item_seq;

drop sequence if exists merchant_seq;

drop sequence if exists shopper_seq;

drop sequence if exists shopper_like_item_seq;

