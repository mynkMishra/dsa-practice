# Write your MySQL query statement below

SELECT pr.product_name AS product_name, sa.year AS year, sa.price AS price 
FROM Sales sa
LEFT JOIN Product pr ON sa.product_id = pr.product_id