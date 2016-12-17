package net.bluepoet.exercise.thread;

/**
 * Created by bluepoet on 2016. 11. 16..
 */
public class UnsafeAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int val) {
        balance += val;
    }

    public boolean withdraw(int val) {
        if(balance >= val) {
            balance -= val;
            return true;
        }
        return false;
    }
}
