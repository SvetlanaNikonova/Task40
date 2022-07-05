package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class EmployeeTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tableTest() {

        driver.get(URL);

        int ageMoreThan = 65;
        int salaryMax = 400000;
        int expectedEmployeeCount = 2;

        ArrayList<Employee> employees = EmployeeTable.getEmployeeData(driver, ageMoreThan, salaryMax);
        Assert.assertEquals(employees.size(), expectedEmployeeCount, "Employee size doesn't match");
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }

}
