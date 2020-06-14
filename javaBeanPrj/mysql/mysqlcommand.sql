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


#进阶二 条件查询
/*
 语法：
    select 查询列表  from 表名  where 筛选条件
 分类：
    一、按照条件表达式筛选。
       1）、条件运算符： > , < , = , <> , >= , <=
    二、按照逻辑表达式筛选。
       2）、逻辑运算符：&& , || , !    Java使用
			and , or , not
			&&和and：并且  两个条件都为true时，结果为true，反之为false。
			||和or   或者  只要有一个为true，结果就为true，反之为false。
			！和not   非    如果连接本身为true，结果就为false。
    三、模糊查询：
        like
        between and
        in
        is null

*/
#按照条件表达式筛选。条件运算符： > , < , = , <> , >= , <=
# 查询工资大于12000的员工信息
SELECT * FROM employees WHERE salary >= 12000;

# 查询部门编号不等于90号的员工名和部门编号
SELECT
    CONCAT(last_name, ' ', first_name) 'name',
    department_id
FROM
    employees
-- WHERE department_id != 90 ;
WHERE department_id <> 90 ;

#按照逻辑表达式筛选。
#1、查询工资在10000到20000之间的员工名和工资以及奖金。
SELECT
    lasT_name,
    salary,
    commission_pct
FROM
    employees
WHERE salary > 10000
  AND salary < 20000 ;

#2、查询部门编号不在90到110之间，或者工资高于15000的员工信息
SELECT * FROM employees WHERE (department_id < 90 OR department_id >110) OR salary >15000;

#按照模糊查询。
/*
 like    % 代表统配符
 特点：
 1、通常和通配符搭配使用
    通配符：% 任意多个字符，包含0个字符。
            _ 任意单个字符。
 between and
 1、可以提高SQL的简洁度。
 2、包含临界值
 3、两个临界值不可以调换顺序，大于等于  小于等于
 in
 1、使用in 比or的SQL简洁度高
 2、in列表的值类型必须统一或者兼容
 3、不支持通配符
 is null或者 is not null
 1、 =或者<> 不可以判断 null
*/
#1、like
#查询员工名称中包含字符a的员工信息
SELECT * FROM employees WHERE last_name LIKE '%a%';
#查询员工名称第三个字符为e，第五个字符为a的员工名和工资
SELECT last_name ,salary FROM employees WHERE last_name LIKE '__n_l%';
#查询员工名中第二个字符为_ 的员工名   _需要转义 "\_"
SELECT last_name ,salary FROM employees WHERE last_name LIKE '_\_%';
#escape 指定转义字符  即指定“$”为转义字符 'S_'等于于'\_'
SELECT last_name ,salary FROM employees WHERE last_name LIKE '_$_%' ESCAPE '$';

#2 between and
#查询部门编号在100到120之间的员工信息
SELECT * FROM employees WHERE employee_id BETWEEN 100 AND 120;

#3 in
# 查询员工的工种编号是 IT_PROG 、 AD_VP 中的任一一个的员工的名和工种编号
SELECT last_name ,job_id FROM employees WHERE job_id IN ('IT_PROG','AD_VP');

#is null
# 查询没有奖金的员工信息
SELECT * FROM employees WHERE commission_pct IS NULL;
#安全等于 <=>  不仅可以判断空值null  也可以判断数值
SELECT * FROM employees WHERE commission_pct <=> NULL;
# 查询员工工资为12000的员工信息
SELECT * FROM employees WHERE salary <=> 12000;
/*
安全等于 <=>  不仅可以判断空值null  也可以判断数值  可读性差
*/

#查询员工的员工名和年薪  commission_pct需要 ifnull判断
SELECT last_name  ,salary*12*(1+IFNULL(commission_pct,0)) year_salary FROM employees;

/*
 进阶三、排序查询：
 语法：
 select 查询列表  from 表名  [where 筛选条件] order by 排序列表 asc/desc
 特点：1、 默认为升序，asc升序  desc 降序
       2、order by 子句可以支持单个字段、多个字段、表达式、函数、表达式。
       3、order by子句一般放在查询语句的最后面，limit子句除外。

*/
#案例1： 从高到低排序  员工薪资排序
SELECT * FROM employees ORDER BY salary DESC;

#案例2：查询部门编号>=90 .按照入职先后进行排序
SELECT * FROM employees t WHERE t.`department_id`>=90 ORDER BY t.`hiredate` ;

#案例3：按照年薪的高低 显示员工信息和年薪【按表达式排序】
SELECT
        salary * 12 * (1+ IFNULL(commission_pct, 0)) AS "year_salary",
        t.*
FROM
    employees t
ORDER BY year_salary DESC ;

#案例4 按照年薪的高低 显示员工信息和年薪【按表达式排序】
SELECT
        salary * 12 * (1+ IFNULL(commission_pct, 0)) AS "year_salary",
        t.*
FROM
    employees t
ORDER BY salary * 12 * (1+ IFNULL(commission_pct, 0)) DESC ;

#案例5 按照员工姓名长度显示员工的姓名和工资 【按函数排序】
SELECT LENGTH(last_name) nameLength,last_name,salary FROM employees ORDER BY nameLength DESC;

#案例6 查询员工信息 先按照工资排序，再按照员工编号排序
SELECT * FROM employees ORDER BY salary DESC,employee_id DESC;

#按照年薪降序 姓名升序排列。
SELECT
    last_name,
    department_id,
    salary * 12 * (1+ IFNULL(commission_pct, 0)) AS "year_salary"
FROM
    employees
ORDER BY year_salary DESC,
         last_name ;

# 查询员工工资不在8000到17000之间的员工的姓名和工资，按照工资降序排列
SELECT last_name ,salary FROM employees WHERE salary NOT BETWEEN 8000 AND 17000 ORDER BY salary DESC;
SELECT last_name ,salary FROM employees WHERE NOT (salary BETWEEN 8000 AND 17000) ORDER BY salary DESC;

# 查询员工邮箱中含有‘e’的员工信息，并按照员工邮箱字节数降序排列。
SELECT * FROM employees  t WHERE t.`email` LIKE '%e%' ORDER BY LENGTH(t.`email`) DESC;

/*
  进阶四：常见函数

  概念：类似于Java的方法。将一组逻辑语句封装在方法体内，对外暴露方法名。
  好处： 1、隐藏了实现细节。2、提高了代码的重用性。
  调用：select 函数名(实参列表) 【from 表名】;
  特点： ① 叫什么（函数名） ②干什么 （函数功能）。
  分类：
        1、单行函数。 如：concat 、ifnull、 length等
        2、分组函数。 做统计使用 又称为统计函数，聚合函数、组函数。

*/
# 一、字符函数
#1、length 字节长度
SELECT LENGTH('john');
SELECT LENGTH('张三丰hahaha'); -- 15
SHOW VARIABLES LIKE '%char%'; -- 查看字符集 utf8 中文三个字节  gbk 中文两个字节

#2、concat拼接字符串
SELECT CONCAT(last_name,'_',first_name) FROM employees;

#3、upper 、lower 大小写转化
SELECT CONCAT(UPPER(last_name),'_',LOWER(first_name)) AS xm FROM employees;

#4、substr、substring 截取   SUBSTR 有四种重载方法
-- 注意：SQL的索引都是从1 开始
#根据不同参数类型数量，函数不同
#两个参数 截取从指定索引位置开始后面的所有字符
SELECT SUBSTR('小明喜欢吃冰淇淋',6) AS out_put;
#三个参数 截取从指定索引位置开始指定字符长度的字符
SELECT SUBSTR('小明喜欢吃冰淇淋',1,2) out_put;

SELECT SUBSTR('小明喜欢吃冰淇淋' FROM 2) out_put; -- 从指定位置开始截取
SELECT SUBSTR('小明喜欢吃冰淇淋'FROM 1 FOR 2) out_put; --  从指定位置开始截取指定长度字符

#5、instr 返回字符串第一次出现的索引 找不到则返回0
SELECT INSTR('杨不悔喜欢上了殷梨亭','殷梨亭') out_put; -- 8
SELECT INSTR('杨不悔喜欢上了殷梨亭','殷六侠') out_put; -- 0

#6、trim 去除前后空格
SELECT TRIM('    yingxiong ') ;
SELECT TRIM(BOTH 'aa' FROM 'aaaaaaaaaaaaaa英aaa雄aaaaaaaaa') AS put_out; -- 去除两边字符
SELECT TRIM(TRAILING 'a' FROM 'aaaaaaaaaaaaaa英aaa雄aaaaaaaaa') AS put_out; -- 去除后面字符
SELECT TRIM(LEADING 'a' FROM 'aaaaaaaaaaaaaa英aaa雄aaaaaaaaa') AS put_out; -- 去除前面字符

# 语法错误MySQL8.0 select trim ('a' from 'aaaaaaaaaaaaaa英雄aaaaaaaaa') as put_out;

#7、lpad 用指定字符实现左填充指定长度
SELECT LPAD('殷素素',10,'*') ; -- *******殷素素
SELECT LPAD('殷素素',2,'*') ; -- 殷素

#8、rpad 用指定字符实现右填充指定长度
SELECT RPAD('殷素素',11,'ab') ; -- 殷素素ababababa
SELECT RPAD('殷素素',2,'ab') ; -- 殷素

#9、replace 替换
SELECT REPLACE('张无忌爱上了周芷若','周芷若','赵敏');

