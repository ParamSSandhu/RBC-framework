package com.automation.browser;

import com.automation.properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {
   public static WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void loadDriver() {
        Browser browser = null;
        String path = "";
        if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome")) {
            browser = new Chrome();  //runtime Polymorphism
            path = PropertiesLoader.chromeDriverPath;

        } else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Edge")) {
            browser = new Edge();
            path = PropertiesLoader.edgeDriverPath;
        }

        browser.setHeadless(PropertiesLoader.headless);
        browser.setRemote(PropertiesLoader.remoteRun);
        browser.setMaximized(PropertiesLoader.maximizedMode);
        browser.setPageLoadTimeout(PropertiesLoader.pageLoadWaiTime);
        browser.setPreferences();
        WebDriver driver = browser.loadBrowser(path);
        setDriver(driver);
    }

    public void closeBrowser() {
        driver.close();

    }

    public void closeAllBrowser() {
        driver.quit();
    }
}
