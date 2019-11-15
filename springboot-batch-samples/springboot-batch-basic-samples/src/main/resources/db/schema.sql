;
-- Create table
create table CUST_IR_ORIGINAL
(
  province_id      NUMBER(12),
  lan_id           NUMBER(12),
  access_nbr       VARCHAR2(32),
  service_offer_cd VARCHAR2(30),
  func_ext_prod_id VARCHAR2(30),
  channel_nbr      VARCHAR2(30),
  mkt_res_nbr      VARCHAR2(30),
  outerroamauth    VARCHAR2(10),
  cust_so_number   VARCHAR2(30),
  accept_time      DATE,
  c_imsi           VARCHAR2(32) not null,
  g_imsi           VARCHAR2(32),
  l_imsi           VARCHAR2(32),
  payment_mode_cd  VARCHAR2(6),
  state            NUMBER(5) default -1 not null,
  create_time      DATE default sysdate not null,
  inbound_batch_id VARCHAR2(50)
);


create table person (
  id number(12),
  NAME VARCHAR2(50),
  AGE NUMBER(5)
);
