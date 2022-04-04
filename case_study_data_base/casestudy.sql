drop database if exists casestudy_database;
create database casestudy_database;
use casestudy_database;


create table casestudy_database.vi_tri(
ma_vi_tri int,
ten_vi_tri varchar(50),
primary key(ma_vi_tri));

create table casestudy_database.trinh_do(
ma_trinh_do int,
ten_trinh_do varchar(50),
primary key(ma_trinh_do));

create table casestudy_database.bo_phan(
ma_bo_phan int,
ten_bo_phan varchar(45),
primary key(ma_bo_phan));

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
primary key(ma_nhan_vien),
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan));

create table casestudy_database.loai_khach(
ma_loai_khach int auto_increment,
ten_loai_khach varchar(50),
primary key(ma_loai_khach));

create table casestudy_database.khach_hang(
ma_khach_hang int auto_increment,
ma_loai_khach int not null,
ho_va_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit not null,
so_cmnd varchar(45) not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
primary key(ma_khach_hang),
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table casestudy_database.kieu_thue(
ma_kieu_thue int auto_increment,
ten_kieu_thue varchar(45),
primary key(ma_kieu_thue));

create table casestudy_database.loai_dich_vu(
ma_loai_dich_vu int auto_increment,
ten_loai_dich_vu varchar(45),
primary key(ma_loai_dich_vu));

create table casestudy_database.dich_vu(
ma_dich_vu int auto_increment,
ten_dich_vu varchar(45) not null,
dien_tich int,
chi_phi_thue double not null,
so_nguoi_toi_da int,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
primary key(ma_dich_vu),
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu));

create table casestudy_database.hop_dong(
ma_hop_dong int auto_increment,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc_hop_dong datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int not null,
ma_khach_hang int not null,
ma_dich_vu int not null,
primary key(ma_hop_dong),
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu));

create table casestudy_database.dich_vu_di_kem(
ma_dich_vu_di_kem int,
ten_dich_vu_di_kem varchar(45) not null,
gia double not null,
don_vi varchar(10) not null,
trang_thai varchar(45),
primary key(ma_dich_vu_di_kem));

create table casestudy_database.hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
so_luong int not null,
primary key(ma_hop_dong_chi_tiet),
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem));

insert into casestudy_database.vi_tri (ma_vi_tri,ten_vi_tri) 
values (1,"Quản Lý"),
	   (2,"Nhân Viên");

INSERT INTO `casestudy_database`.`trinh_do` (`ma_trinh_do`, `ten_trinh_do`) 
VALUES ('1', 'Trung Cấp'),
('2', 'Cao Đẳng'),
('3', 'Đại Học'),
('4', 'Sau Đại Học');

INSERT INTO `casestudy_database`.`bo_phan` (`ma_bo_phan`, `ten_bo_phan`) 
VALUES  ('1', 'Sale-Marketing'),
		('2', 'Hành chính'),
		('3', 'Phục vụ'),
		('4', 'Quản lý');
        
INSERT INTO `casestudy_database`.`nhan_vien` (`ma_nhan_vien`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `ma_vi_tri`, `ma_trinh_do`, `ma_bo_phan`) 
VALUES  ('1', 'Nguyễn Văn An', '1970-11-07', '456231786', '10000000', '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', '1', '3', '1'),
		('2', 'Lê Văn Bình', '1997-04-09', '654231234', '7000000', '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', '1', '2', '2'),
		('3', 'Hồ Thị Yến', '1995-12-12', '999231723', '14000000', '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', '1', '3', '2'),
		('4', 'Võ Công Toản', '1980-04-04', '123231365', '17000000', '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', '1', '4', '4'),
		('5', 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', '6000000', '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', '2', '1', '1'),
		('6', 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', '7000000', '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', '2', '2', '3'),
		('7', 'Nguyễn Hữu Hà', '1993-01-01', '534323231', '8000000', '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', '2', '3', '2'),
		('8', 'Nguyễn Hà Đông', '1989-09-03', '234414123', '9000000', '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', '2', '4', '4'),
		('9', 'Tòng Hoang', '1982-09-03', '256781231', '6000000', '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', '2', '4', '4'),
		('10', 'Nguyễn Công Đạo', '1994-01-08', '755434343', '8000000', '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', '2', '3','2');

        
insert INTO `casestudy_database`.`loai_khach` (`ma_loai_khach`, `ten_loai_khach`) 
VALUES  ('1', 'Diamond'),
		('2', 'Platinium'),
		('3', 'Gold'),
		('4', 'Silver'),
		('5', 'Member');
        
INSERT INTO `casestudy_database`.`khach_hang` (`ma_khach_hang`, `ma_loai_khach`, `ho_va_ten`, `ngay_sinh`, `gioi_tinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) 
VALUES  ('1', '5', 'Nguyễn Thị Hào', '1970-11-07', b'0', '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
		('2', '3', 'Phạm Xuân Diệu', '1992-08-08', b'1', '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
		('3', '1', 'Trương Đình Nghệ', '1990-02-27', b'1', '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
		('4', '1', 'Dương Văn Quan', '1981-07-08', b'1', '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
		('5', '4', 'Hoàng Trần Nhi Nhi', '1995-12-09', b'0', '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
		('6', '4', 'Tôn Nữ Mộc Châu', '2005-12-06', b'0', '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
		('7', '1', 'Nguyễn Mỹ Kim', '1984-04-08', b'0', '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
		('8', '3', 'Nguyễn Thị Hào', '1999-04-08', b'0', '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
		('9', '1', 'Trần Đại Danh', '1994-07-01', b'1', '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
		('10', '2', 'Nguyễn Tâm Đắc', '1989-07-01', b'1', '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');
        
INSERT INTO `casestudy_database`.`kieu_thue` (`ma_kieu_thue`, `ten_kieu_thue`) 
VALUES  ('1', 'year'),
		('2', 'month'),
		('3', 'day'),
		('4', 'hour');


INSERT INTO `casestudy_database`.`loai_dich_vu` (`ma_loai_dich_vu`, `ten_loai_dich_vu`) 
VALUES  ('1', 'Villa'),
		('2', 'House'),
		('3', 'Room');

INSERT INTO `casestudy_database`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES ('1', 'Villa Beach Front', '25000', '10000000', '10', '3', '1', 'vip', 'Có hồ bơi', '500', '4');
INSERT INTO `casestudy_database`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `so_tang`) VALUES ('2', 'House Princess 01', '14000', '5000000', '7', '2', '2', 'vip', 'Có thêm bếp nướng', '3');
INSERT INTO `casestudy_database`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`) VALUES ('3', 'Room Twin 01', '5000', '1000000', '2', '4', '3', 'normal', 'Có tivi');
INSERT INTO `casestudy_database`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `dien_tich_ho_boi`, `so_tang`) VALUES ('4', 'Villa No Beach Front', '22000', '9000000', '8', '3', '1', 'normal', 'Có hồ bơi', '300', '3');
INSERT INTO `casestudy_database`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`, `so_tang`) VALUES ('5', 'House Princess 02', '10000', '4000000', '5', '3', '2', 'normal', 'Có thêm bếp nướng', '2');
INSERT INTO `casestudy_database`.`dich_vu` (`ma_dich_vu`, `ten_dich_vu`, `dien_tich`, `chi_phi_thue`, `so_nguoi_toi_da`, `ma_kieu_thue`, `ma_loai_dich_vu`, `tieu_chuan_phong`, `mo_ta_tien_nghi_khac`) VALUES ('6', 'Room Twin 02', '3000', '900000', '2', '4', '3', 'normal', 'Có tivi');


INSERT INTO `casestudy_database`.`dich_vu_di_kem` (`ma_dich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai`) 
VALUES  ('1', 'Karaoke', '10000', 'giờ', 'tiện nghi, hiện tại'),
		('2', 'Thuê xe máy', '10000', 'chiếc', 'hỏng 1 xe'),
		('3', 'Thuê xe đạp', '20000', 'chiếc', 'tốt'),
		('4', 'Buffet buổi sáng', '15000', 'suất', 'đầy đủ đồ ăn, tráng miệng'),
		('5', 'Buffet buổi trưa', '90000', 'suất', 'đầy đủ đồ ăn, tráng miệng'),
		('6', 'Buffet buổi tối', '16000', 'suất', 'đầy đủ đồ ăn, tráng miệng');

INSERT INTO `casestudy_database`.`hop_dong` (`ma_hop_dong`, `ngay_lam_hop_dong`, `ngay_ket_thuc_hop_dong`, `tien_dat_coc`, `ma_nhan_vien`, `ma_khach_hang`, `ma_dich_vu`) 
VALUES  ('1', '2020-12-08', '2020-12-08', '0', '3', '1', '3'),
		('2', '2020-07-14', '2020-07-21', '200000', '7', '3', '1'),
		('3', '2021-03-15', '2021-03-17', '50000', '3', '4','2'),
		('4', '2021-01-14', '2021-01-18', '100000', '7', '5', '5'),
		('5', '2021-07-14', '2021-07-15', '0', '7', '2', '6'),
		('6', '2021-06-01', '2021-06-03', '0', '7', '7', '6'),
		('7', '2021-09-02', '2021-09-05', '100000', '7', '4', '4'),
		('8', '2021-06-17', '2021-06-18', '150000', '3', '4', '1'),
		('9', '2020-11-19', '2020-11-19', '0', '3', '4', '3'),
		('10', '2021-04-12', '2021-04-14', '0', '10', '3', '5'),
		('11', '2021-04-25', '2021-04-25', '0', '2', '2', '1'),
		('12', '2021-05-25', '2021-05-27', '0', '7', '10', '1');

INSERT INTO `casestudy_database`.`hop_dong_chi_tiet` (`ma_hop_dong_chi_tiet`, `ma_hop_dong`, `ma_dich_vu_di_kem`, `so_luong`) 
VALUES  ('1', '2', '4', '5'),
		('2', '2', '5', '8'),
		('3', '2', '6', '15'),
		('4', '3', '1', '1'),
		('5', '3', '2', '11'),
		('6', '1', '3', '1'),
		('7', '1', '2', '2'),
		('8', '12', '2', '2');


-- 2 Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT ho_ten FROM nhan_vien WHERE nhan_vien.ho_ten REGEXP '^[HKT]' AND LENGTH(ho_ten) <= 16;

-- 3 Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select*from khach_hang where (datediff(curdate() , khach_hang.ngay_sinh)/365 <50 
and datediff(curdate() , khach_hang.ngay_sinh)/365 > 18) 
and (khach_hang.dia_chi like "%Đà Nẵng%" or khach_hang.dia_chi like "%Quảng Trị%");

-- 4 Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select khach_hang.ho_va_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong from loai_khach join khach_hang 
on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
where loai_khach.ten_loai_khach = 'Diamond' group by khach_hang.ho_va_ten having so_lan_dat_phong > 0 order by so_lan_dat_phong;

-- 5. Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select khach_hang.ma_khach_hang, khach_hang.ho_va_ten, loai_khach.ten_loai_khach, hop_dong.ma_hop_dong,
hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc_hop_dong, dich_vu.ten_dich_vu, 
sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) as tong_tien 
from loai_khach  join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach join hop_dong 
on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong left join dich_vu_di_kem 
on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem group by khach_hang.ma_khach_hang 
order by khach_hang.ma_khach_hang;

-- 6 Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

select distinct dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu from loai_dich_vu 
right join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_dich_vu 
right join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu 
where dich_vu.ma_dich_vu 
not in (select hop_dong.ma_dich_vu from hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01' and '2021-03-31');

-- 7 Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các 
-- loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021. 

select distinct dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from loai_dich_vu join dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu join hop_dong 
on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu join khach_hang 
on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang 
where (dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where year(hop_dong.ngay_lam_hop_dong)=2020) ) 
and ( dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where year(hop_dong.ngay_lam_hop_dong)=2021));

-- 8 Hiển thị thông tin ho_ten khách hàng 
-- có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
select khach_hang.ho_va_ten from khach_hang union 
select khach_hang.ho_va_ten from khach_hang;

select distinct ho_va_ten from khach_hang;

select ho_va_ten from khach_hang  group by khach_hang.ho_va_ten;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(hop_dong.ngay_lam_hop_dong), count(khach_hang.ma_khach_hang) from hop_dong join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang 
where year(hop_dong.ngay_lam_hop_dong) = 2021 group by month(hop_dong.ngay_lam_hop_dong) order by month(hop_dong.ngay_lam_hop_dong);

-- 10.Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, 
-- ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc_hop_dong, hop_dong.tien_dat_coc,
 sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong group by hop_dong.ma_hop_dong order by hop_dong.ma_hop_dong;   

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở 
-- “Vinh” hoặc “Quảng Ngãi”.

select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem 
from dich_vu_di_kem join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem 
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong  join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang  
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
where loai_khach.ten_loai_khach like 'Diamond' and (khach_hang.dia_chi like '%Vinh%' or '%Quảng Ngãi%') 
group by dich_vu_di_kem.ma_dich_vu_di_kem order by dich_vu_di_kem.ma_dich_vu_di_kem;  

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được 
-- khách hàng đặt vào 6 tháng đầu năm 2021.

select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_va_ten, khach_hang.so_dien_thoai, dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, 
sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem, hop_dong.tien_dat_coc from hop_dong left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where (hop_dong.ngay_lam_hop_dong between '2020-10-01' and  '2020-12-31') and  (hop_dong.ngay_lam_hop_dong not between '2021-01-01' and '2021-06-31') group by hop_dong.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng 
-- nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong)  as so_luong_dich_vu_di_kem
from dich_vu_di_kem join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem 
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
group by ten_dich_vu_di_kem having so_luong_dich_vu_di_kem order by so_luong_dich_vu_di_kem desc limit 2;

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
--  Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, 
-- so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung 
from dich_vu_di_kem join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong  join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
group by dich_vu_di_kem.ma_dich_vu_di_kem having so_lan_su_dung = 1 order by hop_dong.ma_hop_dong;

-- 15.Hiển thi thông tin của tất cả nhân viên bao 
-- gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021..

select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi, 
count(hop_dong.ma_hop_dong) as hop_dong_ky 
from vi_tri  join nhan_vien on vi_tri.ma_vi_tri = nhan_vien.ma_vi_tri 
join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do 
join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan 
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien where hop_dong.ngay_lam_hop_dong between '2020-01-01' and '2021-12-31'
group by nhan_vien.ma_nhan_vien having hop_dong_ky <= 3;

-- 16 Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

set sql_safe_updates =0;									
delete nhan_vien from nhan_vien
left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where hop_dong.ma_nhan_vien not in 
(select distinct nhan_vien.ma_nhan_vien where year(hop_dong.ngay_lam_hop_dong) between '2019' and '2021');
set sql_safe_updates =1;

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.

create or replace view khach_hang_view as
select khach_hang.ma_khach_hang
from loai_khach join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem where loai_khach.ma_loai_khach = 2 
and (hop_dong.ngay_lam_hop_dong > '2021-01-01' and hop_dong.ngay_lam_hop_dong < '2021-12-31')
group by khach_hang.ho_va_ten having sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) > 10000000 ;
 
set sql_safe_updates = 0;	
update khach_hang, (select ma_khach_hang from khach_hang_view ) as view_khach_hang
set khach_hang.ma_loai_khach = '1' where khach_hang.ma_khach_hang = view_khach_hang.ma_khach_hang;  
set sql_safe_updates = 1;
	
-- 18 Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

select khach_hang.ma_khach_hang, khach_hang.ho_va_ten from hop_dong 
join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
 where hop_dong.ngay_ket_thuc_hop_dong < '2021-01-01';

set sql_safe_updates =0;
set foreign_key_checks =0;
delete khach_hang  from hop_dong join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
 where hop_dong.ngay_ket_thuc_hop_dong < '2021-01-01';						
set sql_safe_updates =1;
set foreign_key_checks =1;

-- 19 Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
drop view dich_vu_view;

create view dich_vu_view as
select dich_vu_di_kem.ma_dich_vu_di_kem,hop_dong_chi_tiet.so_luong, dich_vu_di_kem.ten_dich_vu_di_kem
from dich_vu_di_kem join hop_dong_chi_tiet 
on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem 
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where hop_dong_chi_tiet.so_luong > 10 and (hop_dong.ngay_lam_hop_dong > '2020-01-01' and hop_dong.ngay_lam_hop_dong < '2020-12-31');


set sql_safe_updates = 0;	
update dich_vu_di_kem, (select ma_dich_vu_di_kem from dich_vu_view) as view_select
set gia = gia*2 where dich_vu_di_kem.ma_dich_vu_di_kem = view_select.ma_dich_vu_di_kem;  
set sql_safe_updates = 1;

-- 20 Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.email, nhan_vien.so_dien_thoai, nhan_vien.dia_chi from nhan_vien union all
select khach_hang.ma_khach_hang, khach_hang.ho_va_ten, khach_hang.email, khach_hang.so_dien_thoai, khach_hang.dia_chi from khach_hang;

