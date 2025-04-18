# Write your MySQL query statement below

WITH dep_p AS (
    SELECT *
    FROM Employee emp
    WHERE primary_flag = 'Y'
)
SELECT 
    emp.employee_id,
    CASE 
        WHEN COUNT(emp.department_id) = 1 THEN emp.department_id
        ELSE dp.department_id
    END AS department_id
FROM Employee emp
LEFT JOIN dep_p AS dp ON emp.employee_id = dp.employee_id
GROUP BY emp.employee_id