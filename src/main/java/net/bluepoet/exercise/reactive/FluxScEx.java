package net.bluepoet.exercise.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by bluepoet on 2016. 12. 17..
 */
public class FluxScEx {
    private final static Logger log = LoggerFactory.getLogger(FluxScEx.class);

    public static void main(String[] args) throws InterruptedException {
//        Flux.range(1, 10)
//                .publishOn(Schedulers.newSingle("pub"))
//                .log()
//                .subscribeOn(Schedulers.newSingle("sub"))
//                .subscribe(System.out::println);

        Flux.interval(Duration.ofMillis(200))
                .take(10)
                .subscribe(s-> log.debug("onNext:{}", s));

        log.debug("exit");
        TimeUnit.SECONDS.sleep(10);

//        Executors.newSingleThreadExecutor().execute(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//            }
//            System.out.println("hello");
//        });
//
//        System.out.println("exit");
    }
}
