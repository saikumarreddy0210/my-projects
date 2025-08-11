package com.example.claims_performance_optimization.repository;

import com.example.claims_performance_optimization.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}

