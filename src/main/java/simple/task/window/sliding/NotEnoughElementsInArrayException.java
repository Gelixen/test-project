package simple.task.window.sliding;

import static java.lang.String.format;

public class NotEnoughElementsInArrayException extends RuntimeException {
    public NotEnoughElementsInArrayException(int expected, int actual) {
        super(format("Should be at least %s elements, but found only %s", expected, actual));
    }
}
