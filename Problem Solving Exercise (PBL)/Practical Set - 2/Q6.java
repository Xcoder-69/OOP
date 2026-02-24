/*
 * Question 6: Define a Java class named Rectangle.
 * It should have two double data fields: width and height, both with a default value of 1.
 * Implement a no-argument constructor and a constructor that takes width and height as parameters.
 * Include methods getArea() and getPerimeter() that return the calculated area and perimeter respectively.
 */

class Rectangle {
    // Data fields with default values
    private double width;
    private double height;
    
    // No-argument constructor
    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }
    
    // Constructor with parameters
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // Getter for width
    public double getWidth() {
        return width;
    }
    
    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }
    
    // Getter for height
    public double getHeight() {
        return height;
    }
    
    // Setter for height
    public void setHeight(double height) {
        this.height = height;
    }
    
    // Method to calculate and return area
    public double getArea() {
        return width * height;
    }
    
    // Method to calculate and return perimeter
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    // Method to display rectangle details
    public void display() {
        System.out.printf("Width: %.2f, Height: %.2f%n", width, height);
        System.out.printf("Area: %.2f%n", getArea());
        System.out.printf("Perimeter: %.2f%n", getPerimeter());
    }
}

// Main class to test the Rectangle class
class Q6 {
    public static void main(String[] args) {
        // Test 1: No-argument constructor
        System.out.println("===== Test 1: No-argument Constructor =====");
        Rectangle rect1 = new Rectangle();
        System.out.println("Rectangle created with default values:");
        rect1.display();
        
        // Test 2: Parameterized constructor
        System.out.println("\n===== Test 2: Parameterized Constructor =====");
        Rectangle rect2 = new Rectangle(5, 10);
        System.out.println("Rectangle created with width=5, height=10:");
        rect2.display();
        
        // Test 3: Parameterized constructor with different values
        System.out.println("\n===== Test 3: Another Rectangle =====");
        Rectangle rect3 = new Rectangle(7.5, 4.3);
        System.out.println("Rectangle created with width=7.5, height=4.3:");
        rect3.display();
        
        // Test 4: Using setters
        System.out.println("\n===== Test 4: Using Setters =====");
        rect1.setWidth(3);
        rect1.setHeight(6);
        System.out.println("Rectangle modified with setWidth(3) and setHeight(6):");
        rect1.display();
    }
}

/*
 * Output:
 * 
 * ===== Test 1: No-argument Constructor =====
 * Rectangle created with default values:
 * Width: 1.00, Height: 1.00
 * Area: 1.00
 * Perimeter: 4.00
 * 
 * ===== Test 2: Parameterized Constructor =====
 * Rectangle created with width=5, height=10:
 * Width: 5.00, Height: 10.00
 * Area: 50.00
 * Perimeter: 30.00
 * 
 * ===== Test 3: Another Rectangle =====
 * Rectangle created with width=7.5, height=4.3:
 * Width: 7.50, Height: 4.30
 * Area: 32.25
 * Perimeter: 23.60
 * 
 * ===== Test 4: Using Setters =====
 * Rectangle modified with setWidth(3) and setHeight(6):
 * Width: 3.00, Height: 6.00
 * Area: 18.00
 * Perimeter: 18.00
 */
