# Write your MySQL query statement below


WITH del_rank AS (
    SELECT *, RANK() OVER(PARTITION BY customer_id ORDER BY order_date ASC) AS 'rank'
    FROM Delivery
)
SELECT ROUND(SUM(dr.order_date = dr.customer_pref_delivery_date)*100/COUNT(*), 2) AS immediate_percentage
FROM del_rank dr
WHERE dr.rank = 1