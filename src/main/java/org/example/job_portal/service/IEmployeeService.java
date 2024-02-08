package org.example.job_portal.service;

import org.example.job_portal.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getEmployee();
    Employee updateEmployee(Employee employee , Long id);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
}
