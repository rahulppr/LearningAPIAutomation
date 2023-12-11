package org.example.Oct21.RestAssured.MISC.Jackson_API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ser {
    public static void main(String[] args) throws JsonProcessingException {


        Employee employeeObject = new Employee();
        employeeObject.setFirstName("Rahul");
        employeeObject.setLastName("Singh");
        employeeObject.setAge(31);
        employeeObject.setSalary(2467.78);
        employeeObject.setMarried(false);
        employeeObject.setGender("M");

        //Converting JAVA Object into json and it acts as payload

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeObject);
        System.out.println(jsonString);

    }
}
