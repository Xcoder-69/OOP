/*
 * Question 8: Create a Point class representing a 2D point (x, y).
 * Implement a default constructor that initializes both x and y to 5.
 * Provide a parameterized constructor to initialize x and y with user-supplied values.
 * Also, implement a copy constructor to create a new Point object as a copy of an existing Point object.
 * Include a display() method to show the point's coordinates and write a main method
 * to test all constructors and the display functionality.
 */

import java.util.Scanner;

class Point {
    // Instance variables
    private double x;
    private double y;
    
    // Default constructor - initializes x and y to 5
    public Point() {
        this.x = 5;
        this.y = 5;
    }
    
    // Parameterized constructor - initializes x and y with user-supplied values
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Copy constructor - creates a new Point object as a copy of an existing Point
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }
    
    // Method to display the point's coordinates
    public void display() {
        System.out.printf("Point: (%.2f, %.2f)%n", x, y);
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    // Setters
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    // Method to calculate distance from origin
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
    
    // Method to calculate distance between two points
    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// Main class to test all constructors and functionality
class Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Point Class - Constructor and Method Testing =====\n");
        
        // Test 1: Default constructor
        System.out.println("Test 1: Default Constructor");
        System.out.println("Creating a Point using default constructor (x=5, y=5):");
        Point point1 = new Point();
        point1.display();
        System.out.printf("Distance from origin: %.2f%n\n", point1.distanceFromOrigin());
        
        // Test 2: Parameterized constructor
        System.out.println("Test 2: Parameterized Constructor");
        System.out.print("Enter x coordinate: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y coordinate: ");
        double y = scanner.nextDouble();
        Point point2 = new Point(x, y);
        System.out.println("Creating a Point with user-supplied values:");
        point2.display();
        System.out.printf("Distance from origin: %.2f%n\n", point2.distanceFromOrigin());
        
        // Test 3: Copy constructor
        System.out.println("Test 3: Copy Constructor");
        System.out.println("Creating a Point as a copy of the previous point:");
        Point point3 = new Point(point2);
        point3.display();
        System.out.println("Verifying that point3 is a copy of point2:");
        System.out.printf("point2 and point3 are equal: %s%n\n", 
                        (point2.getX() == point3.getX() && point2.getY() == point3.getY()));
        
        // Test 4: Modifying the copy to show independence
        System.out.println("Test 4: Independence of Copy");
        System.out.println("Modifying point3 to (10, 15):");
        point3.setX(10);
        point3.setY(15);
        System.out.println("Original point2:");
        point2.display();
        System.out.println("Modified point3:");
        point3.display();
        System.out.println("(They are independent objects)\n");
        
        // Test 5: Additional test cases
        System.out.println("Test 5: Distance Between Points");
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 4);
        System.out.println("Point A:");
        pointA.display();
        System.out.println("Point B:");
        pointB.display();
        System.out.printf("Distance between Point A and Point B: %.2f%n", pointA.distanceTo(pointB));
        
        scanner.close();
    }
}

/*
 * Output:
 * 
 * ===== Point Class - Constructor and Method Testing =====
 * 
 * Test 1: Default Constructor
 * Creating a Point using default constructor (x=5, y=5):
 * Point: (5.00, 5.00)
 * Distance from origin: 7.07
 * 
 * Test 2: Parameterized Constructor
 * Enter x coordinate: 3
 * Enter y coordinate: 4
 * Creating a Point with user-supplied values:
 * Point: (3.00, 4.00)
 * Distance from origin: 5.00
 * 
 * Test 3: Copy Constructor
 * Creating a Point as a copy of the previous point:
 * Point: (3.00, 4.00)
 * Verifying that point3 is a copy of point2:
 * point2 and point3 are equal: true
 * 
 * Test 4: Independence of Copy
 * Modifying point3 to (10, 15):
 * Original point2:
 * Point: (3.00, 4.00)
 * Modified point3:
 * Point: (10.00, 15.00)
 * (They are independent objects)
 * 
 * Test 5: Distance Between Points
 * Point A:
 * Point: (0.00, 0.00)
 * Point B:
 * Point: (3.00, 4.00)
 * Distance between Point A and Point B: 5.00
 */
