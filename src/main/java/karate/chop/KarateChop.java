package karate.chop;

import java.util.Arrays;

public class KarateChop {
  public int chop(int value,int[] arr){
		return chopByRecursion(value,arr,0,arr.length - 1);
	}
	
	public int chopByRecursion(int value,int[] arr, int start, int end){
		int index = (start + end)/2;
		if(start <= end && arr.length > 0){
			if(value == arr[index]) return index;
			if(value > arr[index]) start = index + 1;
			if(value < arr[index]) end = index - 1;
			return chopByRecursion(value,arr,start,end);
		}
		return -1;
	}
}
