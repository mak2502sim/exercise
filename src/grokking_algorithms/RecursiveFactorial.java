package grokking_algorithms;

public class RecursiveFactorial {
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
