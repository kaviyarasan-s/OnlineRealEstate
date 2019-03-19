create table rl_est_land_user(
user_id number(10) constraint rl_est_user_id_pk primary key,
name varchar2(50) not null,
email varchar2(100) constraint rl_est_email_uk not null,
password varchar2(50) not null,
phonenumber number(10) not null,
created_by number(10),
created_date timestamp,
modified_by number(10),
modified_date timestamp
);
select * from rl_est_land; 

select * from rl_est_land_user; 
drop table book1;
truncate table rl_est_land_user;
delete  rl_est_land_user;
commit;
select * from book;
create table book1(id number primary key,
name varchar2(100) not null,
user_id number(10) constraint book11_id_seq references rl_est_land_user(user_id));

select * from rl_est_land;  
drop table book1;
---------------------------
alter table RL_EST_LAND drop constraint rl_est_land_location_id_fk;
------------------------------
alter table rl_est_land_user add modifieddate ;

select *  from rl_est_land_user;
commit;

CREATE TABLE RL_EST_LAND
(land_id NUMBER(10) CONSTRAINT rl_est_land_id_pk PRIMARY KEY,
user_id NUMBER(10) CONSTRAINT rl_est_land_user_id_fk REFERENCES rl_est_land_user(user_id),
property_id NUMBER(10) CONSTRAINT rl_est_land_property_id_fk REFERENCES rl_est_propertytype(property_id),
price NUMBER(10,2) NOT NULL,
bhk NUMBER(2) CONSTRAINT bhk_ck check (bhk > 0),
building_name VARCHAR2(100) NOT NULL,
land_size NUMBER(10,2) NOT NULL,
transaction_type VARCHAR2(30) NOT NULL,
purchasetype VARCHAR2(30) NOT NULL,
location_id NUMBER(10) CONSTRAINT rl_est_land_location_id_fk REFERENCES rl_est_location(location_id),
discount NUMBER(3) default 0,
description VARCHAR2(255) NOT NULL,
created_by number(10),
created_date timestamp,
modified_by number(10),
modified_date timestamp
);



select * from RL_EST_LAND;

select * from rl_est_location;
create table rl_est_propertytype(
property_id number(10) primary key,
name varchar2(50));


select * from rl_est_propertytype;


create sequence propertytype_id_seq start with 1 increment by 1;

insert into rl_est_propertytype values(propertytype_id_seq.nextval,'Villa/House');
insert into rl_est_propertytype values(propertytype_id_seq.nextval,'Apartment');
insert into rl_est_propertytype values(propertytype_id_seq.nextval,'Land/Plots');
insert into rl_est_propertytype values(propertytype_id_seq.nextval,'Commercial');


select * from rl_est_propertytype;

select * from rl_est_city;

select * from rl_est_location;

create table rl_est_city (
city_id number(10) primary key, 
name varchar2 (50) not null); 

create table rl_est_location (
location_id number(10) primary key,
name varchar2(50) not null,
city_id number(10) constraint location_cityid_fk references rl_est_city(city_id));


alter table rl_est_location drop constraint location_cityid_fk;
commit;
--ALTER TABLE city
--modify id primary key;
--
--ALTER TABLE location
--modify id primary key;

select * from rl_est_city;
select * from rl_est_location;

CREATE SEQUENCE  city_id_seq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE  location_id_seq
START WITH 1
INCREMENT BY 1;
select * from rl_est_location;

insert into rl_est_city values(city_id_seq.nextval,'Chennai');
insert into rl_est_city values(city_id_seq.nextval,'Bangalore');
insert into rl_est_city values(city_id_seq.nextval,'Delhi');
insert into rl_est_city values(city_id_seq.nextval,'Hyderabad');

--/chennai
insert into rl_est_location values(location_id_seq.nextval,'Adambakkam',1);
insert into rl_est_location values(location_id_seq.nextval,'Chetpet',1);
insert into rl_est_location values(location_id_seq.nextval,'Egmore',1);
insert into rl_est_location values(location_id_seq.nextval,'Guindy',1);
insert into rl_est_location values(location_id_seq.nextval,'Injambakkam',1);
insert into rl_est_location values(location_id_seq.nextval,'Kodambakkam',1);
insert into rl_est_location values(location_id_seq.nextval,'Madhavaram',1);
insert into rl_est_location values(location_id_seq.nextval,'Nungambakkam',1);
insert into rl_est_location values(location_id_seq.nextval,'Pallavaram',1);
insert into rl_est_location values(location_id_seq.nextval,'Saidapet',1);

--delhi
insert into rl_est_location values(location_id_seq.nextval,'Kirari Suleman Nagar',3);
insert into rl_est_location values(location_id_seq.nextval,'Sultan Pur Majra',3);
insert into rl_est_location values(location_id_seq.nextval,'Bhalswa Jahangir Pur',3);
insert into rl_est_location values(location_id_seq.nextval,'Burari',3);
insert into rl_est_location values(location_id_seq.nextval,'Karawal Nagar',3);
insert into rl_est_location values(location_id_seq.nextval,'Mustafabad',3);
insert into rl_est_location values(location_id_seq.nextval,'Gokal Pur',3);
insert into rl_est_location values(location_id_seq.nextval,'Mandoli',3);
insert into rl_est_location values(location_id_seq.nextval,'Dallo Pura',3);
insert into rl_est_location values(location_id_seq.nextval,'Hastsal',3);

--hyderabad
insert into rl_est_location values(location_id_seq.nextval,'Warangal',4);
insert into rl_est_location values(location_id_seq.nextval,'Khammam',4);
insert into rl_est_location values(location_id_seq.nextval,'Nalgonda',4);
insert into rl_est_location values(location_id_seq.nextval,'Mahabubnagar',4);
insert into rl_est_location values(location_id_seq.nextval,'Ramagundam',4);
insert into rl_est_location values(location_id_seq.nextval,'Nizamabad',4);
insert into rl_est_location values(location_id_seq.nextval,'Suryapet',4);
insert into rl_est_location values(location_id_seq.nextval,'Miryalaguda',4);
insert into rl_est_location values(location_id_seq.nextval,'Karimnagar',4);
insert into rl_est_location values(location_id_seq.nextval,'Mancherial',4);

--bangalore
insert into rl_est_location values(location_id_seq.nextval,'Marathahalli',2);
insert into rl_est_location values(location_id_seq.nextval,'BTM Layout',2);
insert into rl_est_location values(location_id_seq.nextval,'HSR Layout',2);
insert into rl_est_location values(location_id_seq.nextval,'Banashankari',2);
insert into rl_est_location values(location_id_seq.nextval,'Basavanagudi',2);
insert into rl_est_location values(location_id_seq.nextval,'Domlur',2);
insert into rl_est_location values(location_id_seq.nextval,'Jayanagar',2);
insert into rl_est_location values(location_id_seq.nextval,'Koramangala',2);
insert into rl_est_location values(location_id_seq.nextval,'Rajajinagar',2);
insert into rl_est_location values(location_id_seq.nextval,'Sadashivanagar',2);