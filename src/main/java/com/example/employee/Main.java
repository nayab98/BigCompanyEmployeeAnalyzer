package com.example.employee;

public class Main {
    public static void main(String[] args) {
        try {
            String pathToFile = "src/test/resources/employees.csv";
            EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
            analyzer.loadFromCSV(pathToFile);
            analyzer.performAnalysis();
        } catch (Exception e) {
            System.err.println("Error running analysis: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
