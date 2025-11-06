# Write your MySQL query statement below

WITH first_tab AS (
    SELECT s.product_id, MIN(s.year) AS min_year
    FROM Sales s
    GROUP BY s.product_id
)
SELECT s.product_id, s.year AS 'first_year', s.quantity, s.price 
FROM Sales s
JOIN first_tab ft ON s.product_id = ft.product_id AND s.year = ft.min_year
