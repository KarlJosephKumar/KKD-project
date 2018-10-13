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

use hibernate_project;

--FOR INSERTING STUDENTS
create procedure insert_student(
  p_name     varchar(40),
  p_surname  varchar(40),
  p_date_of_birth date,
  p_national  varchar(32)
)
  begin
    insert into student (name, surname, date_of_birth, nationality) values (p_name, p_surname, p_date_of_birth, p_national);
  end;

call insert_student('Victor', 'Vitya', '1990-10-13', 'ukrainian');
call insert_student('Alo', 'Ano', '1990-12-25', 'Estonian');
call insert_student('Andy', 'Kwame', '1993-11-13', 'Ghanaian');
call insert_student('Daniel', 'Richard', '1990-5-13', 'Nigerian');
call insert_student('Karl', 'Joseph', '1990-8-13', 'Estonian');
call insert_student('Krislin', 'aaaaa', '1990-2-13', 'Estonian');


--FOR INSERTING ADDRESSES
create procedure insert_address(
  p_city     varchar(40),
  p_street  varchar(40),
  p_number int
)
  begin
    insert into address (city, street, number) values (p_city, p_street, p_number);
  end;

call insert_address('Tallinn','Vana-Posti', 11);
call insert_address('Gdynia','Aleja Zwycięstwa', 96);
call insert_address('Riga','Somewhere-there', 419);
call insert_address('Vilnius','Somewhere-there', 38);

--------FOR INSERTING ROOMS--------------
create procedure insert_room(
  p_address_id int,
  p_max_size int
)
  begin
    insert into room (address_id, max_size) values (p_address_id, p_max_size);
  end;

call insert_room(1,18);
call insert_room(2,12);

-------for Inserting COURSE---------------
create procedure insert_course(
  p_name     varchar(40),
  p_topic  varchar(64),
  p_level varchar(32)
)
  begin
    insert into course (name, topic, `level`) values (p_name, p_topic, p_level);
  end;

call insert_course('Weekdays Junior Java', 'Java from scratch', 'Junior');
call insert_course('Weekend Junior Java', 'Java from scratch', 'Junior');
call insert_course('Weekend Manual Tester', 'Manual Tester', 'Entry Level');
call insert_course('Weekdays Intermediate Java', 'Complex Java', 'Intermediate');
call insert_course('Weekend Intermediate Java', 'Complex Java', 'Intermediate');
call insert_course('Weekend Advanced Java', 'Advanced Java', 'Senior');



--CREATE TWO PROCEDURES FOR INSERTING SCHEDULES-----

--WEEKDAYS SCHEDULE--
create procedure insert_weekday_schedule(
  p_monday     varchar(45),
  p_tuesday  varchar(45),
  p_wednesday varchar(45),
  p_thurday varchar(45),
  p_friday varchar(45)
)
  begin
    insert into schedule (monday, tuesday, wednesday, thurday, friday) values (p_monday, p_tuesday, p_wednesday, p_thurday, p_friday);
  end;

  --WEEKEND SCHEDULE---
create procedure insert_weekend_schedule(
  p_saturday    varchar(45),
  p_sunday  varchar(45)
)
  begin
    insert into schedule (saturday, sunday) values (p_saturday, p_sunday);
  end;