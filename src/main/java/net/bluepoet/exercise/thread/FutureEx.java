package net.bluepoet.exercise.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * Created by bluepoet on 2016. 12. 20..
 */
public class FutureEx {
    private final static Logger log = LoggerFactory.getLogger(FutureEx.class);

    interface SuccessCallback {
        void onSuccess(String result);
    }

    interface ExceptionCallback {
        void onError(Throwable t);
    }

    public static class CallbackFutureTask extends FutureTask<String> {
        SuccessCallback sc;
        ExceptionCallback ec;

        public CallbackFutureTask(Callable<String> callable, SuccessCallback sc, ExceptionCallback ec) {
            super(callable);
            this.sc = Objects.requireNonNull(sc);
            this.ec = Objects.requireNonNull(ec);
        }

        @Override
        protected void done() {
            try {
                sc.onSuccess(get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
               ec.onError(e.getCause());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newCachedThreadPool();

        CallbackFutureTask f = new CallbackFutureTask(() -> {
            Thread.sleep(2000);
            log.info("Async");
            if(true) throw new RuntimeException("Async Error!");
            return "bluepoet";
        }, System.out::println, e -> System.out.println("Error:" + e.getMessage()));

//        FutureTask<String> f = new FutureTask<String>(() -> {
//            Thread.sleep(2000);
//            log.info("Async");
//            return "bluepoet";
//        }) {
//            @Override
//            protected void done() {
//                try {
//                    System.out.println(get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        };

        es.execute(f);
        es.shutdown();
//        Future<String> f = es.submit(() -> {
//            Thread.sleep(2000);
//            log.info("Async");
//            return "hello";
//        });

//        System.out.println(f.isDone());
//        Thread.sleep(2100);
//        log.info("Exit");
//        System.out.println(f.isDone());
//        System.out.println(f.get()); // Blocing non-Blocking
    }
}
