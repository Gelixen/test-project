package simple.task.window.sliding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SlidingWindowSumTest {

    private static Stream<Arguments> search() {
        return Stream.of(
                Arguments.of(
                        arrayOf(),
                        1,
                        arrayOf()
                ),
                Arguments.of(
                        arrayOf(4, 8),
                        1,
                        arrayOf()
                ),
                Arguments.of(
                        arrayOf(4, 8),
                        12,
                        arrayOf(4, 8)
                ),
                Arguments.of(
                        arrayOf(1, 3, 5, 2),
                        8,
                        arrayOf(3, 5)
                ),
                Arguments.of(
                        arrayOf(1, 4, 9, 8),
                        17,
                        arrayOf(9, 8)
                ),
                Arguments.of(
                        arrayOf(1, 2, 3, 4, 5),
                        9,
                        arrayOf(2, 3, 4)
                ),
                Arguments.of(
                        arrayOf(1, 4, 5, 6),
                        11,
                        arrayOf(5, 6)
                ),
                Arguments.of(
                        arrayOf(9, 1, 3, 8),
                        4,
                        arrayOf(1, 3)
                ),
                Arguments.of(
                        arrayOf(4, 1, 7, 4, 2),
                        6,
                        arrayOf(4, 2)
                )
        );
    }

    private static int[] arrayOf(int... values) {
        return IntStream.of(values).toArray();
    }

    @ParameterizedTest
    @MethodSource
    void search(int[] data, int searchableSum, int[] expectedResult) {
        SlidingWindowSum slidingWindowSum = new SlidingWindowSum(data);

        int[] result = slidingWindowSum.searchOptimized(searchableSum);

        assertArrayEquals(expectedResult, result);
    }

}
