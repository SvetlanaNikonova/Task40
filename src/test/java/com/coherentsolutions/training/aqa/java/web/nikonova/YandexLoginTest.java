package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class YandexLoginTest {

    private WebDriver driver;
    private final String URL = "https://mail.yandex.com/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Parameters({"userName", "password"})
    @Test
    public void loginTest(String userName, String password) throws InterruptedException {
        driver.get(URL);

        driver.findElement(By.cssSelector(".HeadBanner-ButtonsWrapper > a:last-child")).click();

        String title = driver.getTitle();
        Thread.sleep(1000);
        Assert.assertEquals("Authorization", title);

        WebElement usernameInput = driver.findElement(By.id("passp-field-login"));
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.id("passp-field-passwd"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(By.id("passp:sign-in")).click();

        String inboxPageTitle = "Inbox";
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains(inboxPageTitle));
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
