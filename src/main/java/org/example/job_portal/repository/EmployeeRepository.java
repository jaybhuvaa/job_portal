package org.example.job_portal.repository;

import org.example.job_portal.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    @Query("SELECT employee FROM Employee employee WHERE employee.user.email = :email")
    List<Employee> findByUserId(@Param("email") String email);



}
