package simple.dynamic.fibonacci;

public class BottomUp {

    public int fibonacci(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        int[] memo = new int[number];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < number; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[number - 1] + memo[number - 2];
    }
}