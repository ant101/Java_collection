package Threads;

import java.io.*;

import static java.lang.Thread.sleep;


/**
 * Created by Anton on 11.02.2017.
 */

// Write a small method, wherein 3 threads write data to file line by line (10 lines each thread, 20 ms interval)

public class ThreadsHomeWork2 {
    public static void main(String[] args) {
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Threads\\file3.txt",true));
                    for (int i = 1; i < 11; i++) {
                        bw.write("1st thread, " + i + " record.\n");
                        sleep(20);
                    }
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        });

        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Threads\\file3.txt",true));
                    for (int i = 1; i < 11; i++) {
                        bw.write("2nd thread, " + i + " record.\n");
                        sleep(20);
                    }
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        });

        Thread third = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Threads\\file3.txt",true));
                    for (int i = 1; i < 11; i++) {
                        bw.write("3rd thread, " + i + " record.\n");
                        sleep(20);
                    }
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        });
        first.start();
        second.start();
        third.start();

        try {
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
