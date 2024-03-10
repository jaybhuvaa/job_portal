package org.example.job_portal.controller;

import lombok.RequiredArgsConstructor;
import org.example.job_portal.model.Employee;
import org.example.job_portal.model.User;
import org.example.job_portal.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeServices;
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<List<Employee>> getEmployees(@PathVariable String userId){
//        return new ResponseEntity<>(employeeServices.getEmployee(userId), HttpStatus.FOUND);
//    }
@GetMapping("/user/{userId}")
public ResponseEntity<List<Employee>> getEmployeesByUser(@PathVariable String userId) {
    List<Employee> employees = employeeServices.getEmployeesByUser(userId);
    return ResponseEntity.ok(employees);
}
    @PostMapping("/{user}")
    public Employee addEmployee(@RequestBody Employee employee, @PathVariable String user){
        return employeeServices.addEmployee(employee , user);
    }
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return employeeServices.updateEmployee(employee, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeServices.deleteEmployee(id);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeServices.getEmployeeById(id);
    }
}
