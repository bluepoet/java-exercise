package net.bluepoet.exercise.thread;

/**
 * Created by bluepoet on 2016. 11. 16..
 */
public class SyncBlockAccount {
    private int balance;
    private Object lock = new Object();

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int val) {
        balance += val;
    }

    public boolean withdraw(int val) {
        synchronized (lock) {
            if (balance >= val) {
                balance -= val;
                return true;
            }
        }
        return false;
    }
}
