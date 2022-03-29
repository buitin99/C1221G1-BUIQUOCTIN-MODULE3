create database casestudy_database;
use casestudy_database;

create table casestudy_database.nhan_vien(
ma_nhan_vien int auto_increment,
ho_ten varchar(50) not null,
ngay_sinh date not null,
so_cmnd varchar(45) not null,
luong double not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
primary key(ma_nhan_vien));

create table casestudy_database.vi_tri(
ma_vi_tri int,
ten_vi_tri varchar(50),
primary key(ma_vi_tri),
foreign key(ma_vi_tri) references nhan_vien(ma_vi_tri));

create table casestudy_database.trinh_do(
ma_trinh_do int,
ten_trinh_do varchar(50),
primary key(ma_trinh_do),
foreign key (ma_trinh_do) references nhan_vien(ma_trinh_do));

create table casestudy_database.bo_phan(
ma_bo_phan int,
ten_bo_phan varchar(45),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan));

-- create table casestudy_database.khach_hang(
-- );