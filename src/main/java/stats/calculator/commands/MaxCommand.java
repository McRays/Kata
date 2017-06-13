package stats.calculator.commands;

import java.util.function.BinaryOperator;

public class MaxCommand extends Command {

    @Override
    protected Integer initialValue(Integer... sequence) {
        return sequence[0];
    }

    @Override
    protected BinaryOperator<Integer> comparator() {
        return (a, b) -> a > b ? a : b;
    }
}
