package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class SeleniumeasyConfirmBoxAlertsTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void confirmBoxAcceptTest() {

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickMeButton = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
        clickMeButton.click();

        try {

            Alert alert = driver.switchTo().alert();
            alert.accept();
            WebElement message = driver.findElement(By.id("confirm-demo"));
            Assert.assertEquals("You pressed OK!", message.getText());

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void confirmBoxDismissTest() {

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickMeButton = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
        clickMeButton.click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            WebElement message1 = driver.findElement(By.id("confirm-demo"));
            Assert.assertEquals("You pressed Cancel!", message1.getText());

        }catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
