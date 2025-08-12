// src/main/java/com/checkinpal/app/repository/UserRepository.java
package com.checkinpal.app.repository;

import com.checkinpal.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA will automatically provide methods like:
    // save(), findById(), findAll(), deleteById(), etc.
    // You can also define custom queries here later if needed.
}