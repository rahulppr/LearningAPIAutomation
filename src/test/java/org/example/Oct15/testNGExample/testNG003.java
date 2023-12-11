package org.example.Oct15.testNGExample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testNG003 {

    @Test
    public void test1(){
        System.out.println("Test 1");

        //TestNG also do Verification
        //For Verification, we have to do, Assertion --> Expected Result == Actual Result

        //Two types of Assertion supported by the TestNG.

        //Soft Assertion
        //Hard Assertion

        //After making the Rest Assured call, you will get call
        //id=1,name="Rahul" with your expected result

        //Soft Assertion
        //Rest Assured
        String name = "rahul";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Rahul",name);
        System.out.println("Please execute me ");
        softAssert.assertAll();


        //Hard Assertion
//80% of the time we use Hard Assertion because we want to fail
// the testcase when something is not expected..

        Assert.assertEquals("Rahul",name,"Failed due to mismatch");
        System.out.println("End");
    }
}

//In Hard Asertion, the execution stops and the code/Test Case breaks.
//In Soft Assertion, the execution of the code or Test case never stops even we get the unexpected output.

