package net.bluepoet.exercise.thread;

/**
 * Created by bluepoet on 2016. 11. 15..
 */
public class RandomMain2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RandomRunnable("t1"));
        Thread t2 = new Thread(new RandomRunnable("t2"));
        t2.setDaemon(true);

        t1.start();

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        System.out.println("main() : 실행중");
    }
}
