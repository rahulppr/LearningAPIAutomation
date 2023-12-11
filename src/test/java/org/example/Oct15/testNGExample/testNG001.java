package org.example.Oct15.testNGExample;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class testNG001 {
    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
    }

   @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }

    @Test
    void Test1(){
        System.out.println("test 1");
        //Test Case
    }

    @Test
    void Test2(){
        System.out.println("test 2");
        //Test Case
    }

    @AfterMethod
    void demo6(){
        System.out.println("After Method");
    }

    @AfterSuite
    void demo5(){
        System.out.println("After Suite");
    }
}
