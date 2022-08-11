package grokking_algorithms.chapter_4;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 65, 844, 0, 15, 32, 451, 5, 1, 100));

        System.out.println(sum(list));
    }

    public static int sum(ArrayList<Integer> list) {
        if (list.size() == 1)
            return list.get(0);
        else
            return list.remove(0) + sum(list);
    }
}
