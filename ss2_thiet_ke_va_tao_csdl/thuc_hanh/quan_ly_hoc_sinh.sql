create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

create table quan_ly_sinh_vien.class(
class_id int auto_increment not null,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit,
primary key(class_id));

create table quan_ly_sinh_vien.student(
student_id int auto_increment not null,
student_name varchar(30) not null,
address varchar(30),
phone varchar(20),
status bit,
class_id int not null,
primary key(student_id));

create table quan_ly_sinh_vien.`subject`(
sub int not null auto_increment primary key,
sub_name varchar(30) not null,
credit tinyint not null default 1 check ( credit >= 1 ),
status bit default 1);
create table quan_ly_sinh_vien.mark(
mark_id int auto_increment not null,
sub_id int not null unique,
student_id int not null unique,
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1,
primary key (mark_id));


