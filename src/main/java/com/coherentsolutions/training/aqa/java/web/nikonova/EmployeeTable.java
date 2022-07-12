package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTable {

    public static final String CELL_LOCATOR = "td:nth-child(";
    public static final By ENTRY_COUNT_SELECT = By.cssSelector("select[name=example_length]");
    public static final By NEXT_BUTTON = By.id("example_next");
    public static final By TABLE = By.cssSelector("table#example>tbody>tr");

    static ArrayList<Employee> getEmployeeData(WebDriver driver, double ageFilter, double salaryFilter) {
        Select select = new Select(driver.findElement(ENTRY_COUNT_SELECT));

        // Table shows 10 entries ( it could be 10, 25, 50 or 100)
        select.selectByValue("10");

        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            WebElement nextButton = driver.findElement(NEXT_BUTTON);

            List<WebElement> rows = driver.findElements(TABLE);

            rows.forEach(WebElement -> {
                String name = WebElement.findElement(By.cssSelector(CELL_LOCATOR + "1" + ")")).getAttribute("data-search");
                String position = WebElement.findElement(By.cssSelector(CELL_LOCATOR + "2" + ")")).getText();
                String office = WebElement.findElement(By.cssSelector(CELL_LOCATOR + "3" + ")")).getText();
                int age = Integer.parseInt(WebElement.findElement(By.cssSelector(CELL_LOCATOR + "4" + ")")).getText());
                int salary = Integer.parseInt(WebElement.findElement(By.cssSelector(CELL_LOCATOR + "6" + ")")).getAttribute("data-order"));

                if (salary <= salaryFilter & age > ageFilter) {
                    employees.add(new Employee(name, position, office, age, salary));
                }
            });

            if (nextButton.getAttribute("class").equals("paginate_button next")) {
                nextButton.click();
            } else {
                break;
            }
        }
        return employees;
    }
}

