package com.employer.controller;

import com.employer.model.Employee;
import com.employer.result.TopEarningResults;
import com.employer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/topTen")
    public List<TopEarningResults> findTopTen(@RequestBody String department){
        List<TopEarningResults> topEarnings = employeeService.topTenEarnings(department);
        return topEarnings;
    }

    @GetMapping("/topEmployee")
    public Employee findTopEmployee(){
        Employee data = employeeService.highestEarnings();
        return data;
    }
}
