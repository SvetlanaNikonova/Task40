package com.coherentsolutions.training.aqa.java.web.nikonova;

public class Employee {

    private String name;
    private String position;
    private String office;
    private int age;
    private int salary;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {return position; }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffice() { return office; }
    public void setOffice(String office) {
        this.office = office;
    }

    public Employee(String name, String position, String office, int age, int salary) {
        this.name = name;
        this.position = position;
        this.office = office;
        this.age = age;
        this.salary = salary;
    }

}
