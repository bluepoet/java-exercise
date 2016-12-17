package net.bluepoet.exercise.thread;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by bluepoet on 2016. 11. 15..
 * 최범균 16장 list 16.1
 */
public class RandomRunnable implements Runnable {
    private String name;

    public RandomRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> {
            System.out.println(name + " : " + random.nextInt(100));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
