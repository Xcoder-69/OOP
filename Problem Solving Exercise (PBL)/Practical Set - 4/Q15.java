/*
 * Question 15: Create a base class Employee that contains a method displayDetails()
 * which prints general employee details such as name and department.
 * Now create a subclass Manager that inherits from Employee and overrides the displayDetails()
 * method to include additional information such as the manager's team size or project name.
 * In the main method, create objects of both Employee and Manager classes and call the
 * displayDetails() method using each object to show how Java determines which version
 * of the method to execute at runtime.
 */

// Base class
class Employee {
    protected String employeeName;
    protected String employeeID;
    protected String department;
    protected double salary;
    
    // Constructor
    public Employee(String name, String id, String dept, double sal) {
        this.employeeName = name;
        this.employeeID = id;
        this.department = dept;
        this.salary = sal;
    }
    
    // Method to display employee details
    public void displayDetails() {
        System.out.println("====== Employee Details ======");
        System.out.printf("Name: %s%n", employeeName);
        System.out.printf("Employee ID: %s%n", employeeID);
        System.out.printf("Department: %s%n", department);
        System.out.printf("Salary: $%.2f%n", salary);
        System.out.println("===============================\n");
    }
}

// Subclass - Manager
class Manager extends Employee {
    private int teamSize;
    private String projectName;
    
    // Constructor
    public Manager(String name, String id, String dept, double sal, int team, String project) {
        super(name, id, dept, sal);
        this.teamSize = team;
        this.projectName = project;
    }
    
    // Overridden method to display manager details
    @Override
    public void displayDetails() {
        System.out.println("====== Manager Details ======");
        System.out.printf("Name: %s%n", employeeName);
        System.out.printf("Employee ID: %s%n", employeeID);
        System.out.printf("Department: %s%n", department);
        System.out.printf("Salary: $%.2f%n", salary);
        System.out.printf("Team Size: %d%n", teamSize);
        System.out.printf("Project Name: %s%n", projectName);
        System.out.println("=============================\n");
    }
    
    // Additional methods
    public void addTeamMember() {
        teamSize++;
        System.out.printf("Team member added. New team size: %d%n\n", teamSize);
    }
    
    public void removeTeamMember() {
        if (teamSize > 0) {
            teamSize--;
            System.out.printf("Team member removed. New team size: %d%n\n", teamSize);
        } else {
            System.out.println("No team members to remove.\n");
        }
    }
}

class Q15 {
    public static void main(String[] args) {
        System.out.println("===== Method Overriding Demonstration =====\n");
        
        // Create Employee objects
        System.out.println("--- Creating Employee Object ---\n");
        Employee emp1 = new Employee("John Smith", "EMP001", "IT", 50000);
        emp1.displayDetails();
        
        Employee emp2 = new Employee("Sarah Johnson", "EMP002", "HR", 45000);
        emp2.displayDetails();
        
        // Create Manager objects
        System.out.println("--- Creating Manager Objects ---\n");
        Manager mgr1 = new Manager("Alice Brown", "MGR001", "IT", 75000, 5, "Mobile App Development");
        mgr1.displayDetails();
        
        Manager mgr2 = new Manager("Bob Wilson", "MGR002", "Finance", 80000, 8, "Annual Budgeting");
        mgr2.displayDetails();
        
        // Demonstrate polymorphism - calling overridden method
        System.out.println("--- Polymorphism Demonstration ---\n");
        Employee[] employees = new Employee[4];
        employees[0] = emp1;
        employees[1] = emp2;
        employees[2] = mgr1;
        employees[3] = mgr2;
        
        System.out.println("Calling displayDetails() for all objects:\n");
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("Object %d:%n", (i + 1));
            employees[i].displayDetails();
        }
        
        // Demonstrate manager-specific operations
        System.out.println("--- Manager-Specific Operations ---\n");
        mgr1.addTeamMember();
        mgr1.addTeamMember();
        mgr1.displayDetails();
        
        mgr1.removeTeamMember();
        mgr1.displayDetails();
    }
}

/*
 * Output:
 * 
 * ===== Method Overriding Demonstration =====
 * 
 * --- Creating Employee Object ---
 * 
 * ====== Employee Details ======
 * Name: John Smith
 * Employee ID: EMP001
 * Department: IT
 * Salary: $50000.00
 * ===============================
 * 
 * ====== Employee Details ======
 * Name: Sarah Johnson
 * Employee ID: EMP002
 * Department: HR
 * Salary: $45000.00
 * ===============================
 * 
 * --- Creating Manager Objects ---
 * 
 * ====== Manager Details ======
 * Name: Alice Brown
 * Employee ID: MGR001
 * Department: IT
 * Salary: $75000.00
 * Team Size: 5
 * Project Name: Mobile App Development
 * =============================
 * 
 * ====== Manager Details ======
 * Name: Bob Wilson
 * Employee ID: MGR002
 * Department: Finance
 * Salary: $80000.00
 * Team Size: 8
 * Project Name: Annual Budgeting
 * =============================
 * 
 * --- Polymorphism Demonstration ---
 * 
 * Calling displayDetails() for all objects:
 * 
 * Object 1:
 * ====== Employee Details ======
 * Name: John Smith
 * Employee ID: EMP001
 * Department: IT
 * Salary: $50000.00
 * ===============================
 * 
 * Object 2:
 * ====== Employee Details ======
 * Name: Sarah Johnson
 * Employee ID: EMP002
 * Department: HR
 * Salary: $45000.00
 * ===============================
 * 
 * Object 3:
 * ====== Manager Details ======
 * Name: Alice Brown
 * Employee ID: MGR001
 * Department: IT
 * Salary: $75000.00
 * Team Size: 5
 * Project Name: Mobile App Development
 * =============================
 * 
 * Object 4:
 * ====== Manager Details ======
 * Name: Bob Wilson
 * Employee ID: MGR002
 * Department: Finance
 * Salary: $80000.00
 * Team Size: 8
 * Project Name: Annual Budgeting
 * =============================
 * 
 * --- Manager-Specific Operations ---
 * 
 * Team member added. New team size: 6
 * 
 * Team member added. New team size: 7
 * 
 * ====== Manager Details ======
 * Name: Alice Brown
 * Employee ID: MGR001
 * Department: IT
 * Salary: $75000.00
 * Team Size: 7
 * Project Name: Mobile App Development
 * =============================
 * 
 * Team member removed. New team size: 6
 * 
 * ====== Manager Details ======
 * Name: Alice Brown
 * Employee ID: MGR001
 * Department: IT
 * Salary: $75000.00
 * Team Size: 6
 * Project Name: Mobile App Development
 * =============================
 */
