// src/main/java/com/checkinpal/app/domain/User.java
package com.checkinpal.app.domain;

import jakarta.persistence.*;
import lombok.Data; // From Lombok, for getters/setters/etc.

@Data
@Entity
@Table(name = "users") // This maps the class to the "users" table in your DB
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Hibernate the DB will generate this ID
    private Long id;

    @Column(nullable = false, unique = true) // Column constraints
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING) // Stores the enum as a readable string ("OWNER") instead of a number
    @Column(nullable = false)
    private Role role;
}