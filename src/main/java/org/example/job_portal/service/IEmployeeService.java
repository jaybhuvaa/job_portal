package org.example.job_portal.service;

import org.example.job_portal.model.Employee;
import org.example.job_portal.model.User;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee, String userId);
    List<Employee> getEmployeesByUser(String userId);

    Employee updateEmployee(Employee employee , Long id);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
}
