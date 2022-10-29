package com.automation.components;

import com.automation.browser.DriverManager;
import com.automation.properties.PropertiesLoader;
import com.automation.properties.PropertiesValidator;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.internal.IResultListener;

import java.lang.reflect.Method;


public class TestActions implements ITestListener {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // public WebDriver driver;
    public DriverManager driverManager;
    public BaseActions pageActions;
    @BeforeSuite
    public void setUpConfigurations() throws Exception {
        ExtentReporter.getReporter();
        PropertiesLoader.environment = System.getProperty("envName");
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }
    @BeforeMethod
    public void setupBrowser(Method methodName) throws InterruptedException {
        ExtentTestManager.startTest(methodName.getName(),"");
        driverManager.loadDriver();
        //driver = driverManager.getDriver();
        driver.set(driverManager.getDriver());
        pageActions = new BaseActions(driver.get());
        pageActions.launchUrl(PropertiesLoader.URL);
    }
    @AfterMethod
    public void testDownBrowser() {
        driverManager.closeBrowser();
        ExtentTestManager.stopTest();
    }

    @AfterSuite
    public void teardownObjects() {
        PropertiesLoader.configsProperties = null;
        ExtentReporter.getReporter().flush();
        ExtentReporter.getReporter().close();
        }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(getTestMethodName(result), "");
        ExtentTestManager.getTest().setDescription(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        try {
            String base64 = BaseActions.captureSnapshot(getTestMethodName(result),
                    driver.get());
            ExtentTestManager.getTest().log(LogStatus.PASS,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } catch (Exception e) {
        }
    }
    public void onTestFailure(ITestResult result) {
        try {
            String base64 = BaseActions.captureSnapshot(getTestMethodName(result),
                    driver.get());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
            ExtentTestManager.getTest().log(LogStatus.FAIL,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
        } catch (Exception e) {
        }
    }
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test SKIPPED");
    }

    public void onFinish(ITestContext context) {
        ExtentReporter.getReporter().flush();
    }
}
