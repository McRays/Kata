package stats.calculator;

import stats.calculator.commands.*;

public class StatsCalculator {

    private static final MinCommand minCommand = new MinCommand();
    private static final MaxCommand maxCommand = new MaxCommand();
    private static final NumCommand numCommand = new NumCommand();
    private static final SumCommand sumCommand = new SumCommand();

    private int result(Command command, Integer... sequences) {
        if (null == sequences) {
            throw new IllegalArgumentException("null parameter is not allowed");
        }
        for (int i = 0; i < sequences.length; i++) {
            if (sequences[i] == null) {
                throw new IllegalArgumentException(String.format("index [%d] in parameter is null", i));
            }
        }
        return command.iterator(sequences);
    }

    public int min(Integer... sequences) {
        return result(minCommand, sequences);
    }

    public int max(Integer... sequences) {
        return result(maxCommand, sequences);
    }

    public int num(Integer... sequences) {
        return result(numCommand, sequences);
    }

    public int avg(Integer... sequences) {
        return result(sumCommand, sequences) / sequences.length;
    }
}
