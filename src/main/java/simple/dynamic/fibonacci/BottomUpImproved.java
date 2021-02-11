package simple.dynamic.fibonacci;

public class BottomUpImproved {

    public int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i < number; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a + b;
    }
}