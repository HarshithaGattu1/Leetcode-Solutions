/* Write your T-SQL query statement below */
SELECT
    query_name,
    ROUND(AVG(CAST(rating AS FLOAT)/position),2) AS quality,
    ROUND((SUM(
        CASE 
            WHEN rating < 3 THEN 1
            ELSE 0
        END
    ) / CAST(COUNT(*) AS FLOAT))*100,2) AS poor_query_percentage
FROM queries
GROUP BY query_name
