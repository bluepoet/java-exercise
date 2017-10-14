package net.bluepoet.exercise.reactive;

import reactor.core.publisher.Flux;

/**
 * Created by bluepoet on 2017. 10. 13..
 */
public class ReactorEx {
    public static void main(String[] args) {
        Flux.<Integer>create(e -> {
            e.next(1);
            e.next(2);
            e.next(3);
            e.complete();
        })
                .log()
                .map(s -> s * 10)
                .reduce(0, (a, b) -> a + b)
                .log()
                .subscribe(System.out::println);
    }
}
