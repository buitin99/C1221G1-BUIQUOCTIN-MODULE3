create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table quan_ly_ban_hang.customer(
cid int auto_increment,
cname varchar(50),
cage datetime,
primary key(cid));

create table `order`(
oid int auto_increment,
cid int,
odate datetime,
ototalprice varchar(20),
primary key(oid),
foreign key(cid) references customer(cid));

create table product(
pid int auto_increment,
pname varchar(50),
pprice varchar(50),
oid int,
primary key(pid),
foreign key(oid) references `order`(oid));

create table orderdetail(
oid int,
pid int,
odqty varchar(50),
primary key(oid,pid),
foreign key(oid) references `order`(oid),
foreign key(pid) references product(pid)
);