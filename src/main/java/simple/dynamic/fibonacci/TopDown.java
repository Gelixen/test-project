package simple.dynamic.fibonacci;

public class TopDown {

    // a.k.a. memoization
    public int fibonacci(int number) {
        return fibonacci(number, new int[number + 1]);
    }

    int fibonacci(int number, int[] memo) {
        if (number == 0 || number == 1) {
            return number;
        }

        if (memo[number] == 0) {
            memo[number] = fibonacci(number - 1, memo) + fibonacci(number - 2, memo);
        }

        return memo[number];
    }
}