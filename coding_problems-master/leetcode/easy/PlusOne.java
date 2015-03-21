/**
 * Problem: Given a non-neg number represented by array, plus one to it
 *
 * Solution: add 1 to the end, if carryon=1, continue to add 1 to previous elements 
 *           until no more carry on. create a new array if necessary
 */

public class PlusOne{
	public int[] plusOne(int[] digits){
		if(digits==null || digits.length==0){
			return digits;
		}
        int len = digits.length;
        int val = digits[len-1]+1;
        int carryon = val/10;
        digits[len-1] = val % 10;
        //continue to add 1 to previous elements
        if(carryon == 1){
        	int index = len - 2;
        	while(index >= 0){
        		val = digits[index]+carryon;
        		carryon = val/10;
        		digits[index] = val%10;
        		if(carryon == 0){
        			return digits;
        		}else{
        			index --;
        		}
        	}
        	//create a new array if no more space
        	if(carryon==1){
        		int[] result = new int[len+1];
        		result[0] = 1;
        		for(int k=1; k<len+1; k++){
        			result[k] = digits[k-1];
        		}
        		return result;
        	}
        }
        return digits;   
	}
}