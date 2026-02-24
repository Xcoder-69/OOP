/*
 * Question 7: Create an Employee class with private instance variables
 * for employeeName (String) and employeeSalary (double).
 * Implement public methods readEmployeeData() (to take input from the user)
 * and displayEmployeeData() (to print the employee's name and salary).
 * Demonstrate object creation and method invocation in a main method.
 */

import java.util.Scanner;

class Employee {
    // Private instance variables
    private String employeeName;
    private double employeeSalary;
    
    // Default constructor
    public Employee() {
        this.employeeName = "";
        this.employeeSalary = 0.0;
    }
    
    // Parameterized constructor
    public Employee(String name, double salary) {
        this.employeeName = name;
        this.employeeSalary = salary;
    }
    
    // Method to read employee data from user
    public void readEmployeeData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter employee name: ");
        this.employeeName = scanner.nextLine();
        
        System.out.print("Enter employee salary: ");
        this.employeeSalary = scanner.nextDouble();
        
        scanner.nextLine(); // Consume newline
    }
    
    // Method to display employee data
    public void displayEmployeeData() {
        System.out.println("--------------------");
        System.out.printf("Employee Name: %s%n", employeeName);
        System.out.printf("Employee Salary: $%.2f%n", employeeSalary);
        System.out.println("--------------------");
    }
    
    // Getters
    public String getEmployeeName() {
        return employeeName;
    }
    
    public double getEmployeeSalary() {
        return employeeSalary;
    }
    
    // Setters
    public void setEmployeeName(String name) {
        this.employeeName = name;
    }
    
    public void setEmployeeSalary(double salary) {
        this.employeeSalary = salary;
    }
}

// Main class to demonstrate object creation and method invocation
class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Employee Management System =====\n");
        
        // Create first employee object
        System.out.println("Enter details for Employee 1:");
        Employee emp1 = new Employee();
        emp1.readEmployeeData();
        
        System.out.println("\nEnter details for Employee 2:");
        Employee emp2 = new Employee();
        emp2.readEmployeeData();
        
        // Create third employee using parameterized constructor
        Employee emp3 = new Employee("John Doe", 75000);
        
        // Display employee data
        System.out.println("\n===== Employee Information =====");
        System.out.println("\nEmployee 1:");
        emp1.displayEmployeeData();
        
        System.out.println("\nEmployee 2:");
        emp2.displayEmployeeData();
        
        System.out.println("\nEmployee 3 (Created with parameterized constructor):");
        emp3.displayEmployeeData();
        
        // Calculate total salary
        double totalSalary = emp1.getEmployeeSalary() + emp2.getEmployeeSalary() + emp3.getEmployeeSalary();
        System.out.printf("\nTotal Salary of all employees: $%.2f%n", totalSalary);
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * ===== Employee Management System =====
 * 
 * Enter details for Employee 1:
 * Enter employee name: Alice Smith
 * Enter employee salary: 55000
 * 
 * Enter details for Employee 2:
 * Enter employee name: Bob Johnson
 * Enter employee salary: 65000
 * 
 * ===== Employee Information =====
 * 
 * Employee 1:
 * --------------------
 * Employee Name: Alice Smith
 * Employee Salary: $55000.00
 * --------------------
 * 
 * Employee 2:
 * --------------------
 * Employee Name: Bob Johnson
 * Employee Salary: $65000.00
 * --------------------
 * 
 * Employee 3 (Created with parameterized constructor):
 * --------------------
 * Employee Name: John Doe
 * Employee Salary: $75000.00
 * --------------------
 * 
 * Total Salary of all employees: $195000.00
 */
