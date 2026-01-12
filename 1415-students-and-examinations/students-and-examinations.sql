# Write your MySQL query statement below

WITH C1 AS (
    SELECT *
    FROM Students st 
    CROSS JOIN Subjects sb
),
C2 AS (
    SELECT ex.student_id, ex.subject_name, COUNT(*) AS attended_exams
    FROM Examinations ex
    GROUP BY ex.student_id, ex.subject_name
)
SELECT a.student_id, a.student_name, a.subject_name, IFNULL(b.attended_exams, 0) AS attended_exams
FROM C1 a
LEFT JOIN C2 b ON a.student_id = b.student_id AND a.subject_name = b.subject_name
ORDER BY a.student_id, a.subject_name
