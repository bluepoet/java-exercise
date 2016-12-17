package net.bluepoet.exercise.thread;

import java.util.stream.IntStream;

/**
 * Created by bluepoet on 2016. 11. 16..
 */
public class UnsafeAccountSample {
    public static void main(String[] args) {
        final UnsafeAccount account = new UnsafeAccount();
        account.deposit(5000);

        Runnable withdrawRun = new Runnable() {
            @Override
            public void run() {
                boolean result = account.withdraw(3000);
                System.out.println("result = " + result + ", balance = " + account.getBalance());
            }
        };

        IntStream.range(0, 100).forEach(i -> {
            Thread t = new Thread(withdrawRun);
            t.start();
        });
    }
}
