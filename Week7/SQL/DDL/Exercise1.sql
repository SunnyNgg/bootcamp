Create Table LOCATIONS(
  location_id numeric(4,0),
  street_address varchar(100),
  postal_code numeric (10,0),
  city varchar (30),
  state_province varchar (20),
  country_id varchar (2),
  primary key(location_id),
  foreign key (country_id) References COUNTRIES (country_id)
  );
  
  Create Table COUNTRIES(
  country_id varchar(2),
  country_name varchar (30),
  region_id numeric (1, 0),
  primary key (country_id)
  );
  
  Create Table DEPARTMENTS(
  DEPARTMENT_ID numeric(2),
  DEPARTMENT_NAME varchar (30),
  MANAGER_ID numeric(3,0) ,
  LOCATION_ID numeric (4,0),
  primary key (DEPARTMENT_ID),
  foreign key (location_id) References LOCATIONS (location_id)
  );
  
  Create Table EMPLOYEES(
  EMPLOYEE_ID numeric (3, 0),
  FIRST_NAME varchar (20),
  LAST_NAME varchar (20),
  EMAIL varchar (50), 
  PHONE_NUMBER varchar (11),
  HIRE_DATE Date,
  JOB_ID varchar(20),
  SALARY numeric, 
  COMMISSION_PCT numeric (10, 2),
  MANAGER_ID numeric (3,0),
  DEPARTMENT_ID numeric (2,0),
  primary key (EMPLOYEE_ID), 
  foreign key (DEPARTMENT_ID) References DEPARTMENTS (DEPARTMENT_ID)
  );
  
  
  
  
  Create Table JOB_HISTORY(
  employee_id numeric (3, 0),
  start_date Date,
  end_date Date, 
  job_id varchar (20),
  department_id numeric (2),
  primary key (start_date, end_date),
  foreign key (employee_id) References EMPLOYEES (EMPLOYEE_ID)
  );
  
-- location insert data 
select * from locations;
   Insert into LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id)
  Values (1000 , '1297 Via Cola di Rie', 989, 'Roma', '', 'IT');
   Insert into LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id)
  Values (1100 , '93091 Calle della Te', 10934, 'Venice', '', 'IT');
    Insert into LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id)
  Values (1200 , '2017 Shinjuku-ku', 1689, 'Tokyo', 'Tokyo Prefectu', 'JP');
    Insert into LOCATIONS(location_id, street_address, postal_code, city, state_province, country_id)
  Values (1400 , '2014 Jabberwocky Rd', 26192, 'Southlake', 'Texas', 'US');
  
-- Countries insert data 
select * from countries;
   Insert into Countries values ('DE', 'Germany', 1);
   Insert into Countries values ('IT', 'Italy', 1);
   Insert into Countries values ('JP', 'Japan', 3);
   Insert into Countries values ('US', 'United State', 2);
   
-- DEPARTMENTS insert data
 select * from DEPARTMENTS;
  Insert into DEPARTMENTS values (10, 'Administration', 200 ,1100);
  Insert into DEPARTMENTS values (20, 'Marketing ', 201 ,1200);
  Insert into DEPARTMENTS values (30, 'Purchasing', 202 ,1400);
  
  -- change the column type in table 
  ALTER TABLE EMPLOYEES  
  MODIFY COLUMN HIRE_DATE Date;  
  
-- EMPLOYEES insert data
   select * from EMPLOYEES;
  Insert into EMPLOYEES values (100, 'Steven', 'King', 'SKING', '515-1234567', 19870617, 'ST_CLERK', 24000.00,  0.00, 109, 10);
  Insert into EMPLOYEES values (101, 'Neena', 'Kochhar', 'NKOCHHAR', '515-1234568', 19870618, 'MK_REP', 17000.00,  0.00, 103, 20);
  Insert into EMPLOYEES values (102, 'Lex', 'De Haan', 'LDEHAAN', '515-1234569', 19870619, 'AC_ACCOUNT', 17000.00,  0.00, 108, 30);
  Insert into EMPLOYEES values (103, 'Alexander', 'Hunold', 'AHUNOLD', '590-4234567', 19870620, 'MK_REP', 9000.00,  0.00, 105, 20);
  
  
  DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = 102 ;
  
  UPDATE EMPLOYEES SET LAST_NAME  = 'De Haan' WHERE LAST_NAME  = 'King';
  
  
    -- change the column type in table 
      ALTER TABLE JOB_HISTORY 
      MODIFY COLUMN start_date Date,
      MODIFY COLUMN END_date Date;  
      
-- JOB_HISTORY insert data
select * from JOB_HISTORY;
  Insert into JOB_HISTORY values (102,19930113, 19980724, 'IT_PROG', 20);
  Insert into JOB_HISTORY values (101, 19890921, 19931027,  'AC_ACCOUNT', 10);
  Insert into JOB_HISTORY values (101, 19931028, 19970315,  'AC_MGR', 30);
  Insert into JOB_HISTORY values (100, 19960217, 19991219, 'MK_REP',  30);
  Insert into JOB_HISTORY values (103, 19980324, 19991231, 'ST_CLERK', 20);
  
-- 3. Write a query to find the location_id, street_address, city, state_province, country_name of locations
  
select L.location_id, L.street_address, L.city, L.state_province, C.country_name
From Locations As L
left join Countries  AS C
on L.country_id = C.country_id;

-- 4.Write a query to find the first_name, last name, department ID of all the employees
Select employees.first_name, employees.last_name,employees.DEPARTMENT_ID from EMPLOYEES;

-- 5. Write a query to find the first_name, last_name, job_id, department ID of the employees who works in Japan.
select E.first_name, E.last_name, E.job_id, E.department_id
From Employees As E
join Departments As D
on E.department_id = D.department_id
join Locations As L
on L.location_id = D.location_id
where L.location_id = 1200;

-- 6.  Write a query to find the employee id, last_name along with their manager_id and last_name.
 select E.EMPLOYEE_ID, E.last_name, M.manager_id, M.last_name
 from Employees As E  
 left join Employees As M
 on E.Manager_id = M.employee_id;
 
-- 7. Write a query to find the first_name, last_name and hire date of the employees who was hired after 'Lex De Haan'.
select E.first_name, E.last_name, E.hire_date
from Employees AS E
where date(hire_date)> 19870619;

-- 8. Write a query to get the department name and number of employees for each the department.
select D.DEPARTMENT_NAME, count(E.EMPLOYEE_ID) As Number_of_employees
from DEPARTMENTS AS D
join EMPLOYEES AS E
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
group by E.DEPARTMENT_ID;


-- 9. Write a query to find the employee ID, job title, number of days between ending date and starting date for all jobs in department 30.
select J.employee_ID, J.job_id as job_title, TO_DAYS(J.end_date) - TO_DAYS(J.start_date) as Date_in_department_30
from JOB_HISTORY as J 
where J.department_ID = 30;

select datediff(year, '1999-05-27', '1999-09-26');

-- 10. Write a query to display all department name, manager name, and city.
select D.department_name, D.MANAGER_ID as Manager_name_ID, L.city
from DEPARTMENTS As D
join EMPLOYEES As E
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
join LOCATIONS As L
on D.LOCATION_ID = L.LOCATION_ID;


-- 12. Create table JOBS
Create Table Jobs(
Job_Id varchar (20),
Job_Title varchar (35),
Min_Salary numeric,
MAX_Salary numeric ,
primary key (Job_Id)
);

Insert Into Jobs Values ( 'IT_PROG', 'Information Technology', 20000, 80000);
Insert Into Jobs Values ( 'AC_ACCOUNT', 'Accounting', 16000, 60000);
Insert Into Jobs Values ( 'AC_MGR', 'Management', 25000, 100000);
Insert Into Jobs Values ( 'MK_REP', 'Representative', 14000, 30000);
Insert Into Jobs Values ( 'ST_CLERK', 'Cleck', 14000, 35000);



-- 13. Write a query to display the average salary of each department.
select D.DEPARTMENT_NAME, AVG( JS.Min_Salary+ JS.MAX_Salary) as Average_Salary_Of_department
from DEPARTMENTS AS D
left join JOB_HISTORY As J
on D.department_id = J.department_id
join JOBS As JS
on J.job_id = JS.job_id
group by D.DEPARTMENT_NAME