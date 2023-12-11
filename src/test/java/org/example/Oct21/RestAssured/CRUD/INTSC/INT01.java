package org.example.Oct21.RestAssured.CRUD.INTSC;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class INT01 {

    //Step 1 --> Get the Token.
    //Step 2 --> Create Booking and Get the ID.
    //Step 3 --> Update (Patch) the Booking with token and ID.
    //Step 4 --> Delete the Booking with ID.

@Test
    public void Int(){

    //Step 1 --> Get the Token.

        RequestSpecification r  = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");

        String payload = "\n" +
                "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r.contentType(ContentType.JSON);
        r.body(payload);

        Response response = r.when().post();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(200);

        //To Extract the Token

        String token = response.then().extract().path("token");
        System.out.println("Token "+token);

    //Step 2 --> Create Booking and Get the ID.

    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/booking");

    String payload_post = "{\n" +
            "    \"firstname\" : \"Rahul\",\n" +
            "    \"lastname\" : \"Singh\",\n" +
            "    \"totalprice\" : 1022,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-10-29\",\n" +
            "        \"checkout\" : \"2023-10-30\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Tea\"\n" +
            "}";

     r.contentType(ContentType.JSON);
     r.body(payload_post);

     response  = r.when().post();

     vr = response.then().log().all();
     vr.statusCode(200);

     //To extract the bookingId

    Integer bookingId = response.then().extract().path("bookingid");
    System.out.println("BookingId "+bookingId);

    //Step 3 --> Update (Patch) the Booking with token and ID.

    r.baseUri("https://restful-booker.herokuapp.com");

    String patch_payload = "\n" +
            "{\n" +
            "    \"firstname\" : \"Rahul\",\n" +
            "    \"lastname\" : \"King\",\n" +
            "    \"totalprice\" : 1022,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-10-29\",\n" +
            "        \"checkout\" : \"2023-10-30\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    r.basePath("booking/"+ bookingId);
    r.cookie("token",token);
    r.body(patch_payload);

    response = r.when().patch();
    vr = response.then().log().all();

    vr.statusCode(200);

    vr.body("lastname",Matchers.equalTo("King"));

    // Delete The Booking

    r.basePath("booking/"+bookingId);
    r.cookie("token",token);
    response = r.when().delete();
    vr = response.then().log().all();
    vr.statusCode(201);

    }
}


