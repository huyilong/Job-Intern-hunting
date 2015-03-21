/**
 * Problem: Implement atoi to convert a string to an integer
 *
 * Solution 1: pre-process to ignore whitespace, traverse the string to update integer value
 *           while checking invalid character and overflow
 * Solution 2: similar to solution 1, but use some method in Character
 */

public class StringToInteger{
	public int atoi(String str){
		//empty string
		if(str==null){
			return 0;
		}
		//omit leading and trailing whitespace
		str = str.trim();
		//string of whitespace
		if(str.length()==0){
			return 0;
		}
		int idx = 0;
		int sign = 1;
		long result = 0;
		int digit = 0;
		//determine sign bit
		if(str.charAt(idx) == '+'){
			idx ++;
		}else if(str.charAt(idx) == '-'){
			sign = -1;
			idx ++;
		}
		//traverse each character
		for(; idx<str.length(); idx++){
			//invalid character
			if(str.charAt(idx)<'0' || str.charAt(idx)>'9'){
				break;
			}
			//update integer
			digit = str.charAt(idx) - '0';
			result = result*10 + digit;
			//check overflow
			if(result*sign > Integer.MAX_VALUE){
			   return Integer.MAX_VALUE;
		    }
		    if(result*sign < Integer.MIN_VALUE){
		       return Integer.MIN_VALUE;
		    }
		}
		//check overflow again 
		if(result*sign > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(result*sign < Integer.MIN_VALUE){
		    return Integer.MIN_VALUE;
		}
		return (int)result*sign;
	}
    

	public int atoi2(String str){
		int i=0; 
		int len = str.length();
		//skip leading whitespace
		while(i<len && Character.isWhitespace(str.charAt(i))){
			i++;
		}
		//determine the sign
		int sign = 1;
		if(i<len && str.charAt(i)=="+"){
			i++;
		}else if(i<len && str.charAt(i)=='-'){
			sign = -1;
			i++;
		}
		//compute integer value
		int num = 0;
		while(i<len && Character.isDigit(str.charAt(i))){
			int digit = Character.getNumericValue(str.charAt(i));
			//check overflow
			if(num>Integer.MAX_VALUE/10 || num==Integer.MAX_VALUE/10&&digit>=8){
				return sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num*10 + digit;
			i++;
		}
		return sign*num;
	}





}