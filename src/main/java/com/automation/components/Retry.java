package com.automation.components;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry implements IRetryAnalyzer {
    private static final int MAX_RETRY = 2;
    private int retryCount = 0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                       //check if test not succeed
            if (retryCount < MAX_RETRY) { //1, 2, 3             Check if max try count is reached
                retryCount++;                                   //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);     //Mark test as failed
                return true;
            }                                                   //Tells TestNG to re-run the test
            else {
                iTestResult.setStatus(ITestResult.FAILURE);     //If maxCount reached, test marked as failed
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }         return false;
    }}
