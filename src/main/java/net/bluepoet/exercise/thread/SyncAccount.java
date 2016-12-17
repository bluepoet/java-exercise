package net.bluepoet.exercise.thread;

/**
 * Created by bluepoet on 2016. 11. 16..
 */
public class SyncAccount {
    private int balance;

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int val) {
        balance += val;
    }

    public synchronized boolean withdraw(int val) {
        if(balance >= val) {
            balance -= val;
            return true;
        }
        return false;
    }
}
