package cpack;
import apack.A;

public class C {
    public static void testAccessFromDifferentPackage() {
        A objA = new A();
        
        System.out.println("   Class C (different package):");
        System.out.printf("   - Public x: %d ✓ (accessible)%n", objA.x);
        System.out.println("   - Protected y: NOT ACCESSIBLE (different package, not subclass)");
        System.out.println("   - Private z: NOT ACCESSIBLE (private in class A)");
        
        System.out.println("\n   Access Summary for Package cpack:");
        System.out.println("   ✓ Can access: public members");
        System.out.println("   ✗ Cannot access: protected, private members");
    }
}
