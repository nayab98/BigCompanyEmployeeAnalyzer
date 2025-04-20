package com.example.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeAnalyzerTest {

    @Test
    void loadEmployeesSuccessfully() {
        EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
        try {
            analyzer.loadFromCSV("src/test/resources/employees.csv");
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }
}
