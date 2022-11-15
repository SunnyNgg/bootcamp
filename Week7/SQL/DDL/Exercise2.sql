-- create new database
CREATE DATABASE ORG;
-- show all database;
SHOW DATABASES;
-- get into database
USE ORG;

-- create table worker
CREATE TABLE WORKER (
	WORKER_ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY NUMERIC(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

select * from Worker;
-- inesrt data to worker
INSERT INTO WORKER 
	(FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		('Monika', 'Arora', 100000, '21-02-20 09:00:00', 'HR'),
		('Niharika', 'Verma', 80000, '21-06-11 09:00:00', 'Admin'),
		('Vishal', 'Singhal', 300000, '21-02-20 09:00:00', 'HR'),
		('Amitabh', 'Singh', 500000, '21-02-20 09:00:00', 'Admin'),
		('Vivek', 'Bhati', 490000, '21-06-11 09:00:00', 'Admin'),
		('Vipul', 'Diwan', 200000, '21-06-11 09:00:00', 'Account'),
		('Satish', 'Kumar', 75000, '21-01-20 09:00:00', 'Account'),
		('Geetika', 'Chauhan', 90000, '21-04-11 09:00:00', 'Admin');
        
insert into Worker (FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT)
values ('Sunny', 'Ng', 300000,  '21-02-20 09:00:00', 'Admin');

select * from worker;

-- create table bonus
CREATE TABLE BONUS (
	WORKER_REF_ID INTEGER,
	BONUS_AMOUNT NUMERIC(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
);

select * from Bonus;

-- Task 1:
-- Vivek, with amount 32000 and bonus date 2021 Nov 02
Insert Into Bonus Values ( 3, 32000, '21-11-02 09:00:00');
-- Vivek, with amount 20000 and bonus date 2022 Nov 02
Insert Into Bonus Values ( 3, 20000, '22-11-02 09:00:00');
-- Amitabh, with amount 21000 and bonus date 2021 Nov 02
Insert Into Bonus Values ( 4, 21000, '21-11-02 09:00:00');
-- Geetika, with amount 30000 and bonus date 2021 Nov 02
Insert Into Bonus Values ( 8, 30000, '21-11-02 09:00:00');
-- Satish, with amount 4500 and bonus date 2022 Nov 02
Insert Into Bonus Values ( 7, 4500, '22-11-02 09:00:00');

-- Task 2:
-- Write an SQL query to show the second highest salary among all workers.
Select Max(SALARY) as Second_Highest_Sarlary_Worker
from Worker As W
Where Salary not in ( Select Max(Salary) from Worker);



-- Task 3:
-- Write an SQL query to print the name of employees having the highest salary in each department.
Select CONCAT( W.First_Name," ", W.Last_NAME) as Name, W.Department, W.Salary
from Worker As W
WHERE Salary  IN ( 
	SELECT MAX(SALARY)
	FROM WORKER
		Group by DEPARTMENT);
        
select *
from worker w1
where salary = (
          select MAX(Salary)
          from worker w2
          where w1.department = w2.department
);
        





-- Task 4:
-- Write an SQL query to fetch the list of employees with the same base salary.
select * 
from worker w1
where salary = ( 
         select salary
         from worker w2
         where w2.FIRST_NAME != w1.FIRST_NAME
         and w2.salary = w1.salary
);
-- Task 5:
-- Write an SQL query to find the worker names with highest salaries + bonus in 2021
select w1.First_Name, w1.Last_NAME, w1.salary, B.bonus_amount, B.BONUS_DATE
from worker w1 left join Bonus B 
on w1.WORKER_ID = B.WORKER_REF_ID
where w1.salary  = ( 
             select Max(w1.salary) 
             from worker)
ANd B.BONUS_AMOUNT = (
             select Max(B.bonus_amount)
             from Bonus 
             )
AND YEAR(B.Bonus_DATE) = '2021'
order by B.bonus_amount , w1.salary desc limit 1;



-- Task 6 (Please complete Task 1-5 first):
-- Try to delete all the records in table WORKER
Delete From worker;
-- Study the reason why the data cannot be deleted
-- Try to delete all the records in table BONUS
Delete From Bonus;
-- Try to delete all the records in table WORKER
Delete From worker;

-- Task 7 (Please complete Task 6 first):

-- Try to drop table WORKER
drop table worker;
-- Study the reason why the table cannot be deleted
-- Try to drop table BONUS
drop table Bonus;
-- Try to drop table WORKER
drop table worker;