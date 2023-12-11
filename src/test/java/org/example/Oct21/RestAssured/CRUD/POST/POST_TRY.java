package org.example.Oct21.RestAssured.CRUD.POST;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POST_TRY {
    @Test
    public void postRequest1(){

       // 1. To make a Post Request to get Token

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response = requestSpecification.when().post();


        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

        //To extract the token
        String token = response.then().extract().path("token");

        System.out.println("Token--> "+token);
    }

    @Test
    public void postRequest2(){

        //To make a POST Request to get ID

        String payloadpost = "{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Singh\",\n" +
                "    \"totalprice\" : 102,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2023-11-22\",\n" +
                "        \"checkout\" : \"2023-11-23\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Tea\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");

        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payloadpost);

       Response response = requestSpecification.when().post();

       ValidatableResponse vr = response.then().log().all();

       //To extract the ID

        Integer BookingID = response.then().extract().path("bookingid");
        System.out.println("Booking ID-->"+BookingID );

    }



}
