package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumeasyAlertBoxTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    public static final By CLICK_BUTTON = By.cssSelector("button[onclick='myAlertFunction()']");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);
    }

    @Test
    public void alertBoxTest() {


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

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}