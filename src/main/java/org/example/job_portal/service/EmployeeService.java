package org.example.job_portal.service;

import lombok.RequiredArgsConstructor;
import org.example.job_portal.Exception.EmployeeAlreadyExistsException;
import org.example.job_portal.Exception.employeeNotFound;
import org.example.job_portal.model.Employee;
import org.example.job_portal.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeAlreadyExists(employee.getEmail())) {
            throw new EmployeeAlreadyExistsException(employee.getEmail() + " already exists!");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        return employeeRepository.findById(id).map(st -> {
            st.setFirstName(employee.getFirstName());
            st.setLastName(employee.getLastName());
            st.setEmail(employee.getEmail());
            st.setDepartment(employee.getDepartment());
            st.setDescription(employee.getDescription());
            return employeeRepository.save(st);

        }).orElseThrow(() -> new employeeNotFound("Sorry, this employee could not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new employeeNotFound("Sorry, this employee could not found");
        }
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new employeeNotFound("Sorry, employee with "+id+" could not found"));
    }

    private boolean employeeAlreadyExists(String email) {
        return employeeRepository.findByEmail(email).isPresent();
    }
}
