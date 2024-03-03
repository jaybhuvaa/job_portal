package org.example.job_portal.service;


import org.example.job_portal.model.User;
import org.example.job_portal.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {
    @Autowired
    Userrepository userRepository;

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean deleteUser(User user){
        user = findByEmail(user.getEmail());
        userRepository.delete(user);
        return true;
    }

    public ResponseEntity verifyUser(User user){
        User check = userRepository.findByEmail(user.getEmail());
        if(check == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");

        if(check.getPassword().equals(user.getPassword()))
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credential is not matched");
    }
}
