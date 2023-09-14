package com.ndgrouops.motez.repository;

import com.ndgrouops.motez.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
    Optional<User> findUserByName(String name);
}
