# Write your MySQL query statement below

WITH odd_ids AS (
    SELECT *, RANK() OVER(ORDER BY id ASC) AS 'rank'
    FROM Seat
    WHERE id%2 != 0
),
even_ids AS (
    SELECT *, RANK() OVER(ORDER BY id ASC) AS 'rank'
    FROM Seat
    WHERE id%2 = 0
),
swap_odd_ids AS (
    SELECT oi.id, IFNULL(ei.student, oi.student) AS 'student' 
    FROM odd_ids oi
    LEFT JOIN even_ids ei ON oi.rank = ei.rank
),
swap_even_ids AS (
    SELECT ei.id, oi.student 
    FROM even_ids ei
    LEFT JOIN odd_ids oi ON oi.rank = ei.rank
)
SELECT * FROM swap_odd_ids
UNION
SELECT * FROM swap_even_ids
ORDER BY id