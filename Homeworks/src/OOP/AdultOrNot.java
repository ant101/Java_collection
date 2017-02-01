package OOP;

/**
 * Created by Anton on 15.12.2016.
 * @author Anton 
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdultOrNot {
    public static void main (String[] args) {
        final int AGEOFMAJORITY = 18;

        ReadNumber man = new ReadNumber();
        while (true) {
            try {
                man.readData();
                if (man.year > 0) {
                    System.out.println("This man is " + (man.year < AGEOFMAJORITY ? "immature" : "adult"));
                } else {
                    System.out.println("Enter positive above zero number only!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter positive integer number only!");
            }
        }
    }
}

class ReadNumber {
    int year;
    void readData() {
        System.out.print("Enter age:");
        Scanner sc = new Scanner (System.in);
        this.year = sc.nextInt();
    }
}