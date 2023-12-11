package org.example.Oct21.RestAssured.MISC.SERIALI_DESER.CRUD;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.Oct21.RestAssured.MISC.POJO.Booking;
import org.example.Oct21.RestAssured.MISC.POJO.Bookingdates;
import org.example.Oct21.RestAssured.MISC.SERIALI_DESER.BookingResponseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class postRequest {

    public static void main(String[] args) {

        org.example.Oct21.RestAssured.MISC.POJO.Booking booking = new Booking();
        booking.setFirstname("Rahul");
        booking.setLastname("Singh");
        booking.setTotalprice(1022);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Tea");

        org.example.Oct21.RestAssured.MISC.POJO.Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-11-23");
        bookingdates.setCheckout("2023-11-24");

        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        String bookingStringPayload = gson.toJson(booking);
        System.out.println(bookingStringPayload);

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);

        Response response = r.when().body(bookingStringPayload).post();

        ValidatableResponse vr = response.then().log().all().statusCode(200);
        String responseString = response.asString();

        org.example.Oct21.RestAssured.MISC.SERIALI_DESER.BookingResponseClass bookingResponseClass = gson.fromJson(responseString, BookingResponseClass.class);
        System.out.println(bookingResponseClass.getBookingid());

        Assert.assertEquals(bookingResponseClass.getBooking().getFirstname(),"Rahul");
        Assert.assertEquals(bookingResponseClass.getBooking().getBookingdates().getCheckin(),"2023-11-23");

    }
}
