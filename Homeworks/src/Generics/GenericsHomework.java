/**
 * Created by Anton Malyshev on 21.01.2017.
 * Java 3 HomeWork #1
 */

//Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

class swapElements<T> {
    private T[] swapArr;

    public swapElements(T[] arr) {
        this.swapArr = arr;
    }

    public void swap() {
        T temp = swapArr[0];
        swapArr[0] = swapArr[1];
        swapArr[1] = temp;
    }

    void printArray() {
        for (T element : swapArr) {
            System.out.print(element + " ");
        }
    }
}

public class GenericsHomework {
    public static void main(String[] args) {
        sendIntArray();
        System.out.println();
        sendStringArray();
        System.out.println();
        sendFloatArray();
    }

    static void sendIntArray() {
        Integer[] intArr = {58, 1111};
        swapElements<Integer> intObj = new swapElements(intArr);
        System.out.println("Изначальный Integer массив: ");
        intObj.printArray();
        System.out.println();
        intObj.swap();
        System.out.println("Измененный Integer массив: ");
        intObj.printArray();
    }

    static void sendStringArray() {
        String[] strArr = {"First", "Second"};
        swapElements<String> strObj = new swapElements(strArr);
        System.out.println("Изначальный String массив: ");
        strObj.printArray();
        System.out.println();
        strObj.swap();
        System.out.println("Измененный String массив: ");
        strObj.printArray();
    }

    static void sendFloatArray() {
        Float[] flArr = {434.2f, 21.555f};
        swapElements<Float> flObj = new swapElements(flArr);
        System.out.println("Изначальный Float массив: ");
        flObj.printArray();
        System.out.println();
        flObj.swap();
        System.out.println("Измененный Float массив: ");
        flObj.printArray();
    }
}

