package stats.calculator.slcommands;

public interface Command {
	public Integer initValue(Integer ... sequence) throws IllegalArgumentException;
	
	public Integer operation(Integer value1, Integer value2) throws IllegalArgumentException;
}
