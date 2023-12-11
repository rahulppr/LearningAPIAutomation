package org.example.Oct22.testNG;

import org.testng.annotations.Test;

public class testNG001 {
    //Depends on TestNG

    @Test
    public void serverStartedOk(){
        System.out.println("I will Run First");
    }

    @Test(dependsOnMethods = {"serverStartedOk"})
    public void method1(){
        System.out.println("run Method 1");
    }

}
