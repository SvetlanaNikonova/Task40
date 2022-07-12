package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;

public class EmployeeTest {

    private WebDriver driver;
    private final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);
    }

    @Test
    public void tableTest() {

        int ageMoreThan = 65;
        int salaryMax = 400000;
        int expectedEmployeeCount = 2;

        ArrayList<Employee> employees = EmployeeTable.getEmployeeData(driver, ageMoreThan, salaryMax);
        Assert.assertEquals(employees.size(), expectedEmployeeCount, "Employee size doesn't match");
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

}
