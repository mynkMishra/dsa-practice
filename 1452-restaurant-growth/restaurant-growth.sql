# Write your MySQL query statement below

WITH cum_customer AS (
    SELECT DISTINCT visited_on, 
    SUM(amount) OVER(ORDER BY visited_on 
        RANGE BETWEEN INTERVAL 6 DAY PRECEDING AND CURRENT ROW) AS cum_amount
    FROM Customer
)
SELECT visited_on, cum_amount AS amount, ROUND(cum_amount/7, 2) AS average_amount
FROM cum_customer c
ORDER BY visited_on ASC
LIMIT 100000
OFFSET 6