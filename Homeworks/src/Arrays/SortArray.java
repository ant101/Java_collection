package Arrays;

import java.util.Random;
import java.util.Arrays;

/**
 * Created by Anton on 08.05.2017.
 */
public class SortArray {
    public static void main(String[] args) {
        Random random = new Random();
        int[] myarr = new int[20];
        //int[] myarr = {23253, 0, -1, 355, 426, 531, 53, 53, -1, 43, 62, 426, 0, 433, 53, -32, 1};
        int[] printArray;

        for (int i = 0; i < myarr.length; i++) {    //fill arrray with random numbers
            myarr[i] = i * (random.nextInt(385) - 200);
        }
        System.out.println("Origin array: " + Arrays.toString(myarr));
        printArray = sortAscending(myarr);
        System.out.println("Sorted ascending array: " + Arrays.toString(printArray));
        printArray = sortDescending(myarr);
        System.out.println("Sorted descending array: " + Arrays.toString(printArray));

    }

    static int[] sortAscending(int[] sortedArray) {
        int temp = 0;
        for (int i = 0; i < sortedArray.length - 1; i++) {    //choose 1st number
            for (int j = i + 1; j < sortedArray.length; j++) {    //choose 2nd number to compare
                if (sortedArray[i] > sortedArray[j]) {      //if 2nd is lower
                    temp = sortedArray[j];     //remember 2nd
                    for ( ; j > i; j--) {       //for all numbers between 1st and 2nd
                        sortedArray[j] = sortedArray[j - 1];    //swap all numbers to the right to position of 2nd number
                    }
                    sortedArray[i] = temp;    //place 2nd number to position of 1st number
                }
            }
        }
        return sortedArray;
    }

    static int[] sortDescending(int[] sortedArray) {
        int temp = 0;
        for (int i = 0; i < sortedArray.length - 1; i++) {    //choose 1st number
            for (int j = i + 1; j < sortedArray.length; j++) {    //choose 2nd number to compare
                if (sortedArray[i] < sortedArray[j]) {      //if 2nd is higher
                    temp = sortedArray[j];     //remember 2nd
                    for ( ; j > i; j--) {       //for all numbers between 1st and 2nd
                        sortedArray[j] = sortedArray[j - 1];    //swap all numbers to the right to position of 2nd number
                    }
                    sortedArray[i] = temp;    //place 2nd number to position of 1st number
                }
            }
        }
        return sortedArray;
    }
}
