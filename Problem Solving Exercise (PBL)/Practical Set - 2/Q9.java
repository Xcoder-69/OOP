/*
 * Question 9: Define a Java class named Rectangle.
 * It should have two double data fields: width and height.
 * In your main method, create two Rectangle objects: one with width 4 and height 40,
 * and another with width 3.5 and height 35.9.
 * For each rectangle, display its width, height, calculated area, and perimeter.
 * Then, compare the two rectangles based on their areas and print which one has a larger area.
 */

class Rectangle {
    // Data fields
    private double width;
    private double height;
    
    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // Method to get area
    public double getArea() {
        return width * height;
    }
    
    // Method to get perimeter
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

class Q9 {
    public static void main(String[] args) {
        System.out.println("===== Rectangle Comparison =====\n");
        
        // Create first rectangle with width 4 and height 40
        Rectangle rect1 = new Rectangle(4, 40);
        System.out.println("Rectangle 1:");
        rect1.display();
        
        // Create second rectangle with width 3.5 and height 35.9
        Rectangle rect2 = new Rectangle(3.5, 35.9);
        System.out.println("\nRectangle 2:");
        rect2.display();
        
        // Compare rectangles based on area
        System.out.println("\n===== Comparison =====");
        double area1 = rect1.getArea();
        double area2 = rect2.getArea();
        
        System.out.printf("Rectangle 1 Area: %.2f%n", area1);
        System.out.printf("Rectangle 2 Area: %.2f%n", area2);
        System.out.println();
        
        if (area1 > area2) {
            System.out.printf("Rectangle 1 has a LARGER area (%.2f > %.2f)%n", area1, area2);
        } else if (area2 > area1) {
            System.out.printf("Rectangle 2 has a LARGER area (%.2f > %.2f)%n", area2, area1);
        } else {
            System.out.println("Both rectangles have EQUAL areas.");
        }
    }
}

/*
 * Output:
 * 
 * ===== Rectangle Comparison =====
 * 
 * Rectangle 1:
 * Width: 4.00, Height: 40.00
 * Area: 160.00
 * Perimeter: 88.00
 * 
 * Rectangle 2:
 * Width: 3.50, Height: 35.90
 * Area: 125.65
 * Perimeter: 78.80
 * 
 * ===== Comparison =====
 * Rectangle 1 Area: 160.00
 * Rectangle 2 Area: 125.65
 * 
 * Rectangle 1 has a LARGER area (160.00 > 125.65)
 */
