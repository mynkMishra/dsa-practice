# Write your MySQL query statement below

SELECT q.query_name, 
    ROUND(ROUND(SUM(ROUND(q.rating/q.position, 4)), 4)/COUNT(q.query_name), 2) AS quality,  
    ROUND(SUM(q.rating < 3)*100/COUNT(q.query_name), 2) AS poor_query_percentage
FROM Queries q
GROUP BY q.query_name