create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table quan_ly_ban_hang.customer(
cid int,
cname varchar(50),
cage varchar(50),
primary key(cid));

create table `order`(
oid int,
cid int,
odate datetime,
ototalprice varchar(20),
primary key(oid),
foreign key(cid) references customer(cid));

create table product(
pid int auto_increment,
pname varchar(25),
pprice double,
oid int,
primary key(pid),
foreign key(oid) references `order`(oid));

create table orderdetail(
oid int,
pid int(50),
odqty varchar(50),
primary key(oid,pid),
foreign key(oid) references `order`(oid),
foreign key(pid) references product(pid)
);

insert into quan_ly_ban_hang.customer values(1,"Minh Quan",10),(2,"Ngoc Oanh",20),(3,"Hong Ha",50);
insert into quan_ly_ban_hang.`order` values(1,1,"2006-03-21",null),(2,2,"2006-03-23",null),(3,1,"2006-03-16",null);
insert into quan_ly_ban_hang.product (pname,pprice) values ("May Lanh",3),("Tu Lanh",5),("Dieu Hoa",7),("Quat",1),("Bep Dien",2);
insert into quan_ly_ban_hang.orderdetail(oid,pid,odqty) values (1,1,"3"),(1,3,"7"),(1,4,"2"),(2,1,"1"),(3,1,"8"),(2,5,"4"),(2,3,"3");

select oid,odate,ototalprice from `order`;
select customer.cname,product.pname from customer
 join `order` on customer.cid = `order`.oid 
 join orderdetail on `order`.oid = orderdetail.oid 
 join product on orderdetail.oid = product.pid;



