select*from attendance;
select*from logininformation;

select*from students;

select*from subjects;
desc students
delete from subjects;
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(1,'CPP-I','1st','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(2,'ITC','1st','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(3,'Islamiat','1st','CS','theory','35','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(4,'Pakistan Studies','1st','CS','theory','35','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(5,'EPC','1st','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(6,'Calculus','1st','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(7,'CPP-II','2nd','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(8,'CAED','2nd','CS','theory','35','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(9,'BEE','2nd','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(10,'LADE','2nd','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(11,'AP','2nd','CS','theory','45','3');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(12,'COMM Skills','2nd','CS','theory','45','3');
/*=============practical==============*/
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(13,'ITC','1st','CS','practical','25','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(14,'CPP-I','1st','CS','practical','25','2');

insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(15,'BEE','2nd','CS','practical','25','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(16,'CPP-II','2nd','CS','practical','25','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(17,'AP','2nd','CS','practical','25','2');
insert into subjects(id,subjectname,semester,department,theoryOrPractical,TOTALLECTURES,CREDITHOURS) values(18,'CAED','2nd','CS','practical','25','2');
delete from subjects where semester='2nd';

drop table subjects;
create table subjects (id int primary key,subjectname varchar2(200),semester varchar2(100),department varchar2(200),
theoryOrPractical varchar2(200),totalLectures varchar2(100),creditHours varchar2(200));


update attendance set batch = '13' where theoryOrPractical='practical';


alter table attendance drop column totalLectures;

/*==========================Library books=========================*/
create table libraryBooks(id int primary key,bookName varchar2(150),author varchar2(150),state varchar2(150));

insert into libraryBooks(id,bookName,author,state) values(1,'introduction to computers','william stalling','got');
insert into libraryBooks(id,bookName,author,state) values(2,'Computer Programming','Johin Nickon','got');
insert into libraryBooks(id,bookName,author,state) values(3,'Basic Electronics','Fayol hoffin','avail');
insert into libraryBooks(id,bookName,author,state) values(4,'Applied Physics','Michael Johnson','avail');
insert into libraryBooks(id,bookName,author,state) values(5,'Java how to program','Dietel','avail');

drop table libraryBooks;

/*====================================Books Issue Details=============*/
create table booksIssueDetails(id int primary key,name varchar2(256),bookName varchar2(150),rollNum varchar2(150),department varchar2(150),issueDate varchar2(150),returnDate varchar2(150),state varchar2(100));

insert into booksIssueDetails(id,bookName,rollNum,department,issueDate,returnDate,state,name) values(1,'introduction to computers','13_CS_19','computer system','11/10/2016','13/10/2016','got','Imtiaz Ali');
insert into booksIssueDetails(id,bookName,rollNum,department,issueDate,returnDate,state,name) values(2,'computer programming','13_CS_19','computer system','14/10/2016','16/10/2016','got','Imtiaz Ali');
insert into booksIssueDetails(id,bookName,rollNum,department,issueDate,returnDate,state,name) values(3,'Applied Physics','13_CS_30','computer system','11/10/2016','13/10/2016','got','Abdul Qayoom');
insert into booksIssueDetails(id,bookName,rollNum,department,issueDate,returnDate,state,name) values(4,'Basic Electronics','13_CS_30','computer system','15/10/2016','17/10/2016','got','Abdul Qayoom');

select*from  booksIssueDetails;
select*from librarybooks;

update libraryBooks set state='avail' where id = 5; 

delete  from booksIssueDetails where id = 5;

drop table booksIssueDetails;

select *from departAndBatches;

select*from logininformation;
/*===================================STUDENT SEMESTER RESULT */

create table studentsemesterResult(id int primary key,semester varchar2(150),rollNum varchar2(150),depart varchar2(150),
subject varchar2(150),result varchar2(150),batch varchar2(150),theoryOrPractical varchar2(150),semesterState varchar2(150));

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (1,'1st','13_CS_19','computer system','ITC','80','13','theory','no');

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (2,'1st','13_CS_19','computer system','CPP-I','90','13','theory','no');

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (3,'1st','13_CS_19','computer system','Calculus','75','13','theory','no');

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (4,'1st','13_CS_19','computer system','EPC','80','13','theory','no');

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (5,'1st','13_CS_19','computer system','Pakistan Studies','45','13','theory','no');

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (6,'1st','13_CS_19','computer system','Islamiat','47','13','theory','no');
 /*==========================================PRACTICAL RESULT ==================================*/
insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (7,'1st','13_CS_19','computer system','ITC','47','13','practical','no');

insert into studentsemesterResult(id,semester,rollNum,depart,subject,result,batch,theoryOrPractical,semesterState)
values (8,'1st','13_CS_19','computer system','CPP-I','47','13','practical','no');
 select*from studentSemesterResult;

/*=======================COMPLAIN TABLE===========================*/
create table complain(id int primary key,name varchar2(256),rollNumber varchar2(256),complain varchar2(256));
select*from complain;


/*==============================================LIBRARIAN INFO==================*/
create table librarianInfo(id int primary key,username varchar2(256),email varchar2(256),
password varchar2(256));

insert into librarianInfo(id,username,email,password) values(1,'librarian','abc@gmail.com','12345');
select*from librarianInfo;

/*============================================TEACHER DATA====================*/

create table teacher(id int primary key,name varchar2(256),email varchar2(256),department varchar2(256)
,username varchar2(256),password varchar2(256));
drop table teacher;
insert into teacher(id,name,email,department,username,password) values(1,'Shamim Ur Rehman','shamim@gmail.com',
'Computer system','shamim123','12345');
/*===============================================TEACHER SUBJECTS===================*/
create table teacherSubjects(id int primary key,teacherName varchar2(256),department varchar2(256)
,semester varchar2(256),subject varchar2(256),batch varchar2(256));

insert into teacherSubjects (id,teacherName,department,semester,subject,batch) values (1,'Shamim ur Rehman','computer system','1st','ITC','13');

select*from teacherSubjects;
select*from departAndBatches;

create table news(id int primary key,news varchar2(500),datestamp varchar2(50) );
create table message(id int primary key,rollNumber varchar2(40),message varchar2(500),datestamp varchar2(50));
