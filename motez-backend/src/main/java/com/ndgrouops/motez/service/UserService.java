package com.ndgrouops.motez.service;

import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        System.out.println("In the user details service");
        return userRepository.findUserByName(name).orElseThrow(
                () -> new UsernameNotFoundException("invalid email"));
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    };
    public Optional<User> getOneUser(Integer id){
        return userRepository.findById(id);
    }
    public Optional<User> updateUser(User user){
        Optional<User>optUser = userRepository.findById(user.getId());
        if(optUser.isPresent()) {
            User extUser = optUser.get();
            extUser.setUsername(user.getUsername());
            extUser.setEmail(user.getEmail());
            extUser.setPassword(user.getPassword());

            userRepository.save(extUser);
            return Optional.of(extUser);
        }
        return Optional.empty();
    }
    public void deleteUser(Integer id){
        Optional<User> user  = userRepository.findById(id);
        userRepository.delete(user.get());

    }


}
