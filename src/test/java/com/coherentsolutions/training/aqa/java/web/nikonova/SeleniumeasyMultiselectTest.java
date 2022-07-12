package com.coherentsolutions.training.aqa.java.web.nikonova;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleniumeasyMultiselectTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    public static final By SELECT = By.cssSelector("select#multi-select");

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void multiselectTest() throws InterruptedException {

        driver.get(URL);

        Select select = new Select(driver.findElement(SELECT));

        List<WebElement> options = select.getOptions();
        Collections.shuffle(options);

        List<String> randomOptions = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            select.selectByValue(options.get(i).getText());
            randomOptions.add(options.get(i).getText());
        }

        randomOptions.sort(String.CASE_INSENSITIVE_ORDER);

        List<String> selectedOptions = new ArrayList<>();

        select.getAllSelectedOptions().forEach(webElement -> {
            selectedOptions.add(webElement.getText());
        });

        Assert.assertEquals(randomOptions, selectedOptions);
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }
}
