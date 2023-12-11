package org.example.Oct15.testNGExample;
import org.testng.annotations.Test;

public class testNG004 {

    @Test (groups={"smoke","QA","login"})
    public void Test1(){
        System.out.println("T1-Smoke/QA/login");
    }

@Test (groups={"PreProd","login"})
    public void Test2(){
        System.out.println("T2-Smoke/PreProd/Login");
    }

@Test (groups = {"reg"})
    public void Test3(){
        System.out.println("T3-Regression");
    }
}


//Why we need Grouping?
//To manage our Test Case.
