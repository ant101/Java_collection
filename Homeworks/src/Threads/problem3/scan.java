package Threads.problem3;

import static java.lang.Thread.sleep;

/**
 * Created by User on 25.02.2017.
 */
public class scan implements Runnable{
    private static Object scanLock = new Object();
    @Override
    public void run() {
        synchronized (scanLock) {
            System.out.println("Scan started.");
            for (int i = 1; i < 11; i++) {
                System.out.println(i + " pages scanned.");
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Scan end.");
        }
    }
}
