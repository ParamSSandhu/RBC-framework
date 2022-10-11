package com.automation.components;

import com.automation.browser.DriverManager;
import com.automation.properties.PropertiesLoader;
import com.automation.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import javax.naming.ConfigurationException;
import java.io.IOException;
import java.sql.Driver;

public class TestActions {
    public WebDriver driver;
    public DriverManager driverManager;

    public BaseActions pageActions;

    @BeforeSuite
    public void setUpConfigurations() throws Exception {

        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
    }

    @BeforeMethod
    public void setupBrowser() throws InterruptedException {
        driverManager = new DriverManager();
        driverManager.loadDriver();
        driver = driverManager.getDriver();
        pageActions = new BaseActions(driver);
        Thread.sleep(3000);
        pageActions.launchUrl(PropertiesLoader.URL);
    }

    @AfterMethod
    public void testDownBrowser() {

        driverManager.closeBrowser();
    }

    @AfterSuite
    public void teardownObjects() {
        PropertiesLoader.configsProperties = null;

    }



}
