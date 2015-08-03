drop index ix_o_address_country_code;
alter table o_address drop constraint fk_o_address_country_code;

drop index ix_car_accessory_car_id;
alter table car_accessory drop constraint fk_car_accessory_car_id;

drop index ix_be_contact_customer_id;
alter table be_contact drop constraint fk_be_contact_customer_id;

drop index ix_contact_note_contact_id;
alter table contact_note drop constraint fk_contact_note_contact_id;

drop index ix_be_customer_billing_address_id;
alter table be_customer drop constraint fk_be_customer_billing_address_id;

drop index ix_be_customer_shipping_address_id;
alter table be_customer drop constraint fk_be_customer_shipping_address_id;

drop index ix_muser_user_type_id;
alter table muser drop constraint fk_muser_user_type_id;

drop index ix_o_booking_invoice_id;
alter table o_booking drop constraint fk_o_booking_invoice_id;

drop index ix_o_order_customer_id;
alter table o_order drop constraint fk_o_order_customer_id;

drop index ix_o_order_shipping_address_id;
alter table o_order drop constraint fk_o_order_shipping_address_id;

drop index ix_o_order_detail_order_id;
alter table o_order_detail drop constraint fk_o_order_detail_order_id;

drop index ix_o_order_detail_product_id;
alter table o_order_detail drop constraint fk_o_order_detail_product_id;

drop index ix_vehicle_truck_ref_id;
alter table vehicle drop constraint fk_vehicle_truck_ref_id;

drop index ix_vehicle_car_ref_id;
alter table vehicle drop constraint fk_vehicle_car_ref_id;

