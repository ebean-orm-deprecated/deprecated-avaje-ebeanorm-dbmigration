SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists o_address;

drop table if exists blob_holder;

drop table if exists car_accessory;

drop table if exists be_contact;

drop table if exists contact_note;

drop table if exists o_country;

drop table if exists be_customer;

drop table if exists document;

drop table if exists mrole;

drop table if exists mrole_muser;

drop table if exists muser;

drop table if exists muser_type;

drop table if exists o_booking;

drop table if exists o_invoice;

drop table if exists o_order;

drop table if exists o_order_detail;

drop table if exists o_product;

drop table if exists truck_ref;

drop table if exists vehicle;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists o_address_seq;

drop sequence if exists blob_holder_seq;

drop sequence if exists car_accessory_seq;

drop sequence if exists be_contact_seq;

drop sequence if exists contact_note_seq;

drop sequence if exists o_country_seq;

drop sequence if exists be_customer_seq;

drop sequence if exists document_seq;

drop sequence if exists mrole_seq;

drop sequence if exists muser_seq;

drop sequence if exists muser_type_seq;

drop sequence if exists o_booking_seq;

drop sequence if exists o_invoice_seq;

drop sequence if exists o_order_seq;

drop sequence if exists o_order_detail_seq;

drop sequence if exists o_product_seq;

drop sequence if exists truck_ref_seq;

drop sequence if exists vehicle_seq;

