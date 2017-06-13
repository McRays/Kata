package stats.calculator;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SLStatsCalculatorTest {

    private final SLStatsCalculator calculator = new SLStatsCalculator();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    // Border assert
    @Test
    public void null_argument_is_not_acceptable() {
        try {
            calculator.min(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("null parameter is not allowed"));
        }
    }

    @Test
    public void null_item_in_argument_is_not_acceptable() {
        try {
            calculator.min(1, 2, null, 8);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("index [2] in parameter is null"));
        }
    }

    // iterator method assert
    @Test
    public void return_the_minimal_number_when_only_have_one_number() {
        int number = generateGreatThanZero();
        int min = calculator.min(number);
        assertThat(min, is(number));
    }

    @Test
    public void return_the_minimal_number_when_have_tow_numbers() {
        int min = calculator.min(-1, generateGreatThanZero());
        assertThat(min, is(-1));
    }

    @Test
    public void return_the_minimal_number_when_have_multiply_numbers() {
        Integer[] sequences = generateSequences(4);
        sequences[2] = -1;
        int min = calculator.min(sequences);
        assertThat(min, is(-1));
    }

    // Max assert
    @Test
    public void return_the_max_item_in_sequence() {
        Integer[] sequences = generateSequences(5);
        sequences[3] = 50;
        int max = calculator.max(sequences);
        assertThat(max, is(50));
    }

    // Number assert
    @Test
    public void should_return_numbers_of_sequence_in_num_method() throws Exception {
        Integer[] integers = generateSequences(6);
        int length = calculator.num(integers);
        assertThat(length, is(6));
    }

    @Test
    public void should_return_avg_of_sequences() throws Exception {
        int sum = calculator.avg(1, 3, 5, 7, 9);
        assertThat(sum, is(5));
    }

    private Integer[] generateSequences(int length) {
        return IntStream.range(0, length)
                .map(i -> generateGreatThanZero())
                .boxed()
                .collect(toList())
                .toArray(new Integer[length]);
    }

    private int generateGreatThanZero() {
        return random.nextInt(10, 20);
    }
}
