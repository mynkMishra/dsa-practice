# Write your MySQL query statement below

SELECT a.activity_date AS 'day', COUNT(DISTINCT(a.user_id)) AS active_users  
    FROM Activity a
    WHERE (a.activity_date > "2019-06-27" AND a.activity_date <= "2019-07-27")
    GROUP BY a.activity_date
