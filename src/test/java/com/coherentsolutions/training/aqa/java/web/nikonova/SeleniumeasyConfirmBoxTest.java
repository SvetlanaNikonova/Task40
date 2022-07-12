package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class SeleniumeasyConfirmBoxTest extends BaseTest {

    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    public static final By CLICK_BUTTON = By.cssSelector("button[onclick='myConfirmFunction()']");
    public static final By MESSAGE = By.id("confirm-demo");


    @Test
    public void confirmBoxAcceptTest() {

        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickMeButton = driver.findElement(CLICK_BUTTON);
        clickMeButton.click();

        try {

            Alert alert = driver.switchTo().alert();
            alert.accept();
            WebElement message = driver.findElement(MESSAGE);
            Assert.assertEquals("You pressed OK!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmBoxDismissTest() {

        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickMeButton = driver.findElement(CLICK_BUTTON);
        clickMeButton.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            WebElement message1 = driver.findElement(MESSAGE);
            Assert.assertEquals("You pressed Cancel!", message1.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
}
