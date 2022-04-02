create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class
(
    class_id   int         not null auto_increment primary key,
    class_name varchar(60) not null,
    start_date datetime    not null,
    `status`    bit
);
create table student
(
    student_id   int         not null auto_increment primary key,
    student_name varchar(30) not null,
    address     varchar(50),
    phone       varchar(20),
    `status`      bit,
    class_id     int         not null,
    foreign key (class_id) references class (class_id)
);
create table `subject`
(
    sub_id   int         not null auto_increment primary key,
    sub_name varchar(30) not null,
    credit  tinyint     not null default 1 check ( Credit >= 1 ),
    status  bit                  default 1
);

create table mark
(
    mark_id    int not null auto_increment primary key,
    sub_id     int not null,
    student_id int not null,
    mark      float   default 0 check ( Mark between 0 and 100),
    exam_times tinyint default 1,
    unique (sub_id, student_id),
    foreign key (sub_id) references Subject (sub_id),
    foreign key (student_id) references student (student_id)
);

insert into class
values (1, 'A1', '2008-12-20', 1);
insert into class
values (2, 'A2', '2008-12-22', 1);
insert into class
values (3, 'B3', current_date, 0);

insert into student (student_name, address, phone, `status`, class_id)
values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student (student_name, address, `status`, class_id)
values ('Hoa', 'Hai phong', 1, 1);
insert into student (student_name, address, phone, `status`, class_id)
values ('Manh', 'HCM', '0123123123', 0, 2);

insert into `subject`
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

insert into mark (sub_id, student_id, mark, exam_times)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.       
select `subject`.sub_name,`subject`.credit from `subject` where credit = (select max(credit) from `subject`);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select*from `subject` inner join mark on `subject`.sub_id = mark.sub_id group by `subject`.sub_id having max(mark) >= all (select max(mark) from mark group by mark.sub_id);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.student_name, avg(mark.mark) as avg_mark from student inner join mark on student.student_id = mark.student_id group by student.student_id order by mark desc;

