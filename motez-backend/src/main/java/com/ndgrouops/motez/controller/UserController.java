package com.ndgrouops.motez.controller;

import com.ndgrouops.motez.exception.UserNotFoundException;
import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getOneUser(@PathVariable Integer id) {
//        Optional<User> optUser = userService.getOneUser(id);
//        return new ResponseEntity<User>(optUser.get(), HttpStatus.OK);
//    }
    @GetMapping("/{id}")
    public User getOneUser(@PathVariable Integer id) {
        return userService.getOneUser(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        List<User> allUsers = userService.getAllUser();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }
    @PutMapping("/edit")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> newUser = userService.updateUser(user);
        return new ResponseEntity<User>(newUser.get(), HttpStatus.NOT_FOUND);
    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
//        if(!userService.getOneUser(id)){
//            throw new UserNotFoundException(id);
//        }
        userService.deleteUser(id);
        return "user with " + id + " has been deleted successfully";
    }

}
