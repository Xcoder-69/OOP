/*
 * Practical Set-2: Q4
 * Write a Java program to create a Time class with hours, minutes, and seconds.
 * Include methods to set time, display time, and add two Time objects.
 */

import java.util.Scanner;

class Time {
    private int hours;
    private int minutes;
    private int seconds;
    
    // Constructor
    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    
    public Time(int h, int m, int s) {
        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }
    
    // Set time
    public void setTime(int h, int m, int s) {
        this.hours = h % 24;
        this.minutes = m % 60;
        this.seconds = s % 60;
    }
    
    // Display time
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }
    
    // Add two time objects
    public Time add(Time t1, Time t2) {
        Time result = new Time();
        result.seconds = (t1.seconds + t2.seconds) % 60;
        int carry = (t1.seconds + t2.seconds) / 60;
        
        result.minutes = (t1.minutes + t2.minutes + carry) % 60;
        carry = (t1.minutes + t2.minutes + carry) / 60;
        
        result.hours = (t1.hours + t2.hours + carry) % 24;
        
        return result;
    }
}

class Q4_Time {
    public static void main(String[] args) {
        System.out.println("========== Time Addition Program ==========\n");
        
        // Create time objects
        Time time1 = new Time(10, 45, 30);
        Time time2 = new Time(5, 30, 45);
        Time result = new Time();
        
        System.out.print("Time 1: ");
        time1.displayTime();
        
        System.out.print("Time 2: ");
        time2.displayTime();
        
        result = result.add(time1, time2);
        System.out.print("Sum: ");
        result.displayTime();
        
        System.out.println("\n========== Another Example ==========");
        Time time3 = new Time(23, 59, 50);
        Time time4 = new Time(0, 0, 20);
        
        System.out.print("Time 3: ");
        time3.displayTime();
        
        System.out.print("Time 4: ");
        time4.displayTime();
        
        result = result.add(time3, time4);
        System.out.print("Sum: ");
        result.displayTime();
    }
}

/*
 * Output:
 * ========== Time Addition Program ==========
 * 
 * Time 1: 10:45:30
 * Time 2: 05:30:45
 * Sum: 16:16:15
 * 
 * ========== Another Example ==========
 * Time 3: 23:59:50
 * Time 4: 00:00:20
 * Sum: 00:00:10
 */
