package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumeasyAlertBoxTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    public static final By CLICK_BUTTON = By.cssSelector("button[onclick='myAlertFunction()']");

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

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

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}