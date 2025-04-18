# Write your MySQL query statement below

SELECT man.employee_id, man.name, COUNT(emp.employee_id) AS reports_count, ROUND(AVG(emp.age), 0) AS average_age 
FROM Employees emp
JOIN Employees man ON emp.reports_to = man.employee_id
GROUP BY man.employee_id, man.name
ORDER BY man.employee_id