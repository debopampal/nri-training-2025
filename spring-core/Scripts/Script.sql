SELECT FIRST_NAME, LAST_NAME, DEPARTMENT, DESIGNATION, SALARY
FROM HR.EMPLOYEE;

    select
        e1_0.id,
        e1_0.department,
        e1_0.designation,
        e1_0.first_name,
        e1_0.last_name,
        e1_0.salary 
    from
        employee e1_0 
    where
        e1_0.first_name like '%Rohit%'
        or e1_0.last_name like '%Dey%'


SELECT FIRST_NAME, LAST_NAME, DEPARTMENT, DESIGNATION, SALARY, ID FROM HR.EMPLOYEE WHERE EMPLOYEE.DEPARTMENT = 'IT';

SELECT FIRST_NAME, LAST_NAME, DEPARTMENT, DESIGNATION, SALARY, ID FROM HR.EMPLOYEE WHERE EMPLOYEE.FIRST_NAME = '' AND EMPLOYEE.LAST_NAME ='';

SELECT FIRST_NAME, LAST_NAME, DEPARTMENT, DESIGNATION, SALARY, ID FROM HR.EMPLOYEE WHERE EMPLOYEE.SALARY BETWEEN 1500000 AND 2000000;

select
        e1_0.id,
        e1_0.department,
        e1_0.designation,
        e1_0.first_name,
        e1_0.last_name,
        e1_0.salary 
    from
        employee e1_0 
    order by
        e1_0.salary 
    offset
        1 rows 
    fetch
        first 1 rows only