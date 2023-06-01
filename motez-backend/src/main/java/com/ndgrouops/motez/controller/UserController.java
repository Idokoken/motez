package com.ndgrouops.motez.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("/")
public class UserController {

    public interface UserDetails extends Serializable {

    }
    public interface UserDetailsService {

    }

    @GetMapping
    public String getLogin() {
        return "welcome to login Page";
    }


}
