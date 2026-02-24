package dpack;
import apack.A;

public class D {
    public static void testAccessFromUnrelatedClass() {
        A objA = new A();
        
        System.out.println("   Class D (unrelated class, different package):");
        System.out.printf("   - Public x: %d ✓ (accessible)%n", objA.x);
        System.out.println("   - Protected y: NOT ACCESSIBLE (not subclass of A)");
        System.out.println("   - Private z: NOT ACCESSIBLE (private in class A)");
        
        System.out.println("\n   Access Summary for Package dpack:");
        System.out.println("   ✓ Can access: public members only");
        System.out.println("   ✗ Cannot access: protected, private members");
    }
}
