package com.automation.components;

import com.automation.helpers.StringUtils;
import com.automation.properties.PropertiesLoader;
import com.relevantcodes.extentreports.ExtentReports;


import java.io.File;

public class ExtentReporter {
    private static ExtentReports suiteReport;
    public static synchronized ExtentReports getReporter() {

        try {
            //PropertiesLoader.initializeProperties();
            if (suiteReport == null) {
                String extentReportPath = "extentReports";
                extentReportPath = StringUtils.generateFolderPath(extentReportPath);
                File f = new File(extentReportPath);
                if (!f.isDirectory()) {
                    f.mkdirs();
                }
                suiteReport = new ExtentReports(extentReportPath + "//TestResults.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suiteReport;
    }
}
