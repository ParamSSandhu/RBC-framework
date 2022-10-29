package com.automation.helpers;

import com.automation.properties.PropertiesLoader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static String generateFolderPath(String path) { // extentReports/extent-report.html

        String str = System.getProperty("user.dir") + File.separator + path;
        str = str + File.separator + new SimpleDateFormat("MMM-dd").format(new Date());
        str = str + File.separator + new SimpleDateFormat("hh-mm-ss").format(new Date());
        PropertiesLoader.extentReportPath = str;        //C://SeleniumAutomationUtils//Nov-28//11:01:00/ExtentReport.html
        return str;
    }
}
