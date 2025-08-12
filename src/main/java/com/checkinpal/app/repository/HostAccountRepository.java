// src/main/java/com/checkinpal/app/repository/HostAccountRepository.java
package com.checkinpal.app.repository;

import com.checkinpal.app.domain.HostAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostAccountRepository extends JpaRepository<HostAccount, Long> {
}