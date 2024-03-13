package com.example.vkrestapi.repository;

import com.example.vkrestapi.dao.AuditingDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditingRepository extends JpaRepository<AuditingDAO,Integer> {
}
