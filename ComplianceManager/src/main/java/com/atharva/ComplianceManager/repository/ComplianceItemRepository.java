package com.atharva.ComplianceManager.repository;

import com.atharva.ComplianceManager.entity.ComplianceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceItemRepository extends JpaRepository<ComplianceItem, Long> {
}
