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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class YandexLoginTest {

    private WebDriver driver;
    private final String URL = "https://mail.yandex.com/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Parameters({"userName", "password"})
    @Test
    public void loginTest(String userName, String password) throws InterruptedException {

        driver.get(URL);

        driver.findElement(By.cssSelector(".HeadBanner-ButtonsWrapper > a:last-child")).click();

        String authorizationPageTitle = driver.getTitle();
        Assert.assertEquals("Authorization", authorizationPageTitle);

        WebElement usernameInput = driver.findElement(By.id("passp-field-login"));
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        driver.findElement(By.id("passp:sign-in")).click();
        WebElement passwordInput = driver.findElement(By.id("passp-field-passwd"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(By.id("passp:sign-in")).click();

        String expectedInboxPageTitle = "Inbox";
        // Explicit waiter
      //  Thread.sleep(2000);
        WebElement name = driver.findElement(By.className("PSHeader-User"));
        WebElement waiter = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(name));
        Assert.assertTrue(driver.getTitle().contains(expectedInboxPageTitle));
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
