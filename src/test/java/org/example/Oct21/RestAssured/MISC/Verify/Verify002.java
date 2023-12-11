package org.example.Oct21.RestAssured.MISC.Verify;
import static org.assertj.core.api.Assertions.*;
//import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Oct21.RestAssured.MISC.Jackson_API.Employee;

public class Verify002 {

    public static void main(String[] args) throws JsonProcessingException {

        String jsonString  = "{\n" +
                "  \"firstName\" : \"Rahul\",\n" +
                "  \"lastName\" : \"Singh\",\n" +
                "  \"gender\" : \"M\",\n" +
                "  \"age\" : 31,\n" +
                "  \"salary\" : 2467.78,\n" +
                "  \"married\" : false\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(jsonString,Employee.class);

        //employee-- firstname should be Rahul ,not be null and should be a String
       // Assert.assertEquals("Rahul",employee.getFirstName()); //This asset does not give null.limitation

        //AssertJ -- 20%, until your test case does not have more than 2000
        assertThat(employee.getFirstName()).isEqualTo("Rahul").isNotEmpty();
        System.out.println(employee.getFirstName());
    }
}
