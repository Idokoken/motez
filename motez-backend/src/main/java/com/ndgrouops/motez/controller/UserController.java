package com.ndgrouops.motez.controller;

import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<User> getOneUser(@PathVariable Integer id) {
        Optional<User> optUser = userService.getOneUser(id);
        return new ResponseEntity<User>(optUser.get(), HttpStatus.OK);
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

}
