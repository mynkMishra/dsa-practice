# Write your MySQL query statement below

SELECT empU.unique_id AS unique_id, emp.name AS name
FROM Employees emp
LEFT JOIN EmployeeUNI empU ON emp.id = empU.id
