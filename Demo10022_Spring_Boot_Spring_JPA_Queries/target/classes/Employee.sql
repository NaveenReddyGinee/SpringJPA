DROP DATABASE IF EXISTS springbootdb;
CREATE DATABASE springbootdb; 
USE springbootdb;

DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
  employeeId int(11) unsigned NOT NULL AUTO_INCREMENT,
  employeeName varchar(20) DEFAULT NULL,
  salary double DEFAULT NULL,
  departmentCode int(11),
  PRIMARY KEY (employeeId)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

INSERT INTO employee (employeeId, employeeName,departmentCode, salary) VALUES
	(1001, 'MSD'       ,101 , 10000),
	(1002, 'James'     ,101 , 12000),
	(1004, 'Rocky'     ,102 , 15000),
	(1005, 'Eric'      ,102 , 20000),
	(1006, 'James'     ,103 , 35000),
	(1007, 'Jacob'     ,103 , 51000),
	(1008, 'Cynthya'   ,104 , 10000),
	(1009, 'Dan'       ,104 , 12000),
	(1010, 'Tim'       ,104 , 15000),
	(1011, 'Mario'     ,102 , 20000),
	(1012, 'Stuart'    ,102 , 35000),
	(1013, 'Ben'       ,102 , 51000);
commit;
