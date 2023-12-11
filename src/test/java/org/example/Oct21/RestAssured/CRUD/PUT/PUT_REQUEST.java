package org.example.Oct21.RestAssured.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Oct21.RestAssured.MISC.POJO.Auth_Payload;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class PUT_REQUEST {

    //Make a POST Request to get ID.
    //Create a Token
    //PUT Request to update the data and Verify


    @Test
    public void putRequest(){

        //Step 1:--->  Create the token and get the Token

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");

//        String payloadAuth = " {\n" +
//                "                \"username\" : \"admin\",\n" +
//                "                \"password\" : \"password123\"\n" +
//                "}";

// We can also use class and Objects technique to get token in BDD Style

        Auth_Payload auth = new Auth_Payload();
        auth.setUsername("admin");
        auth.setPassword("password123");

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth");


        r.contentType(ContentType.JSON);
        r.body(auth);

        Response response  =  r.when().post();

        ValidatableResponse vr = response.then().log().all();

        vr.statusCode(200);

       //To extract the Token

        String token = response.then().extract().path("token");

        System.out.println("Token--> "+token);

        //Step 2---->  Create a (POST) Booking Request and Get ID.

        String payload_post = "{\n" +
                "    \"firstname\" : \"Rahul\",\n" +
                "    \"lastname\" : \"Singh\",\n" +
                "    \"totalprice\" : 1022,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2023-10-25\",\n" +
                "        \"checkout\" : \"2023-10-26\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Tea\"\n" +
                "}";

        r.basePath("/booking");
        r.body(payload_post);
        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);

        //To extract the ID

        Integer bookingid  = response.then().extract().path("bookingid");
        System.out.println("BookingID--> "+bookingid);


        //Step 3:-
        //Token and ID.
        //Change the name to James in PUT Request and Verify it
        //name=James

        String payload_putRequest = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 1022,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2023-10-29\",\n" +
                "        \"checkout\" : \"2023-10-30\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r.basePath("booking/"+bookingid);
        r.cookie("token",token);
        r.body(payload_putRequest);

        response = r.when().put();
        vr = response.then().log().all();

        //TC #1
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("James"));

        // delete
        r.basePath("booking/"+bookingid);
        r.cookie("token",token);
        response = r.when().delete();
        vr = response.then().log().all();
        vr.statusCode(201);
    }
}
