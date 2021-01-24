package simple.task.window.sliding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlidingWindowMaxSumTest {

    @Test
    void findMaxSum_increasingValues() {
        int consecutiveElements = 2;
        int[] data = {100, 200, 300, 400};
        SlidingWindowMaxSum slidingWindowMaxSum = new SlidingWindowMaxSum(data);

        int maxSum = slidingWindowMaxSum.findMaxSum(consecutiveElements);

        assertEquals(700, maxSum);
    }

    @Test
    void findMaxSum_randomValues() {
        int consecutiveElements = 4;
        int[] data = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        SlidingWindowMaxSum slidingWindowMaxSum = new SlidingWindowMaxSum(data);

        int maxSum = slidingWindowMaxSum.findMaxSum(consecutiveElements);

        assertEquals(39, maxSum);
    }

    @Test
    void findMaxSum_notEnoughElements_throwsNotEnoughElementsInArrayException() {
        int consecutiveElements = 3;
        int[] data = {2, 3};
        SlidingWindowMaxSum slidingWindowMaxSum = new SlidingWindowMaxSum(data);

        assertThrows(
                NotEnoughElementsInArrayException.class,
                () -> slidingWindowMaxSum.findMaxSum(consecutiveElements)
        );
    }
}