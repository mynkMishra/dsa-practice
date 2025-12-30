# Write your MySQL query statement below

SELECT vs.customer_id AS customer_id, COUNT(vs.customer_id) AS count_no_trans 
FROM Visits vs
LEFT JOIN Transactions tr ON tr.visit_id = vs.visit_id
WHERE tr.transaction_id IS NULL
GROUP BY vs.customer_id