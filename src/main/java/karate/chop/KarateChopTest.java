package karate.chop;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class KarateChopTest {
	
	public KarateChop kc = new KarateChop();
	
	
	@Test
	public void should_return_relative_value_index_in_only_one_item(){
		int[] arr = {1};
		int[] arr1 = {};
		int index1 = kc.chop(3,arr);
		int index2 = kc.chop(1,arr1);
		int index3 = kc.chop(1,arr);
		
		assertThat(-1, is(index1));
		assertThat(-1, is(index2));
		assertThat(0, is(index3));
	}
	
	@Test
	public void should_return_relative_value_index_in_multiply_item(){
		int[] arr = {1,3,5,7};
		int index1 = kc.chop(3,arr);
		int index2 = kc.chop(2,arr);
		int index3 = kc.chop(5,arr);
		int index4 = kc.chop(6,arr);
		
		assertThat(1, is(index1));
		assertThat(-1, is(index2));
		assertThat(2, is(index3));
		assertThat(-1, is(index4));
	}
	
	@Test
	public void should_return_relative_value_index_in_only_one_item_by_recursion(){
		int[] arr = {1};
		int[] arr1 = {};
		int index1 = kc.chopByRecursion(3,arr,0,arr.length - 1);
		int index2 = kc.chopByRecursion(1,arr1,0,arr.length - 1);
		int index3 = kc.chopByRecursion(1,arr,0,arr.length - 1);
		
		assertThat(-1, is(index1));
		assertThat(-1, is(index2));
		assertThat(0, is(index3));
	}
	
	@Test
	public void should_return_relative_value_index_in_multiply_item_by_recursion(){
		int[] arr = {1,3,5,7};
		int index1 = kc.chopByRecursion(3,arr,0,arr.length - 1);
		int index2 = kc.chopByRecursion(2,arr,0,arr.length - 1);
		int index3 = kc.chopByRecursion(5,arr,0,arr.length - 1);
		int index4 = kc.chopByRecursion(6,arr,0,arr.length - 1);
		
		assertThat(1, is(index1));
		assertThat(-1, is(index2));
		assertThat(2, is(index3));
		assertThat(-1, is(index4));
	}
	
	
}
