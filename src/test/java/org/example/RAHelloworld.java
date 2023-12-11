package org.example;
import io.restassured.RestAssured;

public class RAHelloworld {
    public static void main(String[] args) {
        //GET Request
        //Fetch URL


        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().statusCode(201);

        //Builder Pattern or Design Pattern

    }
}



