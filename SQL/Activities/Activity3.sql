INSERT ALL 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

SELECT * FROM salesman; 

SELECT salesman_id,salesman_city FROM salesman;

SELECT * FROM salesman WHERE salesman_city='Paris';

SELECT SALESMAN_ID,COMMISSION FROM salesman WHERE SALESMAN_NAME='Paul Adam';

