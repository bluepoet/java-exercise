package net.bluepoet.exercise.lambda.kevin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by daumkakao on 2017. 4. 13..
 */
public class FunctionalInterfaceExamples {
    private static <T> List<T> filter(List<T> numbers, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : numbers) {
            if (filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }

    private static String getVeryExpensive() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "bluepoet";
    }

    private static void printfValueIndex(int number, Supplier<String> valueSupplier) {
        if (number > 0) {
            System.out.println("the value is " + valueSupplier.get());
        } else {
            System.out.println("invalid");
        }
    }

    public static void main(String[] args) {
        Function<String, Integer> toInt = i -> Integer.parseInt(i);

        System.out.println(toInt.apply("2"));

        final Function<Integer, Integer> identity = Function.identity();

        System.out.println(identity.apply(1));

        final Consumer<String> print = i -> System.out.println(i);

        print.accept("bluepoet");

        Predicate<Integer> isPositive = i -> i > 0;

        System.out.println(isPositive.test(2));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, -1, -5);

        System.out.println(filter(numbers, i -> i < 0));
        System.out.println(filter(numbers, i -> i > 3));

        final Supplier<String> helloSupplier = () -> "hello bluepoet";

        System.out.println(helloSupplier.get());

        long start = System.currentTimeMillis();
        printfValueIndex(1, () -> getVeryExpensive());
        printfValueIndex(0, () -> getVeryExpensive());
        printfValueIndex(-1, () -> getVeryExpensive());
        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds");

        println(1, 2, 3, (t1, t2, t3) -> String.valueOf(t1 + t2 + t3));


        BigDecimalToCurrency bigDecimalToCurrency = bd -> bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }
}

interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}


