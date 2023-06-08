package com.ndgrouops.motez.service;

import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.model.User;
import com.ndgrouops.motez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getOneUser(Integer id) {
        return userRepository.findById(id);
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> updateUser(User user) {
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

    public void deleteUser(Integer id) {
        Optional<User> optUser = userRepository.findById(id);
        userRepository.delete(optUser.get());
    }

}
