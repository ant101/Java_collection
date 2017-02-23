package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Created by Anton on 04.02.2017.
 */

/*
1)Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;

2) Последовательно сшить 5 файлов в один (файлы также ~100 байт).
Может пригодиться следующая конструкция:
ArrayList<InputStream> al = new ArrayList<>();
...
Enumeration<InputStream> e = Collections.enumeration(al);

3) Написать консольное приложение, которое умеет постранично читать текстовые файлы
(размером > 10 mb), вводим страницу, программа выводит ее в консоль (за страницу можно
принять 1800 символов).
Время чтения файла должно находится в разумных пределах
(программа не должна загружаться дольше 10 секунд), ну и чтение тоже не должно занимать
>5 секунд.
 */

public class IOHomeWork1 {

    public static void main (String[] args) {
        problem1();
        problem2();
        problem3();
    }

    static void problem1() {
        byte[] bytearr = new byte[50];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src\\IO\\files\\1st.txt");
            fis.read(bytearr);
            fis.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(byte ch : bytearr) {
            System.out.print(ch + " ");
        }
        System.out.println("\nПервое задание выполнено.");
    }

    static void problem2() {
        long t = System.currentTimeMillis();
        ArrayList<InputStream> a1 = new ArrayList<>();
        InputStream tempBIS;
       int x;
        try {
            a1.add(new BufferedInputStream(new FileInputStream("src\\IO\\files\\11.txt")));
            a1.add(new BufferedInputStream(new FileInputStream("src\\IO\\files\\22.txt")));
            a1.add(new BufferedInputStream(new FileInputStream("src\\IO\\files\\33.txt")));
            a1.add(new BufferedInputStream(new FileInputStream("src\\IO\\files\\44.txt")));
            a1.add(new BufferedInputStream(new FileInputStream("src\\IO\\files\\55.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<InputStream> myEnum = Collections.enumeration(a1);
        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src\\IO\\files\\66.txt"));
            while (myEnum.hasMoreElements()) {
                tempBIS = myEnum.nextElement();
                while ( (x = tempBIS.read()) != -1) {
                    out.write(x);
                }
            }
            out.close();
            for (InputStream is : a1) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Второе задание выполнено за " + (System.currentTimeMillis() - t) + " мс.");
    }

    static void problem3() {
        File book = new File("src\\IO\\files\\book.txt");
        Scanner sc = new Scanner(System.in);
        int enteredPageNumber = 0, x = 0, counter = 0;
        long t;
        final long ONEPAGE = 1800;

        try {
            System.out.print("Введите номер страницы: ");
            enteredPageNumber = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Не правильный ввод!");
        }

        try {
            t = System.currentTimeMillis();
            RandomAccessFile raf = new RandomAccessFile(book, "r");
            raf.seek(ONEPAGE * enteredPageNumber);

            for (int i = 0; i < ONEPAGE; i++) {
                if ((x = raf.read()) != -1) {
                    System.out.print((char) x);
                }
            }

            System.out.println("\nВремя чтения из файла в консоль:" + (System.currentTimeMillis() - t) + " мс.\nВыход из програмы");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}