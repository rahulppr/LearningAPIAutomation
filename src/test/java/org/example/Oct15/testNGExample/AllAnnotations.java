package org.example.Oct15.testNGExample;

import org.testng.annotations.*;

public class AllAnnotations {


    /*
 Why Use Annotations?
 TestNG's  annotations boast the following benefits:

 i) Easy To Learn - The annotations are very easy to learn and execute. There is no predefined rule or format,
                      and the tester just needs to annotate methods using their judgment.
ii) Can Be Parameterized - Annotations can also be parameterized, just like any other method in Java.
iii) Strongly Typed- Annotations type strongly, and the errors can be encountered during the run time,
                      which saves time for the testers.
iv) No Need To Extend Any Class - While using the annotations, there is no need to extend any Test class like JUnit.
     */


    @BeforeSuite
    void demo1() {
        System.out.println("Before Suite");
        //Read data from Excel code here
    }

    @BeforeTest
    void demo2() {
        System.out.println("Before Test");
    }

    @BeforeClass
    void demo3() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    void demo4() {
        System.out.println("Before Method");
    }

    @Test
    void Test1() {
        System.out.println("test 1");
        //Test Case
    }

    @Test
    void Test2(){
        System.out.println("test 2");
        //Test Case
    }

    @AfterMethod
    void demo6() {
        System.out.println("After Method");
    }

    @AfterClass
    void demo7() {
        System.out.println("After Class");
    }

    @AfterTest
    void demo8() {
        System.out.println("After Test");
    }

    @AfterSuite
    void demo9() {
        System.out.println("After Suite");
        //Close the SQL Database here
    }
}
