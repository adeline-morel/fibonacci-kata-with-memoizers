package fibonacci.with.memoizers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
            "1, 0"
    })
    void testFibonacciNumberAtPosition(int position, int expected) {
        int result = Fibonacci.fibonacciNumberAtPosition(position);

        assertThat(expected).isEqualTo(result);
    }
}
