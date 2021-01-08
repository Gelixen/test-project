package simple.recursion.tail;

public class TailRecursion {

    public static void factorial() {
        System.out.println(count(5, 1));
    }

    private static int count(int n, int acc) {
        if (n == 0) {
            return acc;
        }

        return count(n - 1, acc * n);
    }
}
