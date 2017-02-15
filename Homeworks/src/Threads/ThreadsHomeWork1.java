package Threads;

/**
 * Created by Anton on 11.02.2017.
 */

//Домашнее задание
//        Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз, порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.


public class ThreadsHomeWork1 {

    private static char currentChar = 'A';
    private Object mon = new Object();


    public static void main(String[] args) {
        System.out.println("Start");
        ThreadsHomeWork1 mct = new ThreadsHomeWork1();

        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mct.printA();
            }
        });
        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mct.printB();
            }
        });
        Thread cThread = new Thread(() -> mct.printC());    //можно написать лямбдой

        aThread.start();
        bThread.start();
        cThread.start();

        try {
            aThread.join();
            bThread.join();
            cThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nEnd");
    }

        public void printA() {
            synchronized (mon) {
                try{
                    for (int i = 0; i < 5; i++) {
                        while (currentChar != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentChar = 'B';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printB() {
            synchronized (mon) {
                try{
                    for (int i = 0; i < 5; i++) {
                        while (currentChar != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentChar = 'C';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printC() {
            synchronized (mon) {
                try{
                    for (int i = 0; i < 5; i++) {
                        while (currentChar != 'C') {
                            mon.wait();
                        }
                        System.out.print("C");
                        currentChar = 'A';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}

