package com.InsuranceApplication.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testClientGettersAndSetters() {
        Client client = new Client();
        
        client.setClientId(1);
        assertEquals(1, client.getClientId());
        
        client.setClientName("John Doe");
        assertEquals("John Doe", client.getClientName());
        
        client.setClientDateOfBirth("1990-01-01");
        assertEquals("1990-01-01", client.getClientDateOfBirth());
        
        client.setClientAddress("123 Main St");
        assertEquals("123 Main St", client.getClientAddress());
        
        client.setClientContactInformation("555-1234");
        assertEquals("555-1234", client.getClientContactInformation());
        
        InsurancePolicy policy = new InsurancePolicy();
        policy.setInsurancePolicyId(101);
        client.setInsurancePolicy(policy);
        assertEquals(policy, client.getInsurancePolicy());
        assertEquals(101, client.getInsurancePolicy().getInsurancePolicyId());
    }
}
