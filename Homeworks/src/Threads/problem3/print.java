package Threads.problem3;

import static java.lang.Thread.sleep;

/**
 * Created by User on 25.02.2017.
 */
public class print implements Runnable{
    private static Object printLock = new Object();
    @Override
    public void run() {
        synchronized (printLock) {
            System.out.println("Print started.");
            for (int i = 1; i < 11; i++) {
                System.out.println(i + " pages printed.");
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Print end.");
        }
    }
}
