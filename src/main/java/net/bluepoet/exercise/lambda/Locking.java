package net.bluepoet.exercise.lambda;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by daumkakao on 2017. 4. 11..
 */
public class Locking {
    Lock lock = new ReentrantLock();

    protected void setLock(final Lock mock) {
        this.lock = mock;
    }

    public void doOp1() {
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }

    public static void runLocked(Lock lock, Runnable block) {
        lock.lock();
        try {
            block.run();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        runLocked(new ReentrantLock(), () -> System.out.println("1"));
        runLocked(new ReentrantLock(), () -> System.out.println("2"));
        runLocked(new ReentrantLock(), () -> System.out.println("3"));
    }
}
