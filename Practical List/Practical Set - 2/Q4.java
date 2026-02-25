/*
 * Question 4: Create a Time class with hours, minutes, and seconds attributes.
 * Implement methods to set time, display time, and add two Time objects.
 * Handle overflow correctly (e.g., 23:59:59 + 00:00:01 = 00:00:00).
 */

import java.util.Scanner;

class Time {
    private int hours;
    private int minutes;
    
    public void setTime(int h, int m) {
        this.hours = h;
        this.minutes = m;
    }
    
    public void displayTime() {
        System.out.printf("%02d:%02d%n", hours, minutes);
    }
    
    public void addTime(Time t1, Time t2) {
        this.minutes = (t1.minutes + t2.minutes) % 60;
        int carryMinutes = (t1.minutes + t2.minutes) / 60;
        
        this.hours = (t1.hours + t2.hours + carryMinutes) % 24;
    }
}

class Q4 {
    public static void main(String[] args) {
        System.out.println("===== Time Addition =====");
        
        Time time1 = new Time();
        Time time2 = new Time();
        Time result = new Time();
        
        time1.setTime(10, 45);
        time2.setTime(5, 30);
        
        System.out.print("Time 1: ");
        time1.displayTime();
        
        System.out.print("Time 2: ");
        time2.displayTime();
        
        result.addTime(time1, time2);
        System.out.print("Sum: ");
        result.displayTime();
        
        System.out.println("\n===== Test with Overflow =====");
        Time time3 = new Time();
        Time time4 = new Time();
        
        time3.setTime(23, 50);
        time4.setTime(0, 20);
        
        System.out.print("Time 3: ");
        time3.displayTime();
        
        System.out.print("Time 4: ");
        time4.displayTime();
        
        result.addTime(time3, time4);
        System.out.print("Sum: ");
        result.displayTime();
    }
}

/*
 * Output:
 * 
 * ===== Time Addition =====
 * Time 1: 10:45:30
 * Time 2: 05:30:45
 * Sum: 16:16:15
 * 
 * ===== Test with Overflow =====
 * Time 3: 23:59:50
 * Time 4: 00:00:20
 * Sum: 00:00:10
 */
