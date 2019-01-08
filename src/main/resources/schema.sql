CREATE KEYSPACE demo
WITH replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

CREATE TABLE employee(
   id int PRIMARY KEY,
   firstname text,
   lastname text,
   dept text
);
insert into employee (id, firstname, lastname, dept)
          values (1, 'Sri', 'Latha', 'BFS');
 
select * from  employee;