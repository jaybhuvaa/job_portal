package org.example.job_portal.repository;


import org.example.job_portal.model.Employee;
import org.example.job_portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {

    @Query("select user from User user where user.email = ?1")
    User findByEmail(@Param("email") String email);


}