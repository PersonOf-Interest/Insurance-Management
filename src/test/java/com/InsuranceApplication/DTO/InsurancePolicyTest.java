package com.InsuranceApplication.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsurancePolicyTest {

    @Test
    public void testInsurancePolicyGettersAndSetters() {
        InsurancePolicy policy = new InsurancePolicy();
        
        policy.setInsurancePolicyId(101);
        assertEquals(101, policy.getInsurancePolicyId());
        
        policy.setInsurancePolicyNumber("POL98765");
        assertEquals("POL98765", policy.getInsurancePolicyNumber());
        
        policy.setInsurancePolicyType("Health");
        assertEquals("Health", policy.getInsurancePolicyType());
        
        policy.setInsurancePolicyCoverageAmount(500000L);
        assertEquals(500000L, policy.getInsurancePolicyCoverageAmount());
        
        policy.setInsurancePolicyPremium("1200.00");
        assertEquals("1200.00", policy.getInsurancePolicyPremium());
        
        policy.setInsurancePolicyStartDate("2023-01-01");
        assertEquals("2023-01-01", policy.getInsurancePolicyStartDate());
        
        policy.setInsurancePolicyEndDate("2023-12-31");
        assertEquals("2023-12-31", policy.getInsurancePolicyEndDate());
    }
}
