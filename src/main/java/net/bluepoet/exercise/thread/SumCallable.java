package net.bluepoet.exercise.thread;

import java.util.concurrent.Callable;

/**
 * Created by bluepoet on 2016. 12. 2..
 */
public class SumCallable implements Callable<Integer> {
    private int from;
    private int to;

    public SumCallable(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i=from; i<=to; i++) {
            sum += i;
//            try {
//                Thread.sleep(50);
//            }catch(InterruptedException e) {
//
//            }
        }
        return sum;
    }
}
