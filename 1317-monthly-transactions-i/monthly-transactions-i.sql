# Write your MySQL query statement below

SELECT DATE_FORMAT(tran.trans_date, '%Y-%m') AS 'month', tran.country, COUNT(*) AS trans_count, 
COUNT(CASE WHEN tran.state = 'approved' THEN 1 END) AS approved_count,
SUM(tran.amount) AS 'trans_total_amount', 
SUM(CASE WHEN tran.state = 'approved' THEN tran.amount ELSE 0 END) AS approved_total_amount
FROM Transactions tran
GROUP BY DATE_FORMAT(tran.trans_date, '%Y-%m'), tran.country
