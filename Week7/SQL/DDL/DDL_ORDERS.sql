SELECT * FROM sys.sys_config;
-- DDL Date  Definition Language 
CREATE TABLE sys.ORDERS(
ORDERS_DATE TIMESTAMP, -- DATETIME 
CUSTOMER_ID NUMERIC(3,0),  -- (前面是整數，後面是小數)
AMOUNT NUMERIC(13,2)
); 

-- DML -- Date Manipulation Language 
 select * from sys.ORDERS;
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT) VALUES ("2022-11-02 20:10:23", 101, 10000);
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102, 15000);
INSERT INTO SYS.ORDERS VALUES (NOW(), 103, 17000);
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID) VALUES (NOW(), 104);

-- Select Statement 
select * from sys.orders where customer_id = 103; 
select amount from sys.orders where customer_id = 101; -- 10000.00
select customer_id from sys.orders where amount >= 15000; -- 102|103

-- Update statements 
UPDATE SYS.ORDERS SET AMOUNT = 3000 WHERE CUSTOMER_ID = 102;
-- select * from sys.orders where customer_id = 102;
select * from sys.orders;
UPDATE SYS.ORDERS SET AMOUNT = 20000 WHERE CUSTOMER_ID IN (101, 103) AND ORDER_DATE >= '2022-11-02'; -- 2 ROWS UPDATED 
UPDATE SYS.ORDERS SET AMOUNT = 40000 WHERE CUSTOMER_ID IN (101, 103) AND ORDER_DATE >= '2022-11-04'; -- 1 ROW UPDATED 
SELECT COUNT(*) FROM ORDERS; -- 8
SELECT COUNT(*) FROM SYS.ORDERS WHERE ORDERS_DATE >= '2022-11-04'; -- 3 
SELECT 1 FROM SYS.ORDERS WHERE ORDERS_DATE >= '2022-11-04'; -- THERE '1' ARE RETURNED 
SELECT COUNT(1) FROM SYS.ORDERS WHERE ORDERS_DATE >= '2022-11-04'; -- 

-- DELETE STATEMENTS 
DELETE FROM SYS.ORDERS WHERE CUSTOMER_ID IN (102, 104); -- 2 ROW DELETEM 
select * from sys.orders; 
DELETE FROM SYS.ORDERS; -- DELETE ALL ROWS 
select * from sys.orders; 


INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-02 20:10:23', 102, 20000);
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-02 20:10:23', 102, 30000);
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102, 30000);

delete from sys.orders where customer_id = 102 limit 1; 
select * from sys.orders;
DELETE FROM SYS.ORDERS WHERE CUSTOMER_ID = 102 ORDER BY ORDERS_DATE DESC LIMIT 1; -- DELETE THE RECORD WITH LATEST ORDER

delete from sys.orders; 
ALTER TABLE SYS.ORDERS ADD MEMBERSHIP VARCHAR(1);
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ('2022-11-02 20:10:23', 102, 22000, 'G');
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ('2022-11-02 20:10:23', 102, 30000, 'S');
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 102, 40000, 'S');
INSERT INTO SYS.ORDERS (ORDERS_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 102, 40000, null);
select membership, count(1) from sys.orders group by membership; -- G,1 | S,2 
select membership, AVG(AMOUNT) from sys.orders group by membership; -- G, 22000 | S, 35000
select membership, sum(amount) from sys.orders group by membership;  -- G, 22000 | S, 70000
select membership, count(amount) from sys.orders group by membership having count(membership) > 1 ; -- S,2 

select membership, count(membership) from sys.orders 
where orders_date > '2022-11-05' group by membership having count(membership) > 1 ;

select distinct membership from sys.orders; -- G,S