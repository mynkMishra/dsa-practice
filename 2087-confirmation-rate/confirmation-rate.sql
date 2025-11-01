# Write your MySQL query statement below

WITH con_tab AS (
    SELECT con.user_id, COUNT(*) as con_count 
    FROM Confirmations con
    WHERE con.action = "confirmed"
    GROUP BY con.user_id
),
total_tab AS (
    SELECT con.user_id, COUNT(*) as total_count 
    FROM Confirmations con
    GROUP BY con.user_id
)
SELECT si.user_id, IFNULL(ROUND(con_tab.con_count/total_tab.total_count, 2), 0) AS confirmation_rate
FROM Signups si
LEFT JOIN con_tab ON con_tab.user_id = si.user_id
LEFT JOIN total_tab ON total_tab.user_id = si.user_id




