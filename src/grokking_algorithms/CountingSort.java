package grokking_algorithms;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 65, 844, 0, 15, 32, 451, 5, 1, 100};

        System.out.println(Arrays.toString(countingSort(array, Arrays.stream(array).max().getAsInt())));
    }

    public static int[] countingSort(int[] sourceArray, int maxValue) {
        int[] counts = new int[maxValue + 1];

        for (int i :
                sourceArray) {
            counts[i]++;
        }

        int[] sortedArray = new int[sourceArray.length];
        int sortedCounts = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                sortedArray[sortedCounts++] = i;
            }
        }
        return sortedArray;
    }
}
