package net.bluepoet.exercise.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by daumkakao on 2017. 4. 4..
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("bluepoet", "emin", "tester");
        names.forEach(System.out::println);

        final List<String> upperNames = new ArrayList<>();
        names.forEach(name -> upperNames.add(name.toUpperCase()));
        System.out.println(upperNames);
        names.stream().map(String::toUpperCase).forEach(name -> System.out.println(name));

        final List<String> startsWithb = names.stream().filter(name -> name.startsWith("b")).collect(Collectors.toList());
        System.out.println(startsWithb);

        final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

        names.stream().filter(startsWithLetter.apply("e")).forEach(System.out::println);
    }
}
