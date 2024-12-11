package com.employer.service;

import com.employer.model.Employee;
import com.employer.result.TopEarningResults;

import java.util.List;

public interface EmployeeService {
    List<TopEarningResults> topTenEarnings(String department);
    Employee highestEarnings();
}
