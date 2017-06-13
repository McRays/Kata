package stats.calculator;

import stats.calculator.slcommands.Command;
import stats.calculator.slcommands.MaxCommand;
import stats.calculator.slcommands.MinCommand;
import stats.calculator.slcommands.NumCommand;
import stats.calculator.slcommands.SumCommand;



public class SLStatsCalculator {
	
	private Command minCommand = new MinCommand();
	private Command maxCommand = new MaxCommand();
	private Command numCommand = new NumCommand();
	private Command sumCommand = new SumCommand();
	
	
	public Integer min(Integer ... sequence) throws IllegalArgumentException{
		return result(minCommand, sequence);
	}
	
	public Integer max(Integer ... sequence )throws IllegalArgumentException{
		return result(maxCommand, sequence);
	}
	
	public Integer num(Integer ... sequence )throws IllegalArgumentException{
		return result(numCommand, sequence);
	}
	
	public Integer avg(Integer ... sequence )throws IllegalArgumentException{
		return result(sumCommand, sequence)/sequence.length;
	}
	
	
	
	private Integer result(Command command,Integer ... sequence) throws IllegalArgumentException{
		Integer result = command.initValue(sequence);
		checkItemNull(sequence);
		for(Integer index = 0;index < sequence.length;index++){
			result = command.operation(result, sequence[index]);
		}
		return result;
	}
	
	private void checkItemNull(Integer ... sequence) throws IllegalArgumentException{
		for(Integer index = 0;index < sequence.length;index++){
			if(sequence[index] == null){
				throw new IllegalArgumentException("index ["+index+"] in parameter is null");
			}
		}
	}
	
	
}
