/*
 * Practical Set-3: Q8
 * Write a Java program to demonstrate the use of static blocks and instance blocks.
 * Create a University class with:
 * - Static block to initialize static variables
 * - Instance block to initialize instance variables
 * - Multiple constructors
 * Show the order of execution: static block → instance block → constructor
 */

class University {
    static String universityName;
    static int universityCode;
    static int totalStudents = 0;
    
    String studentName;
    int studentID;
    String department;
    
    // Static block - Executes only once when class is loaded
    static {
        System.out.println("===== STATIC BLOCK EXECUTED =====");
        universityName = "IIT Delhi";
        universityCode = 1001;
        System.out.printf("University: %s%n", universityName);
        System.out.printf("University Code: %d%n", universityCode);
        System.out.println("==================================\n");
    }
    
    // Instance block - Executes every time an object is created (before constructor)
    {
        System.out.println("===== INSTANCE BLOCK EXECUTED =====");
        totalStudents++;
        System.out.printf("Total Students so far: %d%n", totalStudents);
        System.out.println("====================================\n");
    }
    
    // Constructor 1
    public University(String name, int id, String dept) {
        System.out.println("===== CONSTRUCTOR EXECUTED =====");
        this.studentName = name;
        this.studentID = id;
        this.department = dept;
        System.out.printf("Student: %s (ID: %d)%n", studentName, studentID);
        System.out.printf("Department: %s%n", department);
        System.out.println("=================================\n");
    }
    
    // Constructor 2 (overloaded)
    public University(String name, int id) {
        this(name, id, "Not Specified");
    }
    
    // Display student information
    public void displayInfo() {
        System.out.printf("Name: %s%n", studentName);
        System.out.printf("ID: %d%n", studentID);
        System.out.printf("Department: %s%n", department);
        System.out.printf("University: %s%n", universityName);
    }
}

class Q8_University {
    public static void main(String[] args) {
        System.out.println("========== Static and Instance Block Demonstration ==========\n");
        
        System.out.println("--- Creating Student 1 ---");
        University student1 = new University("Alice Johnson", 1001, "Computer Science");
        
        System.out.println("--- Creating Student 2 ---");
        University student2 = new University("Bob Smith", 1002, "Electronics");
        
        System.out.println("--- Creating Student 3 ---");
        University student3 = new University("Charlie Brown", 1003, "Mechanical");
        
        System.out.println("\n===== Student Information =====");
        System.out.println("\nStudent 1:");
        student1.displayInfo();
        
        System.out.println("\nStudent 2:");
        student2.displayInfo();
        
        System.out.println("\nStudent 3:");
        student3.displayInfo();
        
        System.out.printf("\nTotal Students: %d%n", University.totalStudents);
    }
}

/*
 * Output:
 * ========== Static and Instance Block Demonstration ==========
 * 
 * ===== STATIC BLOCK EXECUTED =====
 * University: IIT Delhi
 * University Code: 1001
 * ==================================
 * 
 * --- Creating Student 1 ---
 * ===== INSTANCE BLOCK EXECUTED =====
 * Total Students so far: 1
 * ====================================
 * 
 * ===== CONSTRUCTOR EXECUTED =====
 * Student: Alice Johnson (ID: 1001)
 * Department: Computer Science
 * =================================
 * 
 * --- Creating Student 2 ---
 * ===== INSTANCE BLOCK EXECUTED =====
 * Total Students so far: 2
 * ====================================
 * 
 * ===== CONSTRUCTOR EXECUTED =====
 * Student: Bob Smith (ID: 1002)
 * Department: Electronics
 * =================================
 */
