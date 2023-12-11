package org.example.Oct21.RestAssured.MISC.SERIALI_DESER;

import com.google.gson.Gson;

public class De_Serialisation {
    public static void main(String[] args) {

        String bookingResponse = "{\n" +
                "    \"bookingid\": 425,\n" +
                "    \"booking\": {\n" +
                "        \"firstname\": \"Rahul\",\n" +
                "        \"lastname\": \"Singh\",\n" +
                "        \"totalprice\": 1022,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2023-10-30\",\n" +
                "            \"checkout\": \"2023-10-31\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Tea\"\n" +
                "    }\n" +
                "}";

        Gson gson = new Gson();
        BookingResponseClass bookingresponse = gson.fromJson(bookingResponse, BookingResponseClass.class);
        System.out.println(bookingresponse.getBookingid());
        System.out.println(bookingresponse.getBooking().getFirstname());

    }
}
