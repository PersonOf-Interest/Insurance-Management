package com.InsuranceApplication.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClaimTest {

    @Test
    public void testClaimGettersAndSetters() {
        Claim claim = new Claim();
        
        claim.setClaimId(1);
        assertEquals(1, claim.getClaimId());
        
        claim.setClaimNumber("CLM12345");
        assertEquals("CLM12345", claim.getClaimNumber());
        
        claim.setClaimDescription("Car accident");
        assertEquals("Car accident", claim.getClaimDescription());
        
        claim.setClaimDate("2023-10-27");
        assertEquals("2023-10-27", claim.getClaimDate());
        
        claim.setClaimStatus("Pending");
        assertEquals("Pending", claim.getClaimStatus());
        
        InsurancePolicy policy = new InsurancePolicy();
        policy.setInsurancePolicyId(101);
        claim.setInsurancePolicy(policy);
        assertEquals(policy, claim.getInsurancePolicy());
        assertEquals(101, claim.getInsurancePolicy().getInsurancePolicyId());
    }
}
