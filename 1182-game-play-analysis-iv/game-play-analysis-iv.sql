# Write your MySQL query statement below

WITH log_tab AS(
    SELECT *, MIN(a.event_date) AS 'log_date' 
    FROM Activity a
    GROUP BY a.player_id
)
SELECT ROUND(COUNT(lt.player_id)/(SELECT COUNT(DISTINCT b.player_id) FROM Activity b), 2) AS 'fraction'
FROM log_tab lt
JOIN Activity a ON a.player_id = lt.player_id
WHERE DATEDIFF(a.event_date, lt.log_date) = 1

