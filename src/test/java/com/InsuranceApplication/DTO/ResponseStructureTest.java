package com.InsuranceApplication.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseStructureTest {

    @Test
    public void testResponseStructureGettersAndSetters() {
        ResponseStructure<String> response = new ResponseStructure<>();
        
        response.setStatusCode(200);
        assertEquals(200, response.getStatusCode());
        
        response.setMsg("Success");
        assertEquals("Success", response.getMsg());
        
        response.setData("Test Data");
        assertEquals("Test Data", response.getData());
    }
}
