package simple.task.window.sliding;

import java.util.Arrays;

public class SlidingWindowMaxSum {

    private final int[] data;

    public SlidingWindowMaxSum(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public int findMaxSum(int consecutiveElements) {
        if (consecutiveElements > data.length) {
            throw new NotEnoughElementsInArrayException(consecutiveElements, data.length);
        }

        int sum = getInitialSum(consecutiveElements);
        int maxSum = sum;

        for (int i = consecutiveElements; i < data.length; i++) {
            int firstElementInSum = data[i - consecutiveElements];
            int newElement = data[i];

            sum = sum - firstElementInSum + newElement;

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    private int getInitialSum(int consecutiveElements) {
        int sum = 0;

        for (int i = 0; i < consecutiveElements; i++) {
            sum += data[i];
        }

        return sum;
    }

}
