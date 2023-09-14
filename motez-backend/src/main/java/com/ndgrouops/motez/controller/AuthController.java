package com.ndgrouops.motez.controller;

import com.ndgrouops.motez.dto.LoginDTO;
import com.ndgrouops.motez.dto.RegistrationDTO;
import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.service.AuthenticationService;
import com.ndgrouops.motez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDTO userDTO, Errors errors) {
        User existingUser = userService.findUserByEmail(userDTO.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            errors.rejectValue("email", null,
                    "Email already in use");
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if(errors.hasErrors()){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        User newUser  = authenticationService.registerUser(userDTO.getName(),userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody RegistrationDTO userDTO) {
        LoginDTO user = authenticationService.loginUser(userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<LoginDTO>(user, HttpStatus.CREATED);
    }

    //logout route
    @PostMapping("/logout")
    public String logout() {
        return "redirect:/auth/login?logout";
    }

}
