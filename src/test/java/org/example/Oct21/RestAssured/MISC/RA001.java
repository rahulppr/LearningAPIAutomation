package org.example.Oct21.RestAssured.MISC;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RA001 {

    @Test
    public void postRequest(){

        //RA tells keep your payload in three ways to manage test case
        //1. String Format < 20 Test Case
        //2. Hashmap -? 100-200 Test Case suitable

        //JSON-Map?
        //3. Classes and Object -Best way > 200 Test Case

//        HashMap h = new HashMap();
//        h.put("name","Rahul");
//        System.out.println(h);

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

      Map <String,Object> jsonBodyusingmap = new LinkedHashMap();
      jsonBodyusingmap.put("firstname","Rahul");
      jsonBodyusingmap.put("lastname","Singh");
      jsonBodyusingmap.put("totalprice",121);
      jsonBodyusingmap.put("depositpaid",true);
      jsonBodyusingmap.put("additionalneeds","Lunch");

      Map<String,Object> bookingDatesMap = new LinkedHashMap();
      bookingDatesMap.put("checkin","2023-07-23");
      bookingDatesMap.put("checkout","2023-11-24");

      jsonBodyusingmap.put("bookingdates",bookingDatesMap);

      System.out.println(jsonBodyusingmap);

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .when().body(jsonBodyusingmap).post()
                .then().log().all().statusCode(200);

    }
}
//We cannot directly use LikedHashmap in the RA. W e have to implement gson,jackson in the classpath.

//Hashmap converted by gson into inputstream.
