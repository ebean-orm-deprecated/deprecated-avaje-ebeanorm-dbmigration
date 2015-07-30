create table o_address (
  id                        bigint not null,
  line1                     varchar(100),
  line2                     varchar(100),
  city                      varchar(100),
  country_code              varchar(2),
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint pk_o_address primary key (id))
;

create table car_accessory (
  id                        bigint not null,
  name                      varchar(255),
  car_id                    bigint,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint pk_car_accessory primary key (id))
;

create table be_contact (
  id                        bigint not null,
  first_name                varchar(50),
  last_name                 varchar(50),
  email                     varchar(200),
  phone                     varchar(20),
  customer_id               bigint not null,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint pk_be_contact primary key (id))
;

create table contact_note (
  id                        bigint not null,
  contact_id                bigint not null,
  title                     varchar(255),
  note                      clob,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint pk_contact_note primary key (id))
;

create table o_country (
  code                      varchar(2) not null,
  name                      varchar(60),
  constraint pk_o_country primary key (code))
;

create table be_customer (
  id                        bigint not null,
  inactive                  boolean,
  name                      varchar(100),
  registered                timestamp,
  comments                  varchar(1000),
  billing_address_id        bigint,
  shipping_address_id       bigint,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint uq_be_customer_name unique (name),
  constraint pk_be_customer primary key (id))
;

create table o_order (
  id                        bigint not null,
  status                    varchar(1),
  order_date                date,
  ship_date                 date,
  customer_id               bigint,
  shipping_address_id       bigint,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint ck_o_order_status check (status in ('N','C','A','S')),
  constraint pk_o_order primary key (id))
;

create table o_order_detail (
  id                        bigint not null,
  order_id                  bigint,
  order_qty                 integer,
  ship_qty                  integer,
  unit_price                double,
  product_id                bigint,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint pk_o_order_detail primary key (id))
;

create table o_product (
  id                        bigint not null,
  sku                       varchar(20),
  name                      varchar(255),
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  constraint pk_o_product primary key (id))
;

create table truck_ref (
  id                        integer not null,
  something                 varchar(255),
  constraint pk_truck_ref primary key (id))
;

create table vehicle (
  dtype                     varchar(3) not null,
  id                        bigint not null,
  license_number            varchar(255),
  registration_date         timestamp,
  version                   bigint not null,
  when_created              timestamp not null,
  when_modified             timestamp not null,
  truck_ref_id              integer,
  capacity                  double,
  driver                    varchar(255),
  car_ref_id                integer,
  constraint pk_vehicle primary key (id))
;

create sequence o_address_seq;

create sequence car_accessory_seq;

create sequence be_contact_seq;

create sequence contact_note_seq;

create sequence o_country_seq;

create sequence be_customer_seq;

create sequence o_order_seq;

create sequence o_order_detail_seq;

create sequence o_product_seq;

create sequence truck_ref_seq;

create sequence vehicle_seq;

alter table o_address add constraint fk_o_address_country_1 foreign key (country_code) references o_country (code) on delete restrict on update restrict;
create index ix_o_address_country_1 on o_address (country_code);
alter table car_accessory add constraint fk_car_accessory_car_2 foreign key (car_id) references vehicle (id) on delete restrict on update restrict;
create index ix_car_accessory_car_2 on car_accessory (car_id);
alter table be_contact add constraint fk_be_contact_customer_3 foreign key (customer_id) references be_customer (id) on delete restrict on update restrict;
create index ix_be_contact_customer_3 on be_contact (customer_id);
alter table contact_note add constraint fk_contact_note_contact_4 foreign key (contact_id) references be_contact (id) on delete restrict on update restrict;
create index ix_contact_note_contact_4 on contact_note (contact_id);
alter table be_customer add constraint fk_be_customer_billingAddress_5 foreign key (billing_address_id) references o_address (id) on delete restrict on update restrict;
create index ix_be_customer_billingAddress_5 on be_customer (billing_address_id);
alter table be_customer add constraint fk_be_customer_shippingAddress_6 foreign key (shipping_address_id) references o_address (id) on delete restrict on update restrict;
create index ix_be_customer_shippingAddress_6 on be_customer (shipping_address_id);
alter table o_order add constraint fk_o_order_customer_7 foreign key (customer_id) references be_customer (id) on delete restrict on update restrict;
create index ix_o_order_customer_7 on o_order (customer_id);
alter table o_order add constraint fk_o_order_shippingAddress_8 foreign key (shipping_address_id) references o_address (id) on delete restrict on update restrict;
create index ix_o_order_shippingAddress_8 on o_order (shipping_address_id);
alter table o_order_detail add constraint fk_o_order_detail_order_9 foreign key (order_id) references o_order (id) on delete restrict on update restrict;
create index ix_o_order_detail_order_9 on o_order_detail (order_id);
alter table o_order_detail add constraint fk_o_order_detail_product_10 foreign key (product_id) references o_product (id) on delete restrict on update restrict;
create index ix_o_order_detail_product_10 on o_order_detail (product_id);
alter table vehicle add constraint fk_vehicle_truckRef_11 foreign key (truck_ref_id) references truck_ref (id) on delete restrict on update restrict;
create index ix_vehicle_truckRef_11 on vehicle (truck_ref_id);
alter table vehicle add constraint fk_vehicle_carRef_12 foreign key (car_ref_id) references truck_ref (id) on delete restrict on update restrict;
create index ix_vehicle_carRef_12 on vehicle (car_ref_id);


