package com.employer.serviceImp;

import com.employer.model.Employee;
import com.employer.result.TopEarningResults;
import com.employer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<TopEarningResults> topTenEarnings(String department) {
        //TODO: verify department
        String sql = "SELECT emp_id AS id, emp_name AS name, emp_salary AS salary, d.dep_name AS departmentName FROM employee e JOIN department d ON e.dep_id = d.dep_id " +
               "WHERE d.dep_name = :departmentName " +
               "ORDER BY e.emp_salary DESC " +
               "LIMIT 10";

        // Using MapSqlParameterSource to set parameters dynamically
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("departmentName", department);

        List<TopEarningResults>  topEarnings = jdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<>(TopEarningResults.class));
        return topEarnings;
    }

    @Override
    public Employee highestEarnings() {
        //TODO: if there are 2 top earners
        String sql = "Select top 1 * from employee order by emp_salary";
        Employee topEmployee = new Employee();
        jdbcTemplate.query(sql, (RowCallbackHandler) rs -> {
            topEmployee.setEmployeeId(rs.getInt("emp_id"));
            topEmployee.setName(rs.getString("emp_name"));
            topEmployee.setSalary(rs.getInt("emp_salary"));
            topEmployee.setDeptId(rs.getInt("dep_id"));
        });

        return topEmployee;
    }
}
