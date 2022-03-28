create database ss1_quan_ly_sinh_vien;
use ss1_quan_ly_sinh_vien;

create table ss1_quan_ly_sinh_vien.class (
code_class int auto_increment,
name_class varchar(50),
primary key(code_class)
);

create table ss1_quan_ly_sinh_vien.teacher (
code_teacher int auto_increment,
name_teacher varchar(50),
age_teacher int,
country varchar(50),
primary key(code_teacher)
);

create table ss1_quan_ly_sinh_vien.student (
code_student int auto_increment,
name_student varchar(50),
age_student int,
country varchar(50),
primary key(code_student)
);

insert into ss1_quan_ly_sinh_vien.class(name_class) values ("C1221G1"),("C0222G1"),("C0322G1");

insert into ss1_quan_ly_sinh_vien.teacher(name_teacher,age_teacher,country) values ("Channh",28,"VietNam"),("Chien",22,"VietNam"),("Trung",25,"VietNam");

insert into ss1_quan_ly_sinh_vien.student(name_student,age_student,country) values ("Trinh",28,"VietNam"),("Giang",22,"VietNam"),("Tin",18,"VietNam"),("Da",18,"VietNam"),("Thong",18,"VietNam");

select code_student,name_student from ss1_quan_ly_sinh_vien.student;

delete from ss1_quan_ly_sinh_vien.student where code_student in (2,3);
