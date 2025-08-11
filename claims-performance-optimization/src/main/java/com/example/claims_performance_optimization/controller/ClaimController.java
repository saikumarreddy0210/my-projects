package com.example.claims_performance_optimization.controller;

import com.example.claims_performance_optimization.model.Claim;
import com.example.claims_performance_optimization.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @GetMapping
    public Page<Claim> getClaims(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return claimService.getAllClaims(pageable);
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }
}

