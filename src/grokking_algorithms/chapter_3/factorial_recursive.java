package grokking_algorithms.chapter_3;

public class factorial_recursive {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }

    public static int fact (int x) {
        if (x == 1)
            return 1;
        else
            return x * fact(x - 1);
    }
}
