package com.hcc.repositories;

import com.hcc.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides the most common CRUD operations
    Optional<User> findByUsername(String username);

}
