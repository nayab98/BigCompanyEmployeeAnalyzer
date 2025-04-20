# Big Company Employee Analyzer

This project is a Java-based tool to analyze the organizational structure of a company and detect potential improvements based on salary and reporting hierarchy.

## Problem Statement

A large company wants to ensure:
- Managers earn at least 20% more than the average salary of their direct subordinates.
- Managers do not earn more than 50% above that average.
- Employees do not have more than 4 managers between them and the CEO.

The application reads a CSV file of employee data and outputs:
- Which managers are underpaid or overpaid.
- Which employees are buried too deep in the hierarchy.

## Sample Input

The CSV file should have the following format:
