package grokking_algorithms.chapter_2;

import java.util.Arrays;

public class bubble_sort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 65, 844, 0, 15, 32, 451, 5, 1, 100};

        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] array) {
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;

                    isContinue = true;
                }
            }
        }
        return array;
    }
}
