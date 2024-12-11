CREATE TABLE employee (
    emp_id INTEGER NOT NULL,
    emp_name VARCHAR(255) NOT NULL,
    emp_salary DECIMAL(10, 2) NOT NULL,
    dep_id INTEGER NOT NULL,
    PRIMARY KEY (emp_id)
);

CREATE TABLE department (
    dep_id INTEGER NOT NULL,
    dep_name VARCHAR(255) NOT NULL,
    dep_desc VARCHAR(255) NOT NULL,
    PRIMARY KEY (dep_id)
);
