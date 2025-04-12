# Write your MySQL query statement below
-- SELECT s.student_id, s.student_name, e.subject_name, COUNT(*) 
-- FROM Students s
-- RIGHT JOIN Examinations e ON s.student_id = e.student_id
-- RIGHT JOIN Subjects sb ON sb.subject_name = e.subject_name
-- GROUP BY s.student_id, s.student_name, e.subject_name
-- ORDER BY s.student_id, s.student_name;

SELECT st.student_id, st.student_name, sb.subject_name, COUNT(e.student_id) AS attended_exams 
FROM Subjects sb 
CROSS JOIN Students st
LEFT JOIN Examinations e ON st.student_id = e.student_id AND sb.subject_name = e.subject_name 
GROUP BY st.student_id, st.student_name, sb.subject_name
ORDER BY st.student_id, sb.subject_name;