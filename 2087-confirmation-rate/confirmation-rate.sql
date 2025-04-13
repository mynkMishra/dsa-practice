# Write your MySQL query statement below

WITH con AS (
    SELECT user_id, COUNT(user_id) AS num
    FROM Confirmations
    WHERE action = "confirmed"
    GROUP BY user_id, action),
tot AS (
    SELECT user_id, COUNT(user_id) AS des
    FROM Confirmations
    GROUP BY user_id)
SELECT s.user_id, ROUND(IFNULL((con.num/tot.des), 0), 2) AS confirmation_rate
FROM Signups s
LEFT JOIN con ON con.user_id = s.user_id
LEFT JOIN tot ON tot.user_id = s.user_id;