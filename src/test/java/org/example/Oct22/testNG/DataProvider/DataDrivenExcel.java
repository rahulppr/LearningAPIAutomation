package org.example.Oct22.testNG.DataProvider;


import org.testng.annotations.Test;

public class DataDrivenExcel {

    @Test(dataProvider="getData",dataProviderClass = UtilExcel.class)
    public void testLoginData(String username,String password){
        System.out.println("Username -- "+username);
        System.out.println("Password -- "+password);
    }
}

