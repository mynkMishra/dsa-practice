# Write your MySQL query statement below


WITH added_row_number AS (
    SELECT *, RANK() OVER (PARTITION BY product_id ORDER BY year ASC) AS row_rank
    FROM Sales
)
SELECT product_id, year AS first_year, quantity, price 
FROM added_row_number
WHERE row_rank = 1;