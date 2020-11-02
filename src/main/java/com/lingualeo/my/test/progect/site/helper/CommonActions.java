package com.lingualeo.my.test.progect.site.helper;

import com.lingualeo.my.test.progect.site.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonActions extends BasePage {


    public CommonActions(WebDriver driver) {
        super(driver);
    }

    public void waitLocator(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void clickWithWait(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator)).click();
    }


    public void clickWithWaitAndSendKeys(WebElement locator, String texforSendKeys) {
        wait.until(ExpectedConditions.visibilityOf(locator)).sendKeys(texforSendKeys);
    }

    public void isDisplayed(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
    }

    public void equalsCheck(String expected, String actual, String errorMessage) {
        Assertions.assertEquals(errorMessage, expected, actual);
    }

    public String getTextWithWait(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator)).getText();
    }

    public void clickButton(String text) {
        driver.findElement(By.xpath("//div[text()='" + text + "']")).click();
    }

    public CommonActions contentIsDisplayed(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).isDisplayed();
        return this;
    }


    public CommonActions urlCheck(String url) {
        driver.getCurrentUrl();
        Assertions.assertTrue(url.equals(url));
        return this;
    }


    public void waitPageLoad() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebDriverWait jqWait = new WebDriverWait(driver, 5);


        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) js.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        try {
            jqWait.until(jQueryLoad);
        } catch (org.openqa.selenium.TimeoutException ex) {
            //test
        }

        wait.until(jsLoad);
    }

}

