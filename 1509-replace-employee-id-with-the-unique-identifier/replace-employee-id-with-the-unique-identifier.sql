# Write your MySQL query statement below

SELECT eu.unique_id, emp.name
FROM Employees emp
LEFT JOIN EmployeeUNI eu ON emp.id = eu.id
