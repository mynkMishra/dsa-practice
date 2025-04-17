# Write your MySQL query statement below


WITH start_time AS (
    SELECT a.machine_id, SUM(a.timestamp) AS start
    FROM Activity a
    WHERE a.activity_type = 'start'
    GROUP BY a.machine_id
), end_time AS (
    SELECT a.machine_id, SUM(a.timestamp) AS end
    FROM Activity a
    WHERE a.activity_type = 'end'
    GROUP BY a.machine_id
)
SELECT a.machine_id, ROUND((et.end - st.start)/(COUNT(a.process_id)/2), 3) AS processing_time
FROM Activity a
JOIN start_time st ON st.machine_id = a.machine_id
JOIN end_time et ON et.machine_id = a.machine_id
GROUP BY a.machine_id