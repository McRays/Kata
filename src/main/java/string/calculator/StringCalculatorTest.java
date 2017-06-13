package string.calculator;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class StringCalculatorTest {
	
	private final ThreadLocalRandom random = ThreadLocalRandom.current();
	private StringCalculator calculator = new StringCalculator();
	
	@Test
	public void return_sum_in_enmpty_string(){
		int sum = calculator.add("");
		assertThat(0,is(sum));
	}
	
	@Test
	public void return_sum_in_only_one_string_num(){
		int sum = calculator.add("1");
		assertThat(1,is(sum));
	}
	
	@Test 
	public void return_sum_in_tow_string_num(){
		int sum = calculator.add("1,2");
		assertThat(3,is(sum));
	}
	
	@Test
	public void return_sum_in_unknown_a_amount_of_numbers(){
		Integer[] intArr = generateSequences(20);
		String resultStr = generateAmountOfStringNumber(intArr);
		int currentSum = getSum(intArr);
		
		int sum = calculator.add(resultStr);
		assertThat(currentSum,is(sum));
	}
	
	@Test
	public void return_sum_in_new_line_between_numbers(){
		int sum = calculator.add("1\n2,3");
		assertThat(sum, is(6));
	}
	
	@Test 
	public void return_sum_in_other_delimiters(){
		int sum = calculator.add(";\n1;2");
		assertThat(sum, is(3));
	}
	
	@Test
	public void return_sum_in_negatives(){
		
		  try {
			  	calculator.add(";\n1;2;2$3/n-4-3");
	            fail("IllegalArgumentException should be thrown.");
	        } catch (IllegalArgumentException e) {
	            assertThat(e.getMessage(), is("negatives not allowed"));
	        }
	}
	
	
	private String generateAmountOfStringNumber(Integer[] intArr){
		StringBuilder sb = new StringBuilder();
		for(Integer i : intArr){
			sb.append(i).append(",");
		}
		String result = sb.toString();
		return result.substring(0, result.lastIndexOf(","));
	}
	
	private int getSum(Integer[] intArr){
		int sum = 0;
		for(Integer i : intArr){
			sum += i;
		}
		
		return sum;
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
