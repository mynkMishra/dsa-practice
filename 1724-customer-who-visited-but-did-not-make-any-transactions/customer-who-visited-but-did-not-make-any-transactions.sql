# Write your MySQL query statement below


SELECT vs.customer_id, COUNT(vs.visit_id) AS count_no_trans
FROM Visits vs
LEFT JOIN Transactions tr ON vs.visit_id = tr.visit_id
WHERE tr.transaction_id IS NULL
GROUP BY vs.customer_id
