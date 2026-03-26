package com.InsuranceApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.InsuranceApplication.DTO.Claim;

@Component
public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
