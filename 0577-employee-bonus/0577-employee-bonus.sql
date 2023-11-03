# Write your MySQL query statement below
SELECT name, bonus FROM Employee Left JOIN Bonus ON Employee.empid = Bonus.empid
WHERE bonus < 1000 OR bonus IS NULL;