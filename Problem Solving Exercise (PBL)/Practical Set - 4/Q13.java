/*
 * Question 13: Design a base class Shape with two double data members d1 and d2 to store dimensions.
 * Include a method getData(double d1, double d2) to initialize these dimensions.
 * Create two derived classes, Triangle and Rectangle, which inherit from Shape.
 * Each derived class should have its own method to calculate its specific area.
 * Triangle area = (d1 * d2) / 2
 * Rectangle area = d1 * d2
 */

// Base class
class Shape {
    // Protected data members (accessible to derived classes)
    protected double d1;
    protected double d2;
    
    // Constructor
    public Shape() {
        this.d1 = 0;
        this.d2 = 0;
    }
    
    // Method to initialize dimensions
    public void getData(double d1, double d2) {
        this.d1 = d1;
        this.d2 = d2;
        System.out.printf("Dimensions set: d1 = %.2f, d2 = %.2f%n", d1, d2);
    }
    
    // Display dimensions
    public void displayDimensions() {
        System.out.printf("Dimension 1: %.2f, Dimension 2: %.2f%n", d1, d2);
    }
}

// Derived class for Triangle
class Triangle extends Shape {
    // Method to calculate area of triangle
    // Area = (base * height) / 2
    public double calculateArea() {
        return (d1 * d2) / 2;
    }
    
    // Method to display triangle details
    public void displayTriangleDetails() {
        System.out.println("\n====== Triangle ======");
        System.out.printf("Base: %.2f, Height: %.2f%n", d1, d2);
        System.out.printf("Area of Triangle: %.2f square units%n", calculateArea());
        System.out.println("======================");
    }
}

// Derived class for Rectangle
class RectangleShape extends Shape {
    // Method to calculate area of rectangle
    // Area = length * width
    public double calculateArea() {
        return d1 * d2;
    }
    
    // Method to display rectangle details
    public void displayRectangleDetails() {
        System.out.println("\n====== Rectangle ======");
        System.out.printf("Length: %.2f, Width: %.2f%n", d1, d2);
        System.out.printf("Area of Rectangle: %.2f square units%n", calculateArea());
        System.out.println("=======================");
    }
    
    // Additional method to calculate perimeter
    public double calculatePerimeter() {
        return 2 * (d1 + d2);
    }
}

class Q13 {
    public static void main(String[] args) {
        System.out.println("===== Inheritance and Polymorphism =====\n");
        
        // Create a Triangle object
        Triangle triangle = new Triangle();
        System.out.println("--- Triangle ---");
        triangle.getData(10, 8);
        triangle.displayTriangleDetails();
        
        // Create a Rectangle object
        RectangleShape rectangle = new RectangleShape();
        System.out.println("\n--- Rectangle ---");
        rectangle.getData(12, 7);
        rectangle.displayRectangleDetails();
        System.out.printf("Perimeter of Rectangle: %.2f units%n", rectangle.calculatePerimeter());
        
        // Create more shapes
        System.out.println("\n===== More Shapes =====");
        
        Triangle triangle2 = new Triangle();
        System.out.println("\n--- Triangle 2 ---");
        triangle2.getData(15, 6);
        triangle2.displayTriangleDetails();
        
        RectangleShape rectangle2 = new RectangleShape();
        System.out.println("\n--- Rectangle 2 ---");
        rectangle2.getData(5, 8);
        rectangle2.displayRectangleDetails();
        System.out.printf("Perimeter of Rectangle: %.2f units%n", rectangle2.calculatePerimeter());
        
        // Array of shapes (Polymorphism demonstration)
        System.out.println("\n===== Polymorphism Demonstration =====");
        Shape[] shapes = new Shape[4];
        shapes[0] = triangle;
        shapes[1] = rectangle;
        shapes[2] = triangle2;
        shapes[3] = rectangle2;
        
        System.out.println("\nAll shapes dimensions:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("Shape %d: ", (i + 1));
            shapes[i].displayDimensions();
        }
        
        // Calculate total area
        double totalArea = 0;
        System.out.println("\nArea calculations:");
        totalArea += triangle.calculateArea();
        System.out.printf("Triangle 1 Area: %.2f%n", triangle.calculateArea());
        totalArea += rectangle.calculateArea();
        System.out.printf("Rectangle 1 Area: %.2f%n", rectangle.calculateArea());
        totalArea += triangle2.calculateArea();
        System.out.printf("Triangle 2 Area: %.2f%n", triangle2.calculateArea());
        totalArea += rectangle2.calculateArea();
        System.out.printf("Rectangle 2 Area: %.2f%n", rectangle2.calculateArea());
        System.out.printf("\nTotal Area of all shapes: %.2f square units%n", totalArea);
    }
}

/*
 * Output:
 * 
 * ===== Inheritance and Polymorphism =====
 * 
 * --- Triangle ---
 * Dimensions set: d1 = 10.00, d2 = 8.00
 * 
 * ====== Triangle ======
 * Base: 10.00, Height: 8.00
 * Area of Triangle: 40.00 square units
 * ======================
 * 
 * --- Rectangle ---
 * Dimensions set: d1 = 12.00, d2 = 7.00
 * 
 * ====== Rectangle ======
 * Length: 12.00, Width: 7.00
 * Area of Rectangle: 84.00 square units
 * =======================
 * Perimeter of Rectangle: 38.00 units
 * 
 * ===== More Shapes =====
 * 
 * --- Triangle 2 ---
 * Dimensions set: d1 = 15.00, d2 = 6.00
 * 
 * ====== Triangle ======
 * Base: 15.00, Height: 6.00
 * Area of Triangle: 45.00 square units
 * ======================
 * 
 * --- Rectangle 2 ---
 * Dimensions set: d1 = 5.00, d2 = 8.00
 * 
 * ====== Rectangle ======
 * Length: 5.00, Width: 8.00
 * Area of Rectangle: 40.00 square units
 * =======================
 * Perimeter of Rectangle: 26.00 units
 * 
 * ===== Polymorphism Demonstration =====
 * 
 * All shapes dimensions:
 * Shape 1: Dimension 1: 10.00, Dimension 2: 8.00
 * Shape 2: Dimension 1: 12.00, Dimension 2: 7.00
 * Shape 3: Dimension 1: 15.00, Dimension 2: 6.00
 * Shape 4: Dimension 1: 5.00, Dimension 2: 8.00
 * 
 * Area calculations:
 * Triangle 1 Area: 40.00
 * Rectangle 1 Area: 84.00
 * Triangle 2 Area: 45.00
 * Rectangle 2 Area: 40.00
 * 
 * Total Area of all shapes: 209.00 square units
 */
