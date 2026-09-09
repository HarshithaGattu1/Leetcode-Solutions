/* Write your T-SQL query statement below */
SELECT
    Visits.customer_id,
    count(Visits.visit_id) AS count_no_trans
FROM Visits
LEFT JOIN Transactions on Visits.visit_id = Transactions.visit_id
WHERE Transactions.visit_id IS NULL
GROUP BY Visits.customer_id