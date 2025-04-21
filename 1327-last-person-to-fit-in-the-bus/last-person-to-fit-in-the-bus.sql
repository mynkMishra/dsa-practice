# Write your MySQL query statement below

WITH cumm_total_weight AS (
    SELECT *, SUM(weight) OVER (ORDER BY turn) AS total_weight
    FROM Queue
)
SELECT person_name 
FROM cumm_total_weight
WHERE total_weight <= 1000
ORDER BY total_weight DESC
LIMIT 1
