package net.bluepoet.exercise.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by bluepoet on 2016. 12. 2..
 */
public class NumberSumCallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> sumFuture1 = executorService.submit(new SumCallable(1, 100));
        futures.add(sumFuture1);
        Future<Integer> sumFuture2 = executorService.submit(new SumCallable(101, 200));
        futures.add(sumFuture2);
        Future<Integer> sumFuture3 = executorService.submit(new SumCallable(201, 300));
        futures.add(sumFuture3);
        Future<Integer> sumFuture4 = executorService.submit(new SumCallable(301, 400));
        futures.add(sumFuture4);
        Future<Integer> sumFuture5 = executorService.submit(new SumCallable(401, 500));
        futures.add(sumFuture5);
        Future<Integer> sumFuture6 = executorService.submit(new SumCallable(501, 600));
        futures.add(sumFuture6);

        for(Future<Integer> future: futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
