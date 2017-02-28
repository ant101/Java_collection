package Threads.problem3;

// Write class MFP, with simultaneous scan and print avalible, wherein you are able to print or scan only one document.
// While printing or scanning, show messages "printed or scanned 1,2,3... pages" with 50 ms interval.

public class mfphome {
    public static void main (String[] args) {
    Thread print1 = new Thread(new print());
    print1.start();
        System.out.println("Print 1 in queue.");
    Thread print2 = new Thread(new print());
    print2.start();
        System.out.println("Print 2 in queue.");

    Thread scan1 = new Thread(new scan());
    scan1.start();
        System.out.println("Scan 1 in queue.");
    Thread scan2 = new Thread(new scan());
    scan2.start();
        System.out.println("Scan 2 in queue.");

    try {
        print1.join();
        System.out.println("Print 1 finished.");
        print2.join();
        System.out.println("Print 2 finished.");
        scan1.join();
        System.out.println("Scan 1 finished.");
        scan2.join();
        System.out.println("Scan 2 finished.");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}