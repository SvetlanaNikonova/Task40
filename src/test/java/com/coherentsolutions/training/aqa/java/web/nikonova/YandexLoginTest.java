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

public class YandexLoginTest {

    private WebDriver driver;
    private final String URL = "https://mail.yandex.com/";

    public static final By BUTTON = By.cssSelector(".HeadBanner-ButtonsWrapper > a:last-child");
    public static final By USERNAME_INPUT = By.id("passp-field-login");
    public static final By SIGN_IN = By.id("passp:sign-in");
    public static final By PASSWORD_INPUT = By.id("passp-field-passwd");
    public static final By NAME = By.className("PSHeader-User");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);
    }

    @Parameters({"userName", "password"})
    @Test
    public void loginTest(String userName, String password) throws InterruptedException {


        driver.findElement(BUTTON).click();

        String authorizationPageTitle = driver.getTitle();
        Assert.assertEquals("Authorization", authorizationPageTitle);

        WebElement usernameInput = driver.findElement(USERNAME_INPUT);
        usernameInput.clear();
        usernameInput.sendKeys(userName);
        driver.findElement(SIGN_IN).click();
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(SIGN_IN).click();

        String expectedInboxPageTitle = "Inbox";
        // Explicit waiter
      //  Thread.sleep(2000);
        WebElement name = driver.findElement(NAME);
        WebElement waiter = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(name));
        Assert.assertTrue(driver.getTitle().contains(expectedInboxPageTitle));
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
