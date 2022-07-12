package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.regex.Pattern;

public class SeleniumeasyDownloadTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    public static final By BUTTON = By.id("cricle-btn");


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);
    }

    @Test
    public void downloadTest() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement button = driver.findElement(BUTTON);
        button.click();

        Pattern p = Pattern.compile("([5-9][0-9])");

        Boolean progressIndicator = wait.withTimeout(Duration.ofSeconds(15)).until(ExpectedConditions
                .textMatches(By.cssSelector(".percenttext"), p));

        Assert.assertTrue(progressIndicator);

        driver.navigate().refresh();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}