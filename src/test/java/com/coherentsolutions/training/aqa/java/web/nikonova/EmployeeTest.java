package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class EmployeeTest extends BaseTest {

    private String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";


    @Test
    public void tableTest() {

        driver.get(URL);
        int ageMoreThan = 65;
        int salaryMax = 400000;
        int expectedEmployeeCount = 1;

        ArrayList<Employee> employees = EmployeeTable.getEmployeeData(driver, ageMoreThan, salaryMax);
        Assert.assertEquals(employees.size(), expectedEmployeeCount, "Employee size doesn't match");
    }
}
