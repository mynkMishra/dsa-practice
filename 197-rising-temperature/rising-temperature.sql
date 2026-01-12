# Write your MySQL query statement below

WITH w1 AS (
    SELECT * 
    FROM Weather
    ORDER BY recordDate ASC
),
w2 AS (
    SELECT * 
    FROM Weather
    ORDER BY recordDate ASC
)
SELECT b.id 
FROM w1 a
LEFT JOIN w2 b ON DATEDIFF(a.recordDate, b.recordDate) = -1
WHERE a.temperature < b.temperature