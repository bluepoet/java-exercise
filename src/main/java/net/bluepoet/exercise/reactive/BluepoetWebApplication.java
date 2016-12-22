package net.bluepoet.exercise.reactive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Created by bluepoet on 2016. 12. 22..
 */

// 용어 찾아보기 : thread 늘리면 -> Context switching(cpu), stack trace(memory)
// cpu-bound 작업
@SpringBootApplication
@Slf4j
@EnableAsync
public class BluepoetWebApplication {

    @RestController
    public static class MyController {
        @GetMapping("/callable")
//        public Callable<String> callable() throws InterruptedException {
//            log.info("callable");
//            return () -> {
//                log.info("async");
//                Thread.sleep(2000);
//                return "hello";
//            };
//        }
        public String callable() throws InterruptedException {
            log.info("async");
            Thread.sleep(2000);
            return "hello";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BluepoetWebApplication.class, args);
    }
}
