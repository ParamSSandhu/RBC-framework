package com.automation.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class PropertiesLoader {

    public static Properties configsProperties;
    public static String extentReportPath;
    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String ieDriverPath;
    public static String edgeDriverPath;
    public static String firefoxDriverPath;
    public static Boolean maximizedMode;
    public static Integer implicitWaitTime;
    public static Integer pageLoadWaitTime;
    public static Integer explicitWaitTime;
    public static Integer pollingWait;
    public static boolean headless;
    public static boolean deleteCookies;
    public static boolean remoteRun;
    public static String URL;
    public static String environment;

    public static void initializeProperties() throws Exception {
        if (configsProperties == null) {
            configsProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config-"+PropertiesLoader.environment+".properties");
            //user.dir finds the path of the directory.
            System.out.println("Environment Initialized: " + environment);
            configsProperties.load(fileInputStream);
        }

        runOnBrowser = configsProperties.getProperty("RunOnBrowser");
        takeScreenshot = Boolean.valueOf(configsProperties.getProperty("TakeScreenshot"));
        chromeDriverPath = configsProperties.getProperty("ChromeDriverPath");
        ieDriverPath = configsProperties.getProperty("IEDriverPath");
        edgeDriverPath = configsProperties.getProperty("EdgeDriverPath");
        firefoxDriverPath = configsProperties.getProperty("FirefoxDriverPath");
        maximizedMode = Boolean.valueOf(configsProperties.getProperty("MaximizeMode"));
        implicitWaitTime = Integer.valueOf(configsProperties.getProperty("ImplicitWait"));
        pageLoadWaitTime = Integer.valueOf(configsProperties.getProperty("PageLoadWaiTime"));
        explicitWaitTime = Integer.valueOf(configsProperties.getProperty("ExplicitWaitTime"));
        pollingWait = Integer.valueOf(configsProperties.getProperty("PollingWait"));
        headless = Boolean.parseBoolean(configsProperties.getProperty("headless"));
        deleteCookies = Boolean.parseBoolean(configsProperties.getProperty("deleteCookies"));
        remoteRun = Boolean.parseBoolean(configsProperties.getProperty("remoteRun"));
        URL = configsProperties.getProperty("URL");
        if (environment.isEmpty())
           environment = "stg";
    }
}
