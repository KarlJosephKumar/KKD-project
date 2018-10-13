show databases;

use hibernate_project;

create table schedule(ID int auto_increment not null primary key, monday varchar(45), tuesday varchar(45),
 wednesday varchar(45), thursday varchar(45), friday varchar(45), saturday varchar(45), sunday varchar(45));

create table student (id int primary key auto_increment
,name varchar(40) not null
,surname varchar(40) not null
,date_of_birth Date not null
,nationality varchar(32) not null);

create table course (id int primary key auto_increment
,name varchar(40) not null
,topic varchar(64) not null
,level varchar(32) not null );

create table payments(id int primary key auto_increment
,student_id int
,course_id int
,invoice_value float not null
,foreign key (student_id) references student(id)
,foreign key (course_id) references course(id));

create table address (id int primary key auto_increment, city varchar(40) not null, street varchar(50) not null, number int not null);



create table room (id int primary key auto_increment, address_id int not null, max_size int not null, foreign key(address_id) references address(id));

select * from group;

create table class
(
  id          int auto_increment
    primary key,
  schedule_id int                                not null,
  room_id     int                                not null,
  date_start  datetime default CURRENT_TIMESTAMP null,
  date_finish datetime                           null,
  course_id   int                                not null,
  constraint class_course_id_fk
  foreign key (course_id) references course (id),
  constraint class_room_id_fk
  foreign key (room_id) references room (id),
  constraint class_schedule_ID_fk
  foreign key (schedule_id) references schedule (id)
);


create table student_class(id int auto_increment primary key
, student_id int not null
, class_id int not null
, foreign key (student_id) references student(id)
, foreign key (class_id) references class(id));