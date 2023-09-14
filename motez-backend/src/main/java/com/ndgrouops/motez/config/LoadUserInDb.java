package com.ndgrouops.motez.config;

import com.ndgrouops.motez.model.Role;
import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.repository.RoleRepository;
import com.ndgrouops.motez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@Component
@Transactional
public class LoadUserInDb implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception{
        if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
        Role adminRole  =  roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("USER"));

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);

        User admin = new User(1,"admin","nd@gmail.com", passwordEncoder.encode("password"), roles);
        userRepository.save(admin);

    }


}
