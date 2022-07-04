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
import java.util.regex.Pattern;

public class SeleniumeasyDownloadTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void downloadTest() {

        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = driver.findElement(By.id("cricle-btn"));
        button.click();

        Pattern p = Pattern.compile("([5-9][0-9])");

        Boolean progressIndicator = wait.withTimeout(Duration.ofSeconds(15)).until(ExpectedConditions
                .textMatches(By.cssSelector(".percenttext"), p));

        Assert.assertTrue(progressIndicator);

        driver.navigate().refresh();
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}