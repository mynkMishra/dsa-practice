# Write your MySQL query statement below

WITH total AS(
    SELECT COUNT(user_id) AS t_count
    FROM Users
)
SELECT r.contest_id, ROUND((COUNT(r.user_id)/t.t_count)*100, 2) AS percentage
FROM Register r
CROSS JOIN total t
GROUP BY r.contest_id
ORDER BY percentage DESC, contest_id ASC;