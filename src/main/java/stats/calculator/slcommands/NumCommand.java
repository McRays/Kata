package stats.calculator.slcommands;

public class NumCommand implements Command{

	@Override
	public Integer initValue(Integer... sequence) throws IllegalArgumentException {
		if(sequence == null){
			throw new IllegalArgumentException("null parameter is not allowed");
		}
		return 0;
	}


	@Override
	public Integer operation(Integer value1, Integer value2) throws IllegalArgumentException {
		return value1 + 1;
	}

}
