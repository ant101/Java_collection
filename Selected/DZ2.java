import java.util.Scanner;
import java.util.Random;

/*
 * Author Malyshev Anton. Homework 2
 *1.Create array consisting of 0 and 1 elements, e.g. int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
 *2.Using loops, change 0 to 1, 1 to 0 at this array;
 *3.Create 8 int numbers array. Fill it with this numbers 1 4 7 10 13 16 19 22 using loops;
 *4.Create array int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }; multiply all numbers less 6 by 2 using loop;
 *5.* Create one dimensional array and find min and max values;
 *6.** Write simple console calculator. User inputs 2 numbers and operation, the program calculates and shows the result;
 *
 */

class DZ2 {
    public static void main (String[] args) {
        //task 1
        Random random = new Random();
        int[] mymassiv = new int[10]; 
        System.out.println ("Task 1. The array:");
        for (int i = 0; i < mymassiv.length; i++) {   
            mymassiv[i] = random.nextInt(2);
            System.out.print(mymassiv[i] + " ");
        }
        
        System.out.println();
        System.out.println ("Task 2. Changed array: ");  //array after changes
        for (int i = 0; i < mymassiv.length; i++) {
        mymassiv[i] = (mymassiv[i] == 0) ? 1 : 0;    //replacing 0 to 1 and 1 to 0
        System.out.print(mymassiv[i] + " ");    
        }

        //task 3/////////////////////////////////////
        System.out.println();
        System.out.println("Task 3. Filled array: ");
        int[] array22 = new int[8];  
        for (int i = 0; i < array22.length; i++) {
        array22[i] = i*3 + 1;
        System.out.print (array22[i] + " ");  
        }

        //task 4/////////////////////////////////////

        System.out.println();
        System.out.println ("Task 4. Unchanged array: ");  //display unchanged array
        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < mas.length; i++) {
            System.out.print (mas[i] + " ");
        }
        
        System.out.println();
        System.out.println ("Task 4. Changed array: ");      //display changed array
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {                    //if element less 6, multiply it by 2
                mas[i] *= 2;
                System.out.print (mas[i] + " ");
            } else {
                System.out.print(mas [i] + " ");
            }
        }
    
        //task 5//////
        System.out.println();
        System.out.println ("Task 5. Array: ");
        int[] odm = {8, 31, 256, 105, 3, 1000, 26, 15000};    
        for (int i = 0; i < odm.length; i++) {
            System.out.print (odm[i] + " ");
        }
        
        int min = odm[0];    //1st element is start number
        int max = odm[0];
        for (int i = 0; i < odm.length-1; i++) {    
            if (min > odm[i+1]) {                    //if current element more than next, than next element is less 
                min = odm[i+1];
            }
            if (max < odm[i+1]) {                    //if current element less than next, than next element is more
                max = odm[i+1];
            }
        }
        System.out.println();
        System.out.println ("Min = " + min);
        System.out.println ("Max = " + max);

        //task 6 calculator///////////////////////////////////////////////
        
        
        double myresult = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Task 6. Calculator. Please enter expression: ");
        String s = sc.nextLine();         //write string to variable
        String[] parts = s.split(" ");    //split it with space
        
        String part1 = parts[0];  //assigning string parts to variables
        String znak = parts[1]; 
        String part3 = parts[2];
                              
        double ch1 = Double.parseDouble(part1);   //convert from String to double
        double ch2 = Double.parseDouble(part3);
                        
            switch (znak) {  //prefrom actions depending on sign 
               case "+":
                   myresult = ch1+ch2;
                   System.out.println("Answer: "+myresult);
                   break;
               case "*":
                   myresult = ch1*ch2;
                   System.out.println("Answer: "+myresult);
                   break;
               case "-":
                   myresult = ch1-ch2;
                   System.out.println("Answer: "+myresult);
                   break;
               case "/":
                   if (ch2 == 0) {          //check for division by zero
                       System.out.println ("You can't divide by zero!");
                } else {
                   myresult = ch1/ch2;
                   System.out.println("Answer: "+myresult);
                       }
                   break;
               }
            
    }

}
