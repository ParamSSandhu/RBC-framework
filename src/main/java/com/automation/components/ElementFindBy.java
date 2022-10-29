package com.automation.components;

import com.automation.properties.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.List;

public class ElementFindBy {

    WebDriver driver;
    WebDriverWait wait;

    public ElementFindBy (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,PropertiesLoader.explicitWaitTime);
    }

    public By findBy(String element) throws IOException, Exception {
        By by = null;
        try {
            RepositoryLoader loader = new RepositoryLoader();
            loader.loadProperties();
            String elementValue = loader.getProperty(element);
            String findBy = elementValue.split(":")[0];
            String findByValue = elementValue.split(":")[1];
            if (findBy.equalsIgnoreCase("xpath")) {
                by = By.xpath(findByValue);
            } else if (findBy.equalsIgnoreCase("id")) {
                by = By.id(findByValue);
            } else if (findBy.equalsIgnoreCase("name")) {
                by = By.name(findByValue);
            } else if (findBy.equalsIgnoreCase("class")) {
                by = By.className(findByValue);
            } else if (findBy.equalsIgnoreCase("css")) {
                by = By.cssSelector(findByValue);
            } else if (findBy.equalsIgnoreCase("linkText")) {
                by = By.linkText(findByValue);
            } else if (findBy.equalsIgnoreCase("partialLinkTest")){
            by = By.partialLinkText(findByValue);
            }else{
                throw new Exception("Invalid Locator Type/Value in ["+ element +"]. Pls check value in OR file");
            }
        } catch (Exception e) {

        }
        return by;
    }

    public WebElement findElementBy(String element) throws Exception {
        try {
            By by = findBy(element);
            return waitUntilElementVisible(by);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<WebElement> findAllElementsBy (String element) throws Exception {
        try {
            By by = findBy(element);
            return waitUntilAllElementsVisible(by);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement waitUntilElementVisible(By by) throws Exception{
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            //return driver.findElement(by);    //same thing without the ExplicitWait
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<WebElement> waitUntilAllElementsVisible(By by) throws Exception{
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean waitUntilElementDisappears(By by) throws Exception{
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement waitUntilElementFound(By by) throws Exception{
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement waitUntilClickable (By by) throws Exception{
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}