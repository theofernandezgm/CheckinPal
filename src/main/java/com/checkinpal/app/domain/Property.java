// src/main/java/com/checkinpal/app/domain/Property.java
package com.checkinpal.app.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Defines a many-to-one link (many properties can belong to one host)
    @JoinColumn(name = "host_id", nullable = false)
    private HostAccount host;

    @Column(nullable = false)
    private String address;

    @Column(name = "hut_number", nullable = false, unique = true)
    private String hutNumber;

    @Column(nullable = false)
    private int capacity;

    @Column(name = "documents_s3_key") // The key for the file in your MinIO bucket
    private String documentsS3Key;
}