package grokking_algorithms.chapter_1;

public class SimpleSearch {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println(simpleSearch(array, 100));
    }

    public static int simpleSearch(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item)
                return i;
        }

        return -1;
    }
}
