package com.example.employee;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAnalyzer {
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Employee ceo;

    public void loadFromCSV(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String firstName = parts[1].trim();
                String lastName = parts[2].trim();
                double salary = Double.parseDouble(parts[3].trim());
                Integer managerId = parts[4].isEmpty() ? null : Integer.parseInt(parts[4].trim());

                Employee emp = new Employee(id, firstName, lastName, salary, managerId);
                employeeMap.put(id, emp);
            }
        }

        for (Employee emp : employeeMap.values()) {
            if (emp.managerId == null) {
                ceo = emp;
            } else {
                Employee manager = employeeMap.get(emp.managerId);
                if (manager != null) {
                    manager.subordinates.add(emp);
                }
            }
        }
    }

    public void performAnalysis() {
        for (Employee manager : employeeMap.values()) {
            if (!manager.subordinates.isEmpty()) {
                double avgSalary = manager.subordinates.stream()
                        .mapToDouble(e -> e.salary)
                        .average()
                        .orElse(0.0);

                double minThreshold = avgSalary * 1.2;
                double maxThreshold = avgSalary * 1.5;

                if (manager.salary < minThreshold) {
                    System.out.printf("Manager underpaid: %s earns %.2f (should be at least %.2f)%n",
                            manager.getFullName(), manager.salary, minThreshold);
                } else if (manager.salary > maxThreshold) {
                    System.out.printf("Manager overpaid: %s earns %.2f (should be at most %.2f)%n",
                            manager.getFullName(), manager.salary, maxThreshold);
                }
            }
        }

        for (Employee emp : employeeMap.values()) {
            int depth = getManagerDepth(emp);
            if (depth > 4) {
                System.out.printf("Deep hierarchy: %s has %d managers above%n", emp.getFullName(), depth);
            }
        }
    }

    private int getManagerDepth(Employee emp) {
        int depth = 0;
        while (emp.managerId != null) {
            emp = employeeMap.get(emp.managerId);
            depth++;
        }
        return depth;
    }
}
