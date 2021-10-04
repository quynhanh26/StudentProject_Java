-- create database
use master 
go
drop database if exists Baithi
create database Baithi

use Baithi
go
-- create table Student
create table Student
(
stuId int primary key ,
fullName nvarchar(50),
gender bit,
birthday date,
email char(100)
);
 
--select student
create proc selectStudent
as
begin
select * from Student
end
go

--insert student
create proc insertStudent
@stuId int,@fullName nvarchar(50),@gender bit,@birthday date,@email char(100)
as
begin
insert into Student(stuId, fullName, gender, birthday, email) values(@stuId, @fullName, @gender, @birthday, @email)
end
go

insertStudent 1, 'anhcute', false, '2001-06-26', 'anhcute@gmail.com'
go 
insertStudent 2, 'hyhy', true, '2001-12-16', 'hyhy@gmail.com'
go

-- delete student
create proc deleteStudent
@stuId int
as
begin
delete from Student where stuId= @stuId;
end
go

--update student
create proc updateStudent
@stuId int,@fullName nvarchar(50),@gender bit,@birthday date,@email char(100)
as
begin
update Student set fullName=@fullName,gender = @gender,birthday=@birthday, email = @email where stuId = @stuId
end
go

--search by id
create proc findStudentById
@stuId int
as
begin
select * from Student where stuId =@stuId 
end
go

--search by name
create proc findStudentByName
@fullName nvarchar(50)
as
begin
select * from Student where  fullName LIKE '%' + @fullName + '%'
end
go

--age calculation
 create proc selectAgeById
 @stuId int
 as
 begin
  select fullName, YEAR(getdate()) - YEAR(birthday) as age from Student where stuId=@stuId;
 end
 go

 --
 create proc selectMonth
 as
 begin
 select count(stuId) as countStudent, MONTH(birthday) as month from Student group by MONTH(birthday) 
 end
 go