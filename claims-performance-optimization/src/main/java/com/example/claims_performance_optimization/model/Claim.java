package com.example.claims_performance_optimization.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimantName;
    private String status;
    private LocalDate dateFiled;
    private Double amount;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClaimantName() { return claimantName; }
    public void setClaimantName(String claimantName) { this.claimantName = claimantName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDateFiled() { return dateFiled; }
    public void setDateFiled(LocalDate dateFiled) { this.dateFiled = dateFiled; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}

