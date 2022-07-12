package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class SeleniumeasyConfirmBoxTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    public static final By CLICK_BUTTON = By.cssSelector("button[onclick='myConfirmFunction()']");
    public static final By MESSAGE = By.id("confirm-demo");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);
    }

    @Test
    public void confirmBoxAcceptTest() {

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

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
