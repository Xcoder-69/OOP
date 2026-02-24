package apack;

public class A {
    public int x;           // Public - accessible from anywhere
    protected int y;        // Protected - accessible from same package and subclasses
    private int z;          // Private - accessible only within the class
    
    public A() {
        this.x = 10;
        this.y = 20;
        this.z = 30;
    }
    
    public void displayPrivate() {
        System.out.printf("Private variable z = %d%n", z);
    }
    
    public void displayAll() {
        System.out.println("\n===== Class A Details =====");
        System.out.printf("Public x = %d%n", x);
        System.out.printf("Protected y = %d%n", y);
        System.out.printf("Private z = %d%n", z);
        System.out.println("===========================");
    }
}
