package stats.calculator.commands;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public abstract class Command {

    public int iterator(Integer... sequences) {
        return Stream.of(sequences).reduce(initialValue(sequences), comparator());
    }

    protected abstract Integer initialValue(Integer... sequence);

    protected abstract BinaryOperator<Integer> comparator();
}
