package simple.task.window.sliding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowSumPerformanceTest {

    private int[] data;
    private int searchableSum;

    @BeforeEach
    void setUp() {
        data = generateData();
        searchableSum = calculateSearchableSum();
        System.out.println("searchableSum: " + searchableSum);
    }

    @Test
    void search() {
        SlidingWindowSum slidingWindowSum = new SlidingWindowSum(data);

        int[] unoptimizedSearchResult = timedExecution("Unoptimized", slidingWindowSum::search);
        int[] optimizedSearchResult = timedExecution("Optimized", slidingWindowSum::searchOptimized);

        assertArrayEquals(unoptimizedSearchResult, optimizedSearchResult);
    }

    private int[] generateData() {
        int[] data = new int[500_000_000];

        for (int i = 0; i < data.length; i++) {
            data[i] = new Random().nextInt(10_000);
        }

        return data;
    }

    private int calculateSearchableSum() {
        int consecutiveNumbers = 300_000;
        int startIndexOfSum = new Random().nextInt(data.length - consecutiveNumbers);

        System.out.println("Searchable sum starts at: " + startIndexOfSum);

        return Arrays.stream(data, startIndexOfSum, startIndexOfSum + consecutiveNumbers)
                .reduce(0, (oldSum, number) ->  {
                    int newSum = oldSum + number;
                    if (newSumOverflowMaxIntegerValue(newSum)) {
                        return oldSum;
                    } else {
                        return newSum;
                    }
                });
    }

    private boolean newSumOverflowMaxIntegerValue(int newSum) {
        return newSum <= 0;
    }

    private int[] timedExecution(String name, Function<Integer, int[]> function) {
        long start = System.currentTimeMillis();
        int[] result = function.apply(searchableSum);
        long end = System.currentTimeMillis();

        System.out.println(name + " time: " + (end - start));

        return result;
    }
}