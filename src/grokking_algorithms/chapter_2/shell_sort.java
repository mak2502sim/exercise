package grokking_algorithms.chapter_2;

import java.util.Arrays;

public class shell_sort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 65, 844, 0, 15, 32, 451, 5, 1, 100};

        System.out.println(Arrays.toString(shellSort(array)));
    }

    public static int[] shellSort(int[] array) {
        int gap = array.length / 2;
        while(gap >= 1) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        int temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
        return array;
    }
}