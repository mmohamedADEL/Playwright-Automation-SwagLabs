package Listeners;

import utilities.LogUtility;

public class ITestListenerClass implements org.testng.ITestListener {
    @Override
    public void onTestStart(org.testng.ITestResult result) {
        LogUtility.info("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(org.testng.ITestResult result) {
        LogUtility.info("Test passed: " + result.getName());
    }


    @Override
    public void onFinish(org.testng.ITestContext context) {
        LogUtility.info("All tests finished: " + context.getName());
    }
    @Override
    public void onTestSkipped(org.testng.ITestResult result) {
        LogUtility.info("Test skipped: " + result.getName());
    }
    @Override
    public void onTestFailure(org.testng.ITestResult result) {
        LogUtility.info("Test failed: " + result.getName());
    }




}
