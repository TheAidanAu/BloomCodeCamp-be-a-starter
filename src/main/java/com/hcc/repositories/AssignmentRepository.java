package com.hcc.repositories;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // JpaRepository provides the most common CRUD operations

    // A method signature for returning a list of assignment
    // which a user is working on
    List<Assignment> findByUser(User user);
}
