package org.example.Oct21.RestAssured.MISC.SERIALI_DESER.CRUD;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.example.Oct21.RestAssured.MISC.SERIALI_DESER.Booking;

public class BookingResponseClass {

    @SerializedName("bookingid")
    @Expose
    private Integer bookingid;
    @SerializedName("booking")
    @Expose
    private org.example.Oct21.RestAssured.MISC.SERIALI_DESER.Booking booking;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public org.example.Oct21.RestAssured.MISC.SERIALI_DESER.Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}