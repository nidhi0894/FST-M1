CREATE TABLE salesman(salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int);

DESCRIBE salesman


INSERT INTO salesman VALUES(5001,'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
      
SELECT * FROM salesman;

SELECT * FROM salesman;

SELECT salesman_id,salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT SALESMAN_ID,COMMISSION FROM salesman WHERE SALESMAN_NAME='Paul Adam';

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100 ;

UPDATE salesman SET grade=100 ;

Select * FROM salesman;

Update salesman SET GRADE=200 WHERE SALESMAN_CITY='Rome';

Update salesman SET GRADE=300 WHERE salesman_name='James Hoog';

Update salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

CREATE TABLE salesman(salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int);

DESCRIBE salesman


INSERT INTO salesman VALUES(5001,'Nail Knite', 'Paris', 13);

INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
      
SELECT * FROM salesman;

SELECT salesman_id,salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT SALESMAN_ID,COMMISSION FROM salesman WHERE SALESMAN_NAME='Paul Adam';

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100 ;

Select * FROM salesman;

Update salesman SET GRADE=200 WHERE SALESMAN_CITY='Rome';

Update salesman SET GRADE=300 WHERE salesman_name='James Hoog';

Update salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

Select * FROM salesman;

