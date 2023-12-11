package org.example.Oct21.RestAssured.MISC.POJO;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RA002_CRUD {

    @Test
    public void postRequest(){

        //        {
//            "firstname" : "Rahul",
//                "lastname" : "Singh",
//                "totalprice" : 1022,
//                "depositpaid" : true,
//                "bookingdates" : {
//            "checkin" : "2023-10-30",
//                    "checkout" : "2023-10-31"
//        },
//            "additionalneeds" : "Tea"
//        }

        //200
        //Class and Object - Best

        //Setting of Payload

        Booking booking = new Booking();
        booking.setFirstname("Rahul");
        booking.setLastname("Singh");
        booking.setTotalprice(1022);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Tea");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-11-23");
        bookingdates.setCheckout("2023-11-24");

        booking.setBookingdates(bookingdates);

        System.out.println(booking);

        Gson gson = new Gson();
        String bookingStringPayload = gson.toJson(booking);

        System.out.println("JSON Format"+bookingStringPayload);

        //------------------------------------------//


        //To get token
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

        System.out.println("Token--> "+token);


        //For Booking
        r.basePath("/booking");
        r.body(bookingStringPayload);
        response = r.when().post();
        vr = response.then().log().all();
        vr.statusCode(200);

        //To extract the ID

        Integer bookingid  = response.then().extract().path("bookingid");
        System.out.println("BookingID--> "+bookingid);

  //-------------------------------------//
        //Update//


        booking.setFirstname("Ravi");
        booking.setLastname("Jain");
        booking.setTotalprice(1022);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Tea");

        bookingdates.setCheckin("2023-11-23");
        bookingdates.setCheckout("2023-11-24");

        booking.setBookingdates(bookingdates);

        System.out.println(booking);

        r.basePath("booking/"+bookingid);
        r.cookie("token",token);
        r.body(booking);

        response = r.when().put();
        vr = response.then().log().all();

        //TC #1
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("Ravi"));

    }

}

//The above classes are re-usable for patch request and template is same
