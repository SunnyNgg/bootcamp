CREATE TABLE sys.ORDERS (
  ORDER_DATE TIMESTAMP,
  CUSTOMER_ID NUMERIC(3, 0),
  AMOUNT NUMERIC(13, 2)
);

select * from SYS.ORDERS;
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-02 20:10:23', 101, 10000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102, 15000);
INSERT INTO SYS.ORDERS VALUES (NOW(), 103, 17000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID) VALUES (NOW(), 104);
-- INSERT INTO SYS.ORDERS VALUES (103, 17000); -- The DBMS don't know which colums you would like to store the values

-- SELECT STATEMENTS
select * from sys.orders where customer_id = 101;
select amount from sys.orders where customer_id = 101; -- 10000.00
select customer_id from sys.orders where amount >= 15000; -- 102 | 103

-- UPDATE STATEMENTS
UPDATE SYS.ORDERS SET AMOUNT = 30000 WHERE CUSTOMER_ID = 102;
select * from sys.orders;
UPDATE SYS.ORDERS SET AMOUNT = 20000 WHERE CUSTOMER_ID IN (101, 103) AND ORDER_DATE >= '2022-11-02'; -- 2 ROWS UPDATED
UPDATE SYS.ORDERS SET AMOUNT = 40000 WHERE CUSTOMER_ID IN (101, 103) AND ORDER_DATE >= '2022-11-04'; -- 1 ROW UPDATED
SELECT COUNT(*) FROM SYS.ORDERS; -- 4
SELECT COUNT(*) FROM SYS.ORDERS WHERE ORDER_DATE >= '2022-11-04'; -- 3
SELECT 1 FROM SYS.ORDERS WHERE ORDER_DATE >= '2022-11-04'; -- THREE '1' ARE RETURNED
SELECT COUNT(1) FROM SYS.ORDERS WHERE ORDER_DATE >= '2022-11-04'; -- 3

-- DELETE STATEMENETS
DELETE FROM SYS.ORDERS WHERE CUSTOMER_ID IN (102, 104); -- 2 ROWS DELETED
select * from sys.orders;
DELETE FROM SYS.ORDERS; -- DELETE ALL ROWS
select * from sys.orders;

INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-02 20:10:23', 102, 20000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES ('2022-11-04 20:10:23', 102, 30000);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT) VALUES (NOW(), 102, 30000);
select * from sys.orders;
DELETE FROM SYS.ORDERS WHERE CUSTOMER_ID = 102 ORDER BY ORDER_DATE DESC LIMIT 1; -- DELETE THE RECORD WITH LATEST ORDER_DATE
select * from sys.orders;

-- ALTER COLUMNS AND GROUP BY
ALTER TABLE SYS.ORDERS ADD MEMBERSHIP VARCHAR(1);
DELETE FROM SYS.ORDERS; -- DELETE ALL ROWS
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ('2022-11-02 20:10:23', 101, 22000, 'G');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES ('2022-11-04 20:10:23', 102, 30000, 'S');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 103, 40000, 'S');
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP) VALUES (NOW(), 104, 40000, NULL);
SELECT MEMBERSHIP, COUNT(1) FROM SYS.ORDERS GROUP BY MEMBERSHIP; -- G, 1 | S, 2
SELECT MEMBERSHIP, AVG(AMOUNT) FROM SYS.ORDERS GROUP BY MEMBERSHIP; -- G, 22000 | S, 35000
SELECT MEMBERSHIP, SUM(AMOUNT) FROM SYS.ORDERS GROUP BY MEMBERSHIP; -- G, 22000 | S, 70000
SELECT MEMBERSHIP, COUNT(MEMBERSHIP) FROM SYS.ORDERS GROUP BY MEMBERSHIP HAVING COUNT(MEMBERSHIP) > 1; -- S, 2

SELECT MEMBERSHIP, COUNT(MEMBERSHIP) FROM SYS.ORDERS 
WHERE ORDER_DATE > '2022-11-05' GROUP BY MEMBERSHIP HAVING COUNT(MEMBERSHIP) > 1; -- NO ROWS RETURNED
SELECT DISTINCT MEMBERSHIP FROM SYS.ORDERS; -- G, S, NULL

ALTER TABLE ORDERS ADD ORDER_ID NUMERIC(3);

CREATE TABLE sys.ORDERS2 (
  ORDER_DATE TIMESTAMP,
  ORDER_ID NUMERIC(3),
  CUSTOMER_ID NUMERIC(3),
  AMOUNT NUMERIC(13, 2)
);
INSERT INTO SYS.ORDERS2 (ORDER_DATE, ORDER_ID, CUSTOMER_ID, AMOUNT) VALUES (NOW(),1, 103, 40000);
INSERT INTO SYS.ORDERS2 (ORDER_DATE, ORDER_ID, CUSTOMER_ID, AMOUNT) VALUES (NOW(),2, 104, 20000);
SELECT * FROM SYS.ORDERS2;

CREATE TABLE sys.CUSTOMERS2 (
  CUSTOMER_ID NUMERIC(3),
  NAME VARCHAR(20),
  ADDRESS VARCHAR(30)
);

SELECT *
FROM SYS.ORDERS2
RIGHT JOIN SYS.CUSTOMERS2 
ON ORDERS2.CUSTOMER_ID = CUSTOMERS2.CUSTOMER_ID
WHERE ORDERS2.CUSTOMER_ID IS NULL;

SELECT C.*
FROM CUSTOMERS2 C
WHERE NOT EXISTS (SELECT 1 FROM ORDERS2 D WHERE D.CUSTOMER_ID = C.CUSTOMER_ID);

INSERT INTO SYS.CUSTOMERS2 (CUSTOMER_ID, NAME, ADDRESS) VALUES (101, 'TOMMY', 'DUMMY ADDRESS');
INSERT INTO SYS.CUSTOMERS2 (CUSTOMER_ID, NAME, ADDRESS) VALUES (103, 'ALIN', 'DUMMY ADDRESS');
INSERT INTO SYS.CUSTOMERS2 (CUSTOMER_ID, NAME, ADDRESS) VALUES (104, 'STEVE', 'DUMMY ADDRESS');





DROP TABLE SYS.ORDERS;
DROP TABLE SYS.CUSTOMER;

CREATE TABLE SYS.CUSTOMERS (
	CUSTOMER_ID NUMERIC(3),
    CUSTOMER_NAME VARCHAR(20),
    CUSTOMER_ADDRESS VARCHAR(100)
);

CREATE TABLE SYS.ORDERS (
  ORDER_DATE TIMESTAMP,
  CUSTOMER_ID NUMERIC(3, 0), -- ID
  AMOUNT NUMERIC(13, 2),
  MEMBERSHIP VARCHAR(1),
  ORDER_ID NUMERIC(3) -- ID
);

INSERT INTO SYS.CUSTOMERS (CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS) 
VALUES (101, 'TOMMY', 'DUMMY ADDRESS1');
INSERT INTO SYS.CUSTOMERS (CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS) 
VALUES (102, 'ALAN', 'DUMMY ADDRESS2');
INSERT INTO SYS.CUSTOMERS (CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS) 
VALUES (103, 'VANUS', 'DUMMY ADDRESS3');
SELECT * FROM SYS.CUSTOMERS;

INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP, ORDER_ID) 
VALUES (NOW(), 102, 10000, 'S', 201);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP, ORDER_ID) 
VALUES (NOW(), 102, 20000, 'S', 202);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP, ORDER_ID) 
VALUES (NOW(), 103, 40000, 'G', 203);
INSERT INTO SYS.ORDERS (ORDER_DATE, CUSTOMER_ID, AMOUNT, MEMBERSHIP, ORDER_ID) 
VALUES (NOW(), 100, 40000, 'G', 204);
SELECT * FROM SYS.ORDERS;

-- LEFT JOIN, CUSTOMERS IN LEFT, ORDERS IN RIGHT
SELECT *
FROM SYS.CUSTOMERS
LEFT JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;

-- RIGHT JOIN
SELECT *
FROM SYS.CUSTOMERS
RIGHT JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;

-- INNER JOIN
SELECT *
FROM SYS.CUSTOMERS
INNER JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;

-- INNER JOIN (ANOTHER APPROACH)
SELECT *
FROM SYS.CUSTOMERS, SYS.ORDERS
WHERE ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;

-- FULL OUTER JOIN
SELECT *
FROM SYS.CUSTOMERS
LEFT JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID
UNION
SELECT *
FROM SYS.CUSTOMERS
RIGHT JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID;


-- LEFT JOIN, AND ORDERS HAS NO LINKED RECORD
SELECT *
FROM SYS.CUSTOMERS
LEFT JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID
WHERE ORDERS.CUSTOMER_ID IS NULL;

SELECT *
FROM SYS.CUSTOMERS
WHERE NOT EXISTS (SELECT 1
					FROM SYS.ORDERS 
					WHERE ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID);

-- RIGHT JOIN, AND CUSTOMERS HAS NO LINKED RECORD
SELECT *
FROM SYS.CUSTOMERS
RIGHT JOIN SYS.ORDERS
ON ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID
WHERE CUSTOMERS.CUSTOMER_ID IS NULL;

-- ALIASES
SELECT C.CUSTOMER_ID AS ID,
C.CUSTOMER_NAME AS NAME
FROM SYS.CUSTOMERS C
LEFT JOIN SYS.ORDERS O
ON O.CUSTOMER_ID = C.CUSTOMER_ID
ORDER BY C.CUSTOMER_ID DESC; -- DESCENDING ORDER

-- UNION ALL

-- NULL
SELECT C.CUSTOMER_ID,
		CUSTOMER_NAME,
        CUSTOMER_ADDRESS,
        IFNULL(ORDER_DATE,'N/A') AS ORDER_DATE,
        IFNULL(AMOUNT,'N/A') AS AMOUNT,
        IFNULL(MEMBERSHIP,'N/A') AS MEMBERSHIP,
        IFNULL(ORDER_ID,'N/A') AS ORDER_ID
FROM SYS.ORDERS C RIGHT JOIN SYS.CUSTOMERS O
ON O.CUSTOMER_ID = C.CUSTOMER_ID;

-- OPERATORS + ||
SELECT CONCAT('FABCEAFDAS',' ABC') FROM DUAL;
SELECT CONCAT('FABCEAFDAS',' ABC'), CUSTOMER_NAME FROM SYS.CUSTOMERS;


-- EXISTS/ NOT EXISTS
SELECT *
FROM SYS.CUSTOMERS
WHERE NOT EXISTS (SELECT 1
					FROM SYS.ORDERS 
					WHERE ORDERS.CUSTOMER_ID = CUSTOMERS.CUSTOMER_ID);
-- MIN, MAX
SELECT * FROM SYS.CUSTOMERS C 
WHERE EXISTS (SELECT 1 FROM SYS.ORDERS O 
			  WHERE O.CUSTOMER_ID = C.CUSTOMER_ID
              AND O.AMOUNT = (SELECT MIN(AMOUNT) FROM SYS.ORDERS)
              );

-- BETWEEN
SELECT * 
FROM SYS.ORDERS 
WHERE ORDER_DATE BETWEEN '2022-11-08 00:00:00' AND '2022-11-08 23:59:59';

SELECT *
FROM SYS.CUSTOMERS
WHERE CUSTOMER_ID IN (102, 103); -- CUSTOMER_ID = 1O2 OR CUSTOMER_ID = 103

SELECT *
FROM SYS.ORDERS
WHERE AMOUNT >= 15000 AND AMOUNT < 30000;

-- LIKE
SELECT *
FROM SYS.CUSTOMERS
WHERE CUSTOMER_NAME LIKE 'V%'