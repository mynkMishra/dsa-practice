# Write your MySQL query statement below

WITH cte AS (
    SELECT *, DENSE_RANK() OVER(ORDER BY salary DESC) as 'num'
    FROM Employee
)
SELECT MAX(salary) AS SecondHighestSalary
FROM cte
WHERE num = 2