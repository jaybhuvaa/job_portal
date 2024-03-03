package org.example.job_portal.service;


import org.example.job_portal.model.User;
import org.example.job_portal.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
