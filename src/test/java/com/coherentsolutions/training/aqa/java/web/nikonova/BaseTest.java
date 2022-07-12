package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

   public WebDriver driver;

   public BaseTest() {

   }
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.driver = driver;


    }
    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
