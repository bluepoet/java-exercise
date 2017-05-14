package net.bluepoet.exercise.algorithm;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by daumkakao on 2017. 5. 15..
 */
public class QuickSort {
    public static void main(String[] args) {
        Arrays.stream(quickSort(new int[]{5, 3, 10, 6, -1, 5, -2, 0})).forEach(i -> System.out.println(i));
    }

    private static int[] quickSort(int[] arr) {
        if(arr == null) return ArrayUtils.EMPTY_INT_ARRAY;

        if (arr.length < 2) {
            return arr;
        } else {
            int pivot = arr[0];
            int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
            int[] less = null;
            int[] greater = null;
            int lessSize = 0;
            int greaterSize = 0;

//            for (int i = 0; i < newArr.length; i++) {
//                if (newArr[i] <= pivot) lessSize++;
//                else greaterSize++;
//            }
//
//            less = new int[lessSize];
//            greater = new int[greaterSize];

            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] <= pivot) less = ArrayUtils.add(less, newArr[i]);
                else greater = ArrayUtils.add(greater, newArr[i]);
            }

            return IntStream.concat(Arrays.stream(quickSort(less)), IntStream.concat(Arrays.stream(new int[]{pivot}), Arrays.stream(quickSort(greater)))).toArray();
        }
    }
}
