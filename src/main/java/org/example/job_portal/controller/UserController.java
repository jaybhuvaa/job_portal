package org.example.job_portal.controller;

import org.example.job_portal.model.User;
import org.example.job_portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity addUser(@RequestBody User user){
        user = userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity verifyUser(@RequestBody User user){
        return  userService.verifyUser(user);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteUser(@RequestBody User user){
        if(userService.deleteUser(user)){
            return ResponseEntity.ok("User Deleted Successfully");
        }else{
            return (ResponseEntity) ResponseEntity.notFound();
        }
    }
}