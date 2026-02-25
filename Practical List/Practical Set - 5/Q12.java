/*
 * Question 12: Design an Online Order Processing System using partial interface implementation.
 * Create an Order interface with methods: orderID(), totalPrice(), displayOrder().
 * Create an abstract class PartialOrder implementing Order with some concrete methods.
 * Create concrete subclasses: RetailOrder, OnlineOrder, CorporateOrder.
 */

import java.util.ArrayList;

interface Order {
    void orderID();
    void totalPrice();
    void displayOrder();
}

abstract class PartialOrder implements Order {
    protected String orderNumber;
    protected ArrayList<OrderItem> items;
    protected double totalAmount;
    protected String customerName;
    protected String orderStatus;
    
    public PartialOrder(String orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        this.orderStatus = "Pending";
    }
    
    public void addItem(String itemName, double price, int quantity) {
        items.add(new OrderItem(itemName, price, quantity));
        calculateTotal();
    }
    
    protected void calculateTotal() {
        totalAmount = 0;
        for (OrderItem item : items) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
    }
    
    public void applyDiscount(double discountPercent) {
        totalAmount = totalAmount * (1 - discountPercent / 100);
    }
    
    @Override
    abstract public void orderID();
    @Override
    abstract public void totalPrice();
    @Override
    abstract public void displayOrder();
}

class OrderItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public OrderItem(String name, double price, int qty) {
        this.itemName = name;
        this.price = price;
        this.quantity = qty;
    }
    
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

class RetailOrder extends PartialOrder {
    private String deliveryAddress;
    private String deliveryDate;
    
    public RetailOrder(String orderNumber, String customerName, String address, String date) {
        super(orderNumber, customerName);
        this.deliveryAddress = address;
        this.deliveryDate = date;
    }
    
    @Override
    public void orderID() {
        System.out.printf("Order ID: %s%n", orderNumber);
    }
    
    @Override
    public void totalPrice() {
        System.out.printf("Total Price: Rs. %.2f%n", totalAmount);
    }
    
    @Override
    public void displayOrder() {
        System.out.println("\n====== RETAIL ORDER ======");
        orderID();
        System.out.printf("Customer Name: %s%n", customerName);
        System.out.printf("Delivery Address: %s%n", deliveryAddress);
        System.out.printf("Delivery Date: %s%n", deliveryDate);
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.printf("  - %s: Rs. %.2f x %d = Rs. %.2f%n",
                item.getItemName(), item.getPrice(), item.getQuantity(),
                item.getPrice() * item.getQuantity());
        }
        totalPrice();
        System.out.printf("Order Status: %s%n", orderStatus);
        System.out.println("==========================");
    }
}

class OnlineOrder extends PartialOrder {
    private String email;
    private boolean expressShipping;
    
    public OnlineOrder(String orderNumber, String customerName, String email, boolean express) {
        super(orderNumber, customerName);
        this.email = email;
        this.expressShipping = express;
    }
    
    @Override
    public void orderID() {
        System.out.printf("Online Order ID: ORD-%s%n", orderNumber);
    }
    
    @Override
    public void totalPrice() {
        double shippingCost = expressShipping ? 100 : 50;
        System.out.printf("Total Price (with shipping): Rs. %.2f%n", totalAmount + shippingCost);
    }
    
    @Override
    public void displayOrder() {
        System.out.println("\n====== ONLINE ORDER ======");
        orderID();
        System.out.printf("Customer Name: %s%n", customerName);
        System.out.printf("Email: %s%n", email);
        System.out.printf("Shipping Type: %s%n", expressShipping ? "Express" : "Standard");
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.printf("  - %s: Rs. %.2f x %d = Rs. %.2f%n",
                item.getItemName(), item.getPrice(), item.getQuantity(),
                item.getPrice() * item.getQuantity());
        }
        totalPrice();
        System.out.printf("Order Status: %s%n", orderStatus);
        System.out.println("===========================");
    }
}

class CorporateOrder extends PartialOrder {
    private String companyName;
    private double creditLimit;
    
    public CorporateOrder(String orderNumber, String customerName, String company, double credit) {
        super(orderNumber, customerName);
        this.companyName = company;
        this.creditLimit = credit;
    }
    
    @Override
    public void orderID() {
        System.out.printf("Corporate Order ID: CORP-%s%n", orderNumber);
    }
    
    @Override
    public void totalPrice() {
        System.out.printf("Total Price (Corporate Rate): Rs. %.2f%n", totalAmount);
    }
    
    @Override
    public void displayOrder() {
        System.out.println("\n====== CORPORATE ORDER ======");
        orderID();
        System.out.printf("Customer Name: %s%n", customerName);
        System.out.printf("Company: %s%n", companyName);
        System.out.printf("Credit Limit: Rs. %.2f%n", creditLimit);
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.printf("  - %s: Rs. %.2f x %d = Rs. %.2f%n",
                item.getItemName(), item.getPrice(), item.getQuantity(),
                item.getPrice() * item.getQuantity());
        }
        totalPrice();
        System.out.printf("Order Status: %s%n", orderStatus);
        System.out.println("==============================");
    }
}

class Q12 {
    public static void main(String[] args) {
        System.out.println("===== Online Order Processing System =====\n");
        
        RetailOrder retailOrder = new RetailOrder("1001", "John Doe", "123 Main St, Delhi", "2024-01-20");
        retailOrder.addItem("Laptop", 50000, 1);
        retailOrder.addItem("Mouse", 500, 2);
        retailOrder.addItem("Keyboard", 2000, 1);
        retailOrder.applyDiscount(5);
        retailOrder.displayOrder();
        
        OnlineOrder onlineOrder = new OnlineOrder("1002", "Jane Smith", "jane@email.com", true);
        onlineOrder.addItem("Book", 300, 3);
        onlineOrder.addItem("Pen", 50, 10);
        onlineOrder.applyDiscount(10);
        onlineOrder.displayOrder();
        
        CorporateOrder corpOrder = new CorporateOrder("1003", "ABC Corporation", "ABC Pvt Ltd", 500000);
        corpOrder.addItem("Office Chair", 8000, 5);
        corpOrder.addItem("Desk", 15000, 5);
        corpOrder.addItem("Monitor", 12000, 5);
        corpOrder.applyDiscount(15);
        corpOrder.displayOrder();
        
        System.out.println("\n===== Polymorphic Order Processing =====");
        Order[] orders = {retailOrder, onlineOrder, corpOrder};
        
        for (int i = 0; i < orders.length; i++) {
            System.out.printf("\n--- Order %d ---\n", (i + 1));
            orders[i].orderID();
            orders[i].totalPrice();
        }
    }
}

/*
 * Output:
 * 
 * ===== Online Order Processing System =====
 * 
 * ====== RETAIL ORDER ======
 * Order ID: 1001
 * Customer Name: John Doe
 * Delivery Address: 123 Main St, Delhi
 * Delivery Date: 2024-01-20
 * Items:
 *   - Laptop: Rs. 50000.00 x 1 = Rs. 50000.00
 *   - Mouse: Rs. 500.00 x 2 = Rs. 1000.00
 *   - Keyboard: Rs. 2000.00 x 1 = Rs. 2000.00
 * Total Price: Rs. 50350.00
 * Order Status: Pending
 * ==========================
 * 
 * ====== ONLINE ORDER ======
 * Online Order ID: ORD-1002
 * Customer Name: Jane Smith
 * Email: jane@email.com
 * Shipping Type: Express
 * Items:
 *   - Book: Rs. 300.00 x 3 = Rs. 900.00
 *   - Pen: Rs. 50.00 x 10 = Rs. 500.00
 * Total Price (with shipping): Rs. 1360.00
 * Order Status: Pending
 */
