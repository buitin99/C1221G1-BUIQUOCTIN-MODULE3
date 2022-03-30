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
sub_id int not null,
student_id int not null,
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1,
primary key (mark_id));

insert into quan_ly_sinh_vien.class
values (1,"A1","2018-12-20",1),(2,"A2","2018-12-22",1),(3,"B3",current_date(),0);

insert into student (student_name,address,phone,`status`,class_id)
values ("Thong","HaNoi", "0123456789",1,1),("Da","HaNoi", "0123456789",1,1),("Giang","HaNoi", "0123456789",0,2);

insert into quan_ly_sinh_vien.`subject`
values (1,"CF",5,1),(2,"C",6,1),(3,"HDJ",5,1),(4,"RDMS",10,1);

insert into mark(sub_id,student_id,mark,exam_times)
values (1,1,8,1),(1,2,10,2),(2,1,12,1);

select*from quan_ly_sinh_vien.student;

select*from quan_ly_sinh_vien.student where `status` = true;

select*from quan_ly_sinh_vien.`subject` where credit < 10;

select quan_ly_sinh_vien.s.student_id, quan_ly_sinh_vien.s.student_name, quan_ly_sinh_vien.c.class_name from quan_ly_sinh_vien.student s join class c on s.class_id = c.class_id;

select s.student_id,s.student_name,c.class_name from student s join class c on s.class_id = c.class_id where c.class_name = "A1";

select s.student_id,s.student_name,sub.sub_name,m.mark from student s join mark m on s.student_id = m.sub_id = sub.sub;

select s.student_id,s.student_name,sub.sub_name,m.mark from student s join mark m on m.student_id join `subject` sub on m.sub_id = sub.sub where sub.sub_name = "CF";