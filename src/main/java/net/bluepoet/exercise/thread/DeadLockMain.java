package net.bluepoet.exercise.thread;

/**
 * Created by bluepoet on 2016. 11. 16..
 */
public class DeadLockMain {
    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.some();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.any();
            }
        });

        t1.start();
        t2.start();
    }
}
