package org.example.Oct15.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RA001 {

    @Test(groups={"positive"},priority = 1)
    public void getRequest_Positive(){
        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().statusCode(201);
    }

    @Test(groups={"negative"},priority = 2)
    public void getRequest_Negative(){
        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void postRequest(){

        String payload =" {\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "}";

        //Payload can be passed in the form of String,Hashmap or Class
        //Post Request with BDD Style -- .Chaining().given().when().then()
        //Non-BDD Style


        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)

                .when().body(payload).post()

                .then().log().all().statusCode(200);

    }


}

//Make a POST Request
//To create a Token---> POST Request
//URL:- https://restful-booker.herokuapp.com/auth
//baseURI:- https://restful-booker.herokuapp.com
//basePath:- /auth

//  Payload

//  {
//    "username" : "admin",
//    "password" : "password123"
//}

//HTTP Method -- POST
//Content-Type--> Application/json


//Verify-- TC#1 -- Status Code ,
// TC#2 -- Token should not be null

