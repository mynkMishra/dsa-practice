# Write your MySQL query statement below

WITH cte AS (
    SELECT *, DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) as num
    FROM Employee
)
SELECT d.name AS Department, c.name AS Employee, salary AS Salary
FROM cte c
JOIN Department d ON c.departmentId = d.id
WHERE num <= 3