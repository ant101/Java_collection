package Misc;

/*
 * Author Malyshev Anton. HW n.1
 * 06.10.16
 * Write a metod, which defines if year leap or not. Every 4th year is leap, except every 100th, and every 400th is leap.
 */

import java.util.Scanner;
 
class LeapOrNotDZ1 {

    static int year = 0;
    static String leapOrNot;

    public static void main (String[] args) {
        while (true) {
            readData();
            writeData();
        }
    }
    
    static void readData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        year = sc.nextInt();
    }
    
    static boolean leapCalc (int year) { 
        return ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 );
    }
    
    static void writeData() {
        System.out.println("Year " + year + " is " + (leapCalc(year) == true ? "leap" : "not leap")   );
    }
}

//