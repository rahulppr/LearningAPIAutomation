package org.example.Oct21.RestAssured.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RA_POST_Non_BDD_STYLE {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    ValidatableResponse validatableresponse;

    //Builder Pattern is a style , it's a way of introducing Feature files.

    @BeforeTest
    public void prePostRequestCode(){
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
    }


    public void postRequest(){

        String payload =" {\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "}";

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


        //Payload can be passed in the form of String,Hashmap or Class
        //Post Request with BDD Style -- .Chaining().given().when().then()


        //Non-BDD Style

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(payload);

        requestSpecification.when().post();

        Response response  =  requestSpecification.when().post();


        // <----- Verification--Status Code and Token ---->


        String responseString = response.asString();

        System.out.println(responseString);

        ValidatableResponse validatableresponse = response.then();

        validatableresponse.statusCode(200);

        //In non-BDD Style, there are 3 interface specification ,
        // RequestSpecification for preparation part
        //Response for Requesting Part
        //ValidatableResponse for Validation Part
    }

    @Test
    public void PostRequest1(){

        String payload =" {\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(payload);
        response =  requestSpecification.when().post();


        // <----- Verification--Status Code and Token ---->

        String responseString = response.asString();
        System.out.println(responseString);

        validatableresponse = response.then();
        validatableresponse.statusCode(200);

    }


    @Test
    public void PostRequest2(){

        String payload =" {\n" +
                "                \"username\" : \"admin\",\n" +
                "                \"password\" : \"password123\"\n" +
                "}";

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(payload);
        response =  requestSpecification.when().post();

        // <----- Verification--Status Code and Token ---->

        String responseString = response.asString();
        System.out.println(responseString);

        validatableresponse = response.then();
        validatableresponse.statusCode(200);

    }

}



