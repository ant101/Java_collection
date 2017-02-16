package Threads.Drafts;

/**
 * Created by Anton on 11.02.2017.
 */
public class ExampleDeadLock { private static final Object lock1 = new Object(); private static final Object lock2 = new Object(); public static void main(String[] args) { ThreadOne threadOne = new ThreadOne(); ThreadTwo threadTwo = new ThreadTwo(); threadOne.start(); threadTwo.start(); } private static class ThreadOne extends Thread { public void run() { synchronized (lock1) { System.out.println("Thread1 is holding LOCK 1"); try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } System.out.println("Thread1 is waiting for Lock 2"); synchronized (lock2) { System.out.println("Thread1 is holding Lock 1 and Lock 2"); } } } } private static class ThreadTwo extends Thread { public void run() { synchronized (lock2) { System.out.println("Thread2 is holding LOCK 2"); try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); } System.out.println("Thread2 is waiting for Lock 1"); synchronized (lock1) { System.out.println("Thread2 is holding Lock 1 and Lock 2"); } } } } }
