# Write your MySQL query statement below

WITH salary_category AS (
    SELECT *,
    CASE
        WHEN income < 20000 THEN 'Low Salary' 
        WHEN income >= 20000 AND income <= 50000 THEN 'Average Salary'
        WHEN income > 50000 THEN 'High Salary'
    END AS category
    FROM Accounts 
)
SELECT 'Low Salary' AS category, COUNT(account_id) AS accounts_count
FROM salary_category
WHERE category = 'Low Salary'
UNION
SELECT 'High Salary' AS category, COUNT(account_id) AS accounts_count
FROM salary_category
WHERE category = 'High Salary'
UNION
SELECT 'Average Salary' AS category, COUNT(account_id) AS accounts_count
FROM salary_category
WHERE category = 'Average Salary'