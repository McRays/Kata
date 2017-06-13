package string.calculator;


public class StringCalculator {

	public int add(String input) throws IllegalArgumentException{
		int sum = 0;
		
		if("".equals(input)){
			return sum;
		}
		checkIllegal(input);
		byte[] byteArr = input.getBytes();
		boolean flag = initFlag(byteArr);
		return result(byteArr, flag);
	}
	
	private int result(byte[] byteArr, boolean flag){
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < byteArr.length;i++){
			
			if(byteArr[i] >= '0' && byteArr[i] <= '9'){
				sb.append((char)byteArr[i]);
				flag = true;
			}else if(flag){
				sum += Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
				flag = false;
			}
			
			if(i == byteArr.length - 1 && flag){
				sum += Integer.parseInt(sb.toString());
			}
		}
		
		return sum;
	}
	
	
	private void checkIllegal(String input){
		if(input == null){
			throw new IllegalArgumentException("null not allowed");
		}
		
		int count = 0;
		int i = 0;
		if(input.charAt(0) != '-'){
			i = 1;
		}
		
		String[] negativeStrs = input.split("-");
		for(;i < negativeStrs.length;i++){
			byte[] byteArr = negativeStrs[i].getBytes();
			if(byteArr[0] >= '0' && byteArr[0] <= '9'){
				count++;
			}
		}
		
		if(count >= 2){
			throw new IllegalArgumentException("negatives not allowed");
		}
	} 
	
	
	private boolean initFlag(byte[] byteArr){
		boolean flag = true;
		if(byteArr[0] >= '0' && byteArr[0] <= '9'){
			flag = true;
		}else if(flag){
			flag = false;
		}
		
		return flag;
	}
	
}