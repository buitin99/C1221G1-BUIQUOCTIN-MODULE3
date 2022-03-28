create database `student-management`;
create table  `student-management`.`class`(
`id` int not null,
`name` varchar(45) null,
primary key (id));

create table `student-management`.`teacher`(
`id` int not null,
`name` varchar(45) null,
`age` int null,
`country` varchar(45) null,
primary key (id));
