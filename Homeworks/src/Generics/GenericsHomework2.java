/**
 * Created by Anton Malyshev on 21.01.2017.
 * Java 3 HW#1
 */

//Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;

class Convert<T> {
    private T[] conArr;

    public Convert(T[] arr) {
        this.conArr = arr;
    }

    public void convertToArrayList() {
        ArrayList<T> arlist = new ArrayList();
        for (int i = 0; i < conArr.length; i++) {
            arlist.add(conArr[i]);
        }
        for (T element : arlist) {
            System.out.print(element + " ");
        }
    }
}

public class GenericsHomework2 {
    public static void main(String[] args) {
        sendIntArray();
        System.out.println();
        sendStringArray();
        System.out.println();
        sendFloatArray();
    }

    static void sendIntArray() {
        Integer[] intArr = {58, 1111, 2323, 53533, 2442};
        Convert<Integer> intNum = new Convert(intArr);
        intNum.convertToArrayList();

    }

    static void sendStringArray() {
        String[] strArr = {"First", "Second", "Third", "Fourth"};
        Convert<String> str = new Convert(strArr);
        str.convertToArrayList();

    }

    static void sendFloatArray() {
        Float[] flArr = {434.2f, 21.555f, 242.25f, 2284241.2524f};
        Convert<Float> flObj = new Convert(flArr);
        flObj.convertToArrayList();

    }
}


