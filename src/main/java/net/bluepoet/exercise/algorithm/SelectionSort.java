package net.bluepoet.exercise.algorithm;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * Created by bluepoet on 2017. 5. 11..
 */
public class SelectionSort {
    public static void main(String[] args) {
        Arrays.stream(selectionSort(new int[]{5, 3, 10, 6, -1})).forEach(i -> System.out.println(i));
//        System.out.println(ArrayUtils.removeElement(new int[]{1,2,3}, 1)[1]);
    }

    private static int[] selectionSort(int[] integers) {
        int[] sortedArr = new int[5];

        for (int i = 0; i < 5; i++) {
            int smallest_index = findSmallest(integers);
            sortedArr[i] = integers[smallest_index];
            integers = ArrayUtils.remove(integers, smallest_index);
        }
        return sortedArr;
    }

    private static int findSmallest(int[] integers) {
        int smallest = integers[0];
        int smallest_index = 0;

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < smallest) {
                smallest = integers[i];
                smallest_index = i;
            }
        }

        return smallest_index;
    }
}
