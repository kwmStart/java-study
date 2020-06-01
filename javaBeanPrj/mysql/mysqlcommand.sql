# 单行注释
-- 单行注释  --后必须有空格
/* 多行注释*/
show databases ; -- 显示所有数据库信息

#基础查询
/*
语法
select 查询列表 from 表名;

特点：
1、查询列表可以是：表中的字段、常量、函数、表达式
2、查询结果是一个虚拟的表格。
*/
USE myemployees;
#查询单个字段
SELECT last_name FROM employees;

#查询多个字段
SELECT last_name,email FROM employees;

#查询所有字段 字段可以通过表中字段名称双击获取， 并且可以通过F12对SQL语句进行SQL格式化。 F9是执行查询语句
#`first_name` 中 “`” 是着重号 是用来区分是关键字还是字段名称
SELECT * FROM employees;

#查询常量值、字符型常量值、表达式、函数
SELECT 100,'mack',100%20,VERSION();

#起别名  好处：1、便于理解。2、如果要查询的字段有重名情况下，可以利用起别名区分开来。
SELECT 100%20 AS 'result';
SELECT last_name xing FROM employees;
SELECT last_name 'xing' FROM employees;

#示例： 给salary，显示结果为out put 建议使用双引号，单引号也可以
SELECT salary AS "out put" FROM employees;

#去重 DISTINCT
SELECT  DISTINCT `department_id` FROM employees;

# +的作用
# +在MySQL中只能做运算符
# select 1+100 两个都为数值型，则进行加法运算;
# select '1'+100 其中一个为字符型，试图将字符型转换成数值型，如果转换成功，则继续做加法运算。 如果转换失败，则将字符型数值转换为0，进行计算
# select null+ 100; 只要其中一方为null，则结果肯定为null
#示例： 将员工的姓名拼接成同一个字段
SELECT CONCAT(last_name,first_name) AS NAME FROM employees;

#显示表结构
DESC departments;

#做字段空处理
SELECT IFNULL(commission_pct,0) "res",commission_pct FROM employees;
