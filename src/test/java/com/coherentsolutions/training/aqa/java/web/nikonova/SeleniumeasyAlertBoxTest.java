package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumeasyAlertBoxTest extends BaseTest{


    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    public static final By CLICK_BUTTON = By.cssSelector("button[onclick='myAlertFunction()']");


    @Test
    public void alertBoxTest() {

        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickMeButton = driver.findElement(CLICK_BUTTON);
        clickMeButton.click();

        try {
            Alert alert = driver.switchTo().alert();
            String textOnAlert = alert.getText();
            alert.accept();

            Assert.assertEquals("I am an alert box!", textOnAlert);

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
}