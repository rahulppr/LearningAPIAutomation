package org.example.Oct21.RestAssured.MISC.JSONPath;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class RAJsonPath {

    public static void main(String[] args) {

        String response = "{\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"doe\",\n" +
                "    \"age\": 26,\n" +
                "    \"address\": {\n" +
                "        \"streetAddress\": \"naist street\",\n" +
                "        \"city\": \"Nara\",\n" +
                "        \"postalCode\": \"630-0192\"\n" +
                "    },\n" +
                "    \"phoneNumbers\": [\n" +
                "        {\n" +
                "            \"type\": \"iPhone\",\n" +
                "            \"number\": \"0123-4567-8888\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"home\",\n" +
                "            \"number\": \"0123-4567-8910\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JsonPath jsonPath = JsonPath.from(response);
        System.out.println(jsonPath.getString("firstName"));
        //Matchers - 5%
        System.out.println(jsonPath.getString("phoneNumbers[1].type"));


        //TestNG - 80%
        Assert.assertEquals(jsonPath.getString("firstName"),"John");

        //AssertJ - 15% - (automation 45%) - 10K Cases
        assertThat(jsonPath.getString("firstName")).isNotNull().isNotEmpty().isEqualTo("John");

    }
}


