# Write your MySQL query statement below

SELECT emp.name AS name, bn.bonus AS bonus 
FROM Employee emp
LEFT JOIN Bonus bn ON emp.empId = bn.empId
WHERE bn.bonus < 1000 OR bn.empId IS NULL