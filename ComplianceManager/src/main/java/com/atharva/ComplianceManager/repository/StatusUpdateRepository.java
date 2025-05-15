package com.atharva.ComplianceManager.repository;

import com.atharva.ComplianceManager.entity.StatusUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusUpdateRepository extends JpaRepository<StatusUpdate, Long> {
}
