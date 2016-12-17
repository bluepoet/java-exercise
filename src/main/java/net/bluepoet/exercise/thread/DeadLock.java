package net.bluepoet.exercise.thread;

/**
 * Created by bluepoet on 2016. 11. 16..
 */
public class DeadLock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void some() {
        synchronized (lock1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            any2();
        }
    }

    public void any() {
        synchronized (lock2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            some();
        }
    }

    private void any2() {
        synchronized (lock2) {
            System.out.println("lock2...");
        }
    }
}
