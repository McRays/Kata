package stats.calculator.commands;

import java.util.function.BinaryOperator;

public class NumCommand extends Command{

	@Override
	protected BinaryOperator<Integer> comparator() {
		return (a, b) -> a+1;
	}

	@Override
	protected Integer initialValue(Integer... sequence) {
		return 0;
	}

}
