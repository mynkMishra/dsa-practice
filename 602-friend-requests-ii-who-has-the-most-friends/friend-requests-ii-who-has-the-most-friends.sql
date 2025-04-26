# Write your MySQL query statement below

WITH counter_as_accepter AS (
    SELECT accepter_id AS id, COUNT(requester_id) AS num
    FROM RequestAccepted
    GROUP BY accepter_id
),
counter_as_requester AS (
    SELECT requester_id AS id, COUNT(accepter_id) AS num
    FROM RequestAccepted
    GROUP BY requester_id
),
counter AS (
    SELECT * FROM counter_as_accepter
    UNION ALL
    SELECT * FROM counter_as_requester
),
sum_counter AS (
    SELECT id, SUM(num) AS num
    FROM counter
    GROUP BY id
)
SELECT * 
FROM sum_counter
ORDER BY num DESC
LIMIT 1


