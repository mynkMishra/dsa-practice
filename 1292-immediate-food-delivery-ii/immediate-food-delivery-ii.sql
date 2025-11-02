# Write your MySQL query statement below


WITH rank_tab AS (
    SELECT *, 
    RANK() OVER (PARTITION BY customer_id ORDER BY order_date ASC) AS 'ran'
    FROM Delivery
)
SELECT ROUND(SUM(rn.order_date = rn.customer_pref_delivery_date)*100/COUNT(*), 2) AS immediate_percentage
FROM rank_tab rn
WHERE rn.ran = 1
