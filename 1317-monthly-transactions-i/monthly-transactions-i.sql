# Write your MySQL query statement below


SELECT 
    LEFT(t.trans_date, 7) AS 'month', t.country, 
    COUNT(t.id) AS trans_count, SUM(t.state = 'approved') AS approved_count, 
    SUM(t.amount) AS trans_total_amount,
    SUM(CASE
            WHEN t.state = 'approved' THEN t.amount
            ELSE 0
        END) AS approved_total_amount
FROM Transactions t
GROUP BY LEFT(t.trans_date, 7), t.country