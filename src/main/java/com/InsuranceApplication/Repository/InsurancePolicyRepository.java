package com.InsuranceApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.InsuranceApplication.DTO.InsurancePolicy;

@Component
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>{

}
