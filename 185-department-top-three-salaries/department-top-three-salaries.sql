# Write your MySQL query statement below

WITH ranked AS (
    SELECT d.name AS "Department", e.name AS "Employee", e.salary AS "Salary",
    DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC) AS "seq"
    FROM Employee e
    JOIN Department d ON e.departmentId = d.id 
)
SELECT Department, Employee, Salary
FROM ranked
WHERE seq <= 3