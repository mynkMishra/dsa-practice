# Write your MySQL query statement below

WITH play_tab AS (
    SELECT player_id, MIN(event_date) AS event_date 
    FROM Activity
    GROUP BY player_id
)
SELECT ROUND(COUNT(*)/(SELECT COUNT(DISTINCT act.player_id) FROM Activity act), 2) AS 'fraction' 
FROM Activity act
JOIN play_tab pt ON act.player_id = pt.player_id
WHERE act.event_date = DATE_ADD(pt.event_date, INTERVAL 1 DAY)

