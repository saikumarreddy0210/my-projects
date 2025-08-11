package com.example.claims_performance_optimization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClaimsPerformanceOptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimsPerformanceOptimizationApplication.class, args);
	}

}
