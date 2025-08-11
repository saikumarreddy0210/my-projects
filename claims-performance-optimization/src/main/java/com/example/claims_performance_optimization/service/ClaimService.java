package com.example.claims_performance_optimization.service;

import com.example.claims_performance_optimization.model.Claim;
import com.example.claims_performance_optimization.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    @Cacheable(value = "claims", key = "#pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<Claim> getAllClaims(Pageable pageable) {
        return claimRepository.findAll(pageable);
    }

    public Claim getClaimById(Long id) {
        return claimRepository.findById(id).orElse(null);
    }
}

