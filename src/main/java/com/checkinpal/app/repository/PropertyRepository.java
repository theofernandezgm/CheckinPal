// src/main/java/com/checkinpal/app/repository/PropertyRepository.java
package com.checkinpal.app.repository;

import com.checkinpal.app.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}