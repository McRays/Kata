package stats.calculator.commands;

import java.util.function.BinaryOperator;

public class SumCommand extends Command {

    @Override
    protected Integer initialValue(Integer... sequence) {
        return 0;
    }

    @Override
    protected BinaryOperator<Integer> comparator() {
        return (a, b) -> a + b;
    }
}
