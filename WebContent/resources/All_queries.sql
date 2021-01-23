
CREATE DATABASE foodplaza_hn;

CREATE TABLE food (
  food_id int(11) NOT NULL,
  food_name varchar(255) DEFAULT NULL,
  food_type varchar(255) DEFAULT NULL,
  food_category varchar(255) DEFAULT NULL,
  price int(11) DEFAULT NULL,
  PRIMARY KEY (food_id)
);

CREATE TABLE customer (
  cust_email varchar(255) NOT NULL,
  cust_name varchar(255) DEFAULT NULL,
  cust_pass varchar(255) DEFAULT NULL,
  cust_contact varchar(255) DEFAULT NULL,
  cust_address varchar(255) DEFAULT NULL,
  PRIMARY KEY (cust_email)
 );

CREATE TABLE admin (
  admin_emailid varchar(255) NOT NULL,
  admin_pass varchar(255) DEFAULT NULL,
  PRIMARY KEY (admin_emailid)
 ); 


 CREATE TABLE feedback (
  feedback_id int(11) NOT NULL AUTO_INCREMENT,
  cust_name varchar(30) DEFAULT NULL,
  cust_emailid varchar(30) DEFAULT NULL,
  review varchar(60) DEFAULT NULL,
  suggestion varchar(225) DEFAULT NULL,
  PRIMARY KEY (feedback_id)
 ); 


  CREATE TABLE cart (
  cart_id int(10) NOT NULL AUTO_INCREMENT,
  cust_emailid varchar(255) DEFAULT NULL,
  food_id int(11) DEFAULT NULL,
  food_name varchar(255) DEFAULT NULL,
  cart_quantity int(11) DEFAULT NULL,
  total_price varchar(255) DEFAULT NULL,
  PRIMARY KEY (cart_id)
 );


 CREATE TABLE orders_1 (
  order_id int(11) NOT NULL AUTO_INCREMENT,
  email_id varchar(255) DEFAULT NULL,
  total_price double DEFAULT NULL,
  Date varchar(255) DEFAULT NULL,
  PRIMARY KEY (order_id)
 );
 
  CREATE TABLE cust_order_history (
  order_id int(11) NOT NULL AUTO_INCREMENT,
  email_id varchar(255) DEFAULT NULL,
  food_name varchar(30) DEFAULT NULL,
  quantity int(11) ,
  total_price double DEFAULT NULL,
  Date varchar(255) DEFAULT NULL,
  PRIMARY KEY (order_id)
 );

 USE foodplaza_hn;
