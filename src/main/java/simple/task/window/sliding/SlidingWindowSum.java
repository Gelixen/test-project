package simple.task.window.sliding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SlidingWindowSum {

    private final int[] data;

    public SlidingWindowSum(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    // O(n^2)
    public int[] search(int searchableSum) {
        for (int i = 0; i < data.length; i++) {
            int sum = data[i];
            for (int j = i + 1; j < data.length; j++) {
                sum += data[j];

                if (sum == searchableSum) {
                    return IntStream.rangeClosed(i, j).map(index -> data[index]).toArray();
                }

                if (sum > searchableSum) {
                    break;
                }
            }
        }

        return new int[]{};
    }

    // O(n?)
    public int[] searchOptimized(int searchableSum) {
        int sum = 0;
        int rangeStartIndex = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];

            while (sum >= searchableSum) {
                if (searchableSum == sum) {
                    return IntStream.rangeClosed(rangeStartIndex, i).map(index -> data[index]).toArray();
                }

                sum -= data[rangeStartIndex];
                rangeStartIndex++;
            }
        }

        return new int[]{};
    }
}
