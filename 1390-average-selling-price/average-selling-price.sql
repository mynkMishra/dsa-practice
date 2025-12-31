# Write your MySQL query statement below

SELECT pr.product_id AS product_id, IFNULL(ROUND(SUM(pr.price*us.units)/SUM(us.units), 2), 0) AS average_price 
FROM Prices pr
LEFT JOIN UnitsSold us ON pr.product_id = us.product_id AND pr.start_date <= us.purchase_date AND us.purchase_date <= pr.end_date
GROUP BY pr.product_id