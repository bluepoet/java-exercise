package net.bluepoet.exercise.lambda;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by daumkakao on 2017. 4. 5..
 */
public class StringTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        "bluepoet".chars().forEach(IterateString::printChar);

        List<Person> people = Arrays.asList(
                new Person("john", 20),
                new Person("sara", 21),
                new Person("greg", 38),
                new Person("emin", 21)
        );

        people.stream().sorted((person1, person2) -> person1.ageDifference(person2)).forEach(p -> System.out.println(p.getAge()));
        people.stream().sorted(Person::ageDifference).forEach(p -> System.out.println(p.getAge()));

        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();
        people.stream().sorted(compareDescending).forEach(p -> System.out.println(p.getAge()));

        people.stream().sorted((person1, person2) -> person1.getName().compareTo(person2.getName())).forEach(p -> System.out.println(p.getName()));

        people.stream().min(Person::ageDifference).ifPresent(p -> System.out.println(p.getAge()));

        final Path path = Paths.get("/Users/daumkakao/project/PrivateProject/java-exercise/src/main/java/net/bluepoet/exercise/lambda");
        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        final WatchKey watchKey = watchService.poll(30, TimeUnit.SECONDS);
        if(watchKey != null) {
            watchKey.pollEvents().stream().forEach(event -> System.out.println(event.context()));
        }
    }

    public static class IterateString {
        private static void printChar(int aChar) {
            System.out.println((char) aChar);
        }
    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int ageDifference(Person other) {
            return this.age - other.age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
