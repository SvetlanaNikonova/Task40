package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumeasyUserWaitTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";

    public static final By BUTTON = By.cssSelector("#save");
    public static final By PORTRAIT = By.cssSelector("#loading > img[src*='randomuser.me/api/portraits']");

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void waitTest() {

        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = driver.findElement(BUTTON);
        button.click();
        WebElement portrait = wait.until(ExpectedConditions.visibilityOfElementLocated(PORTRAIT));
        Assert.assertTrue(portrait.isDisplayed());
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}