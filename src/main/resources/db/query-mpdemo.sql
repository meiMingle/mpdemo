SELECT
    e.*
FROM
    employees e
        LEFT JOIN dept_emp de ON e.emp_no = de.emp_no
        LEFT JOIN departments d ON de.dept_no = d.dept_no
where d.dept_name = 'Development';