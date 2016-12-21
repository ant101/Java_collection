/**
 * Created by Anton on 15.12.2016.
 */

import java.util.Scanner;

public class AdultOrNot {
    public static void main (String[] args) {
        String res;
        boolean state = true;
        int ageOfMajority = 18;

        Funcs my = new Funcs();
        while (state) {
            my.readData();
            res = my.year < ageOfMajority ? "Immature" : "Adult";
            System.out.println("The man is " + res);
        }
    }
}

class Funcs {
    int year;
    void readData() {
        Scanner sc = new Scanner (System.in);
        this.year = sc.nextInt();
    }
}