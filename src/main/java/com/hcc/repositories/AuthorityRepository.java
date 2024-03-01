package com.hcc.repositories;

import com.hcc.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    // JpaRepository provides the most common CRUD operations

}
