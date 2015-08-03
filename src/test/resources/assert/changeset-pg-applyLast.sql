alter table o_address add constraint fk_o_address_country_code foreign key (country_code) references o_country (code) on delete restrict on update restrict;
create index ix_o_address_country_code on o_address (country_code);

alter table car_accessory add constraint fk_car_accessory_car_id foreign key (car_id) references vehicle (id) on delete restrict on update restrict;
create index ix_car_accessory_car_id on car_accessory (car_id);

alter table be_contact add constraint fk_be_contact_customer_id foreign key (customer_id) references be_customer (id) on delete restrict on update restrict;
create index ix_be_contact_customer_id on be_contact (customer_id);

alter table contact_note add constraint fk_contact_note_contact_id foreign key (contact_id) references be_contact (id) on delete restrict on update restrict;
create index ix_contact_note_contact_id on contact_note (contact_id);

alter table be_customer add constraint fk_be_customer_billing_address_id foreign key (billing_address_id) references o_address (id) on delete restrict on update restrict;
create index ix_be_customer_billing_address_id on be_customer (billing_address_id);

alter table be_customer add constraint fk_be_customer_shipping_address_id foreign key (shipping_address_id) references o_address (id) on delete restrict on update restrict;
create index ix_be_customer_shipping_address_id on be_customer (shipping_address_id);

alter table muser add constraint fk_muser_user_type_id foreign key (user_type_id) references muser_type (id) on delete restrict on update restrict;
create index ix_muser_user_type_id on muser (user_type_id);

alter table o_booking add constraint fk_o_booking_invoice_id foreign key (invoice_id) references o_invoice (id) on delete restrict on update restrict;
create index ix_o_booking_invoice_id on o_booking (invoice_id);

alter table o_order add constraint fk_o_order_customer_id foreign key (customer_id) references be_customer (id) on delete restrict on update restrict;
create index ix_o_order_customer_id on o_order (customer_id);

alter table o_order add constraint fk_o_order_shipping_address_id foreign key (shipping_address_id) references o_address (id) on delete restrict on update restrict;
create index ix_o_order_shipping_address_id on o_order (shipping_address_id);

alter table o_order_detail add constraint fk_o_order_detail_order_id foreign key (order_id) references o_order (id) on delete restrict on update restrict;
create index ix_o_order_detail_order_id on o_order_detail (order_id);

alter table o_order_detail add constraint fk_o_order_detail_product_id foreign key (product_id) references o_product (id) on delete restrict on update restrict;
create index ix_o_order_detail_product_id on o_order_detail (product_id);

alter table vehicle add constraint fk_vehicle_truck_ref_id foreign key (truck_ref_id) references truck_ref (id) on delete restrict on update restrict;
create index ix_vehicle_truck_ref_id on vehicle (truck_ref_id);

alter table vehicle add constraint fk_vehicle_car_ref_id foreign key (car_ref_id) references truck_ref (id) on delete restrict on update restrict;
create index ix_vehicle_car_ref_id on vehicle (car_ref_id);

