package org.example.Oct21.RestAssured.MISC.Jackson_API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deser {

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
        System.out.println(employee.getFirstName());

    }
}
