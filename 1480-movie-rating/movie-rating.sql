# Write your MySQL query statement below

WITH movie_reviewers AS (
    SELECT mr.user_id, u.name, COUNT(mr.movie_id) AS review_count
    FROM MovieRating mr
    LEFT JOIN Users u ON mr.user_id = u.user_id
    GROUP BY mr.user_id, u.name
),
highest_movie_reviewer AS (
    SELECT mr.name
    FROM movie_reviewers mr
    ORDER BY mr.review_count DESC, mr.name ASC
    LIMIT 1
),
avg_movie_rating AS (
    SELECT m.movie_id, m.title, AVG(mr.rating) AS avg_rating
    FROM MovieRating mr
    LEFT JOIN Movies m ON mr.movie_id = m.movie_id
    WHERE MONTH(mr.created_at) = 2 AND YEAR(mr.created_at) = 2020
    GROUP BY m.movie_id, m.title
),
highest_movie_rating AS (
    SELECT amr.title
    FROM avg_movie_rating amr
    ORDER BY amr.avg_rating DESC, amr.title ASC
    LIMIT 1
)
SELECT name AS results FROM highest_movie_reviewer
UNION ALL
SELECT title AS results FROM highest_movie_rating



