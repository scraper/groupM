--second highest salary
SELECT max(salary)
FROM salary
WHERE salary < (
		SELECT max(salary)
		FROM salary
		)

--second last lowest salary
SELECT min(salary)
FROM salary
WHERE salary > (
		SELECT min(salary)
		FROM salary
		)

--Give me average salary of a each Department
SELECT e.dep_id
	,avg(s.salary) AS average_salary
FROM employee e
INNER JOIN salary s ON s.emp_id = e.emp_id
GROUP BY e.dep_id

--Give me employees which doesn’t belong to any Department 
SELECT e.emp_id
	,e.emp_name
	,e.dep_id
	,s.salary
FROM employee e
INNER JOIN salary s ON s.emp_id = e.emp_id
WHERE e.dep_id IS NULL

--Give me employees which doesn’t have manager 
SELECT e.emp_id
	,e.emp_name
	,e.dep_id
	,s.salary
FROM employee e
INNER JOIN salary s ON s.emp_id = e.emp_id
WHERE e.manager_emp_id IS NULL
	OR e.manager_emp_id = e.emp_id
