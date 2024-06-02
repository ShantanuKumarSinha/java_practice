package shann.java.problems.HalfDone;

import java.util.*;


public class CeramicStore {
    public static void runAndWait(List<Runnable> runnables) throws InterruptedException {
        Thread t1 = null;
        for (Runnable runnable: runnables){
            t1 = new Thread(runnable);
            t1.start();
        }
        t1.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(800);
                System.out.println("Slow function");
            } catch(Exception e) {}
        }, () -> {
            try {
                Thread.sleep(100);
                System.out.println("Fast function");
            } catch(Exception e) {}
        });

        // Expected output:
        // Fast function
        // Slow function
        // Returned from the method!
        runAndWait(runnables);
//        var t = Thread.currentThread();
//        t.wait();
        System.out.println("Returned from the method!");
    }
}