package org.example.Oct21.RestAssured.MISC.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RA_POJO {

    @Test
    public void authRequest(){
        RequestSpecification r = RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");

        Auth_Payload auth = new Auth_Payload();
        auth.setUsername("admin");
        auth.setPassword("password123");

        r.contentType(ContentType.JSON);

        Response response  =  r.when().body(auth).post();

        ValidatableResponse vr = response.then().log().all();

        vr.statusCode(200);

        //To extract the Token

        String token = response.then().extract().path("token");

        System.out.println("Token--> "+ token);
    }
}

