package net.bluepoet.exercise.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by daumkakao on 2017. 1. 25..
 */
public class ConsistentHash<T> {
    private final HashFunction hashFunction;
    private final int numberOfReplicas;
    private final SortedMap<String, T> circle = new TreeMap<>();

    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;

        for (T node : nodes) {
            add(node);
        }
    }

    private void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunction.hash(node.toString() + i), node);
        }
    }

    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunction.hash(node.toString() + i));
        }
    }

    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }

        String hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<String, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }

        return circle.get(hash);
    }

    public static void main(String[] args) {
        HashFunction hashFunction = new HashFunction();
        Collection<String> nodes = new ArrayList<>();
        nodes.add("iaso-topic1");
        nodes.add("iaso-topic2");
        nodes.add("iaso-topic3");
        ConsistentHash<String> consistentHash = new ConsistentHash<>(hashFunction, 100, nodes);

        Map<String, Integer> result = new HashMap<>();

        for (int i = 1; i <= 100; i++) {
//            System.out.println(i + " : " + consistentHash.get(Integer.toString(i)));

              if(result.get(consistentHash.get(Integer.toString(i))) == null) {
                  result.put(consistentHash.get(Integer.toString(i)), 1);
              }else{
                  result.put(consistentHash.get(Integer.toString(i)), result.get(consistentHash.get(Integer.toString(i))) +1);
              }
        }

        for(Map.Entry<String, Integer> elem : result.entrySet()) {
            System.out.println(elem.getKey() + " : " + elem.getValue());
        }
    }
}
