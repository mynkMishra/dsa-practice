# Write your MySQL query statement below

WITH location AS (
    SELECT pid, tiv_2015, tiv_2016, 
    COUNT(CONCAT(lat,lon)) OVER(PARTITION BY CONCAT(lat,lon)) AS cnt1, 
    COUNT(tiv_2015) OVER(PARTITION BY tiv_2015) AS cnt
    FROM Insurance
)
SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM location
WHERE cnt1 = 1 AND cnt != 1