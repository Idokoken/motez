package com.ndgrouops.motez.service;

import com.ndgrouops.motez.dto.LoginDTO;
import com.ndgrouops.motez.model.Role;
import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.repository.RoleRepository;
import com.ndgrouops.motez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public User registerUser(String name, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new User(0, name, email, encodedPassword, authorities));

    }

    public LoginDTO loginUser(String email, String password) {
        try {
            Authentication auth  = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            String token  = tokenService.generateJwt(auth);
            return new LoginDTO(userRepository.findUserByEmail(email), token);
        }catch (AuthenticationException e){
            return new LoginDTO(null, "");
        }

    }

}
