DROP DATABASE IF EXISTS cloudDB02;
CREATE DATABASE cloudDB02 CHARACTER SET UTF8;
USE cloudDB02;
CREATE TABLE dept
(
  deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source   VARCHAR(60)
);
 
INSERT INTO dept(dname,db_source) VALUES('综合管理部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('计划财务部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('市场研发部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('系统总体室',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('数据中心',DATABASE());
 
SELECT * FROM dept;