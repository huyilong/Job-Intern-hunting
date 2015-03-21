/**
 * Problem: Reverse digits of an integer
 *
 * Solution: modulo operation, remeember to check overflow case
 */

public class ReverseInteger{
	public int reverse(int x){
		int temp = x<0 ? -x : x;
		int result = 0;
		while(temp != 0){
			//take care of overflow and underflow
			if(Math.abs(result) > Integer.MAX_VALUE/10){
			    return 0;
			}else{
				result = result*10 + temp%10;
			}
			temp = temp/10;
		}
		return x<0 ? -result :  result;
	}

}