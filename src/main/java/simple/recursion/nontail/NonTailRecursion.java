package simple.recursion.nontail;

public class NonTailRecursion {

    public static void factorial() {
        System.out.println(count(5));
    }

    private static int count(int n) {
        if (n == 0) {
            return 1;
        }

        return n * count(n - 1);
    }
}
