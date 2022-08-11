package grokking_algorithms.chapter_2;

import java.util.Arrays;

public class ShuttleSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 65, 844, 0, 15, 32, 451, 5, 1, 100};
        shuttleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                for (int j = i - 1; (j - 1) >= 0; j--) {
                    if (array[j] < array[j - 1]) {
                        temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
