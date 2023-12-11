package org.example.Oct21.RestAssured.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RA_POST_BDD_STYLE {

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


