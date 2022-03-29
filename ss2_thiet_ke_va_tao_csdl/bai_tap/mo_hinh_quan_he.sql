create database mo_hinh_quan_he;
use mo_hinh_quan_he;

create table mo_hinh_quan_he.phieu_xuat(
so_px int auto_increment,
ngay_xuat datetime,
primary key(so_px));

create table mo_hinh_quan_he.vat_tu(
ma_vtu int auto_increment,
ten_vtu varchar(50),
primary key(ma_vtu));

create table mo_hinh_quan_he.phieu_xuat_chi_tiet_phieu_xuat_vat_tu(
so_px int,
ma_vtu int,
dg_xuat varchar(50),
sl_xuat varchar(50),
primary key(so_px,ma_vtu),
foreign key(so_px) references phieu_xuat(so_px),
foreign key(ma_vtu) references vat_tu(ma_vtu)
);

create table mo_hinh_quan_he.phieu_nhap(
so_pn int auto_increment,
ngay_dang_nhap datetime,
primary key(so_pn));

create table mo_hinh_quan_he.vat_tu_chi_tiet_phieu_nhap_phieu_nhap(
ma_vtu int,
so_pn int,
dg_nhap varchar(50),
sl_nhap varchar(50),
primary key(ma_vtu,so_pn),
foreign key(ma_vtu) references vat_tu(ma_vtu),
foreign key(so_pn) references phieu_nhap(so_pn));

create table mo_hinh_quan_he.don_dh(
so_dh int auto_increment,
ngay_dh varchar(50),
ma_ncc int,
primary key(so_dh)
);

create table mo_hinh_quan_he.vat_tu_chi_tiet_cung_cap_don_dh(
ma_vtu int,
so_dh int,
primary key(ma_vtu, so_dh),
foreign key(ma_vtu) references vat_tu(ma_vtu),
foreign key(so_dh) references don_dh(so_dh));

create table mo_hinh_quan_he.nha_cc(
ma_ncc int auto_increment,
ten_ncc varchar(50),
dia_chi varchar(50),
sdt varchar(10),
primary key(ma_ncc));

create table mo_hinh_quan_he.sdt(
ma_ncc int,
foreign key(ma_ncc) references nha_cc(ma_ncc));


