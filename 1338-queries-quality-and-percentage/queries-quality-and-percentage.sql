# Write your MySQL query statement below

SELECT 
    que.query_name, 
    ROUND(AVG(que.rating/que.position), 2) AS 'quality',
    ROUND(COUNT(CASE WHEN que.rating < 3 THEN 1 END)*100/COUNT(que.query_name),2) AS 'poor_query_percentage'
FROM Queries que
GROUP BY que.query_name