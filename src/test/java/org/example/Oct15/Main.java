package org.example.Oct15;

public class Main {
    public static void main(String[] args) {

        //Rest Assured --> which helps you to make the HTTP Request + Verify it.
        //TestNG--> To manage our test cases -- Testing Framework.
        //Allure Report --> Report Purpose
        //Maven--> Build and Dependency Management & Taking care of our project

        //Rest Assured --> BDD Syntax --> Given -->When -->Then
        //Pattern--> Builder Pattern ? It follows Builder Pattern


        NonBuilderPattern nonBuilderPattern = new NonBuilderPattern();
        nonBuilderPattern.groundfloor();
        nonBuilderPattern.firstfloor();
        nonBuilderPattern.secondfloor();


        BuilderPattern bp = new BuilderPattern();
        bp.groundfloor().firstfloor().secondfloor(); //function chaining


    }
}
