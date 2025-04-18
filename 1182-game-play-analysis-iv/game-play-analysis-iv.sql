# Write your MySQL query statement below

WITH act_rank AS (
    SELECT *, RANK() OVER(PARTITION BY player_id ORDER BY event_date ASC) AS 'rank'
    FROM Activity
),
first_day AS(
    SELECT *
    FROM act_rank a
    WHERE a.rank = 1
    GROUP BY a.player_id
),
second_day AS(
    SELECT *
    FROM act_rank a
    WHERE a.rank = 2
    GROUP BY a.player_id
)
SELECT ROUND(SUM(DATEDIFF(IFNULL(sd.event_date, fd.event_date), fd.event_date) = 1)/COUNT(DISTINCT(fd.player_id)), 2) AS fraction
FROM first_day fd
LEFT JOIN second_day sd ON fd.player_id = sd.player_id

