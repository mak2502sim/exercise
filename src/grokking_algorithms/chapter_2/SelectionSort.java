package grokking_algorithms.chapter_2;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 65, 844, 0, 15, 32, 451, 5, 1, 100};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
