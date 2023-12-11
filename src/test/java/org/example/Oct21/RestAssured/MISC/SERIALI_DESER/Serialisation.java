package org.example.Oct21.RestAssured.MISC.SERIALI_DESER;

import com.google.gson.Gson;
import org.example.Oct21.RestAssured.MISC.POJO.Booking;
import org.example.Oct21.RestAssured.MISC.POJO.Bookingdates;

public class Serialisation {

    public static void main(String[] args) {

        //Serialisation--> Converting a JAVA Object to String
        // why we are using it because it is a light-weight mechanism

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

        Gson gson = new Gson();
        String bookingStringPayload = gson.toJson(booking);

        System.out.println(bookingStringPayload);
    }
}
