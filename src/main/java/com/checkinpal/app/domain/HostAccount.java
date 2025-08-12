// src/main/java/com/checkinpal/app/domain/HostAccount.java
package com.checkinpal.app.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "host_account")
public class HostAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY) // Defines a one-to-one link between HostAccount and User
    @JoinColumn(name = "owner_user_id", nullable = false) // Specifies the foreign key column
    private User owner;

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(nullable = false, unique = true)
    private String nif;
}