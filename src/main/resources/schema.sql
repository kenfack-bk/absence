DROP TABLE IF EXISTS absence_histories;
DROP TABLE IF EXISTS absences;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS classrooms;
DROP TABLE IF EXISTS slots;
DROP TABLE IF EXISTS tutors;


create table tutors(
   id bigserial primary key,
   version int default 0 not null,
   name varchar(120) not null,
   email varchar(120),
   address varchar(120) not null,
   phone_number1 varchar(20) not null,
   phone_number2 varchar(20)
);

create table slots(
   id bigserial primary key,
   version int default 0 not null,
   start_time int not null,
   end_time int not null,
   duration int not null
);

create table classrooms (
   id  bigserial  primary key,
   version int default 0 not null,
   code varchar(100) not null,
   field_of_study varchar(100) not null,
   level int default 4
);

create table students(
   id bigserial primary key,
   version int default 0 not null,
   registration_number varchar(20) not null unique,
   name varchar(100) not null,
   email varchar(100),
   phone_number varchar(100) not null,
   tutor_id int8,
   classroom_id int8,
   foreign key (tutor_id) references tutors(id),
   foreign key (classroom_id) references classrooms(id)
);

create table absences(
   id bigserial primary key,
   version int default 0 not null,
   absence_date date not null,
   justify boolean default 'false',
   justification varchar(100),
   slot_id int8 not null,
   student_id int8 not null,
   classroom_id int8 not null,
   foreign key (slot_id) references slots(id),
   foreign key (student_id) references students(id),
   foreign key (classroom_id) references classrooms(id)
);

create table absence_histories(
   id bigserial primary key,
   version int default 0 not null,
   absence_date date not null,
   justify boolean default 'false',
   justification varchar(100),
   slot_id int8 not null,
   student_registration_number varchar(20) not null,
   classroom_code varchar(120) not null,
   acc_year varchar(20) not null,
   foreign key (slot_id) references slots(id)
);