package org.example.Oct22.testNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener2 implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started, Report to mother");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Fail TestCase");
        // Write a code to take a screenshot
        // Write a code to Email The Test Case Failure

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failed within success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test Fail with Timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finish");
    }
}

