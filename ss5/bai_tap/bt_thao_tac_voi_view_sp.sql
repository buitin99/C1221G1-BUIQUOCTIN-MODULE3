create database san_pham;
use san_pham;

create table product(
id int auto_increment primary key,
product_code int not null,
product_name varchar (50) not null,
product_price double not null,
product_amount int not null,
product_description varchar(50),
product_status varchar(50));

insert into product(product_code,product_name,product_price,product_amount,product_description,product_status) 
values (10,"Bánh",2000,2,"Bánh","còn hàng"),
(20,"kẹo",1000,2,"kẹo","còn hàng"),
(30,"xà phòng",5000,4,"xà phòng","còn hàng"),
(40,"Gạo",10000,3,"Gạo","hết hàng"),
(50,"Chuối",7000,2,"Chuối","còn hàng"),
(60,"Thanh Long",8000,7,"Thanh Long","hết hàng"),
(70,"Rèm",2500,8,"Rèm","còn hàng"),
(80,"Nệm",100000,2,"Nệm","còn hàng"),
(90,"Đậu",8000,6,"Đậu","còn hàng"),
(100,"Sữa",9000,2,"Sữa","còn hàng");

-- bước 3
create view product_view as select product_code,product_price from product;
select* from product_view;

create unique index product_code_idx on product (product_code);

create index product_name_price_idx on product (product_name, product_price);

-- so sánh trước khi tạo index

explain select*from product where product_code = "20";

explain select*from product where product_name = "Bánh" and product_price = 2000;

-- so sánh sau khi tạo index

explain select* from product where product_code = "20";

explain select*from product where product_name = "Bánh" and product_price = 2000;

-- bước 4

create view all_product_view as select product_code, product_name, product_price, product_status from product;

update all_product_view set product_code  = 110 where product_code = 100;

drop view all_product_view;

-- bước 5

DELIMITER //
CREATE PROCEDURE produce_product()
BEGIN
select*from product;
END; //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE edit_product_by_id(in id int(55), in `code` varchar(50), in`name` varchar(50),in price varchar(50),in `status` varchar(50))
BEGIN
update product set product.product_code = `code`,product.product_name = `name`, product.product_price = price, product.product_status = `status` where product.product_id = id ;
END; //
DELIMITER ;

set sql_safe_updates = 0;
call edit_product_by_id(3,"50","tiền",2000,"hết hàng");
set sql_safe_updates = 0;

DELIMITER //
CREATE PROCEDURE delete_product_by_id(in id int(55))
BEGIN
delete from product where product.id = id ;
END; //
DELIMITER ;

set sql_safe_updates = 0;
call delete_product_by_id(2);
set sql_safe_updates = 0;



