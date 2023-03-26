package com.automation.helpers;

import com.automation.components.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
public class TestAsserts {

    public static void checkIfValuesAreEqual(String value1, String value2) {
        try {
            Assert.assertEquals(value1, value2, "Value [" + value1 + "] and Value2 [" + value2 + "] are not equal");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Value [" + value1 + "] is displayed");
        }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL,"Value ["+value1+"] is not displayed");

        }
    }

    public static void checkIfContains(String valueToCheck, String value) {
        try {
            Assert.assertTrue(value.contains(valueToCheck), "Value[" + value + "] not found in String [" + valueToCheck + "]");
            ExtentTestManager.getTest().log(LogStatus.PASS,value+"contains"+valueToCheck);
        }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL,value+"does not contains"+valueToCheck);

        }
    }
}
