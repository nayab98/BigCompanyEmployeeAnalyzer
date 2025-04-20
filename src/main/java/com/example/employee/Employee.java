package com.example.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public double salary;
    public Integer managerId;
    public List<Employee> subordinates;

    public Employee(int id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
        this.subordinates = new ArrayList<>();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
