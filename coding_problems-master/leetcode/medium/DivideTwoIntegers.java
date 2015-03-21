/**
 * Problem: Divide two integers
 *
 * Solution: Use left-shift to double the divisor every time(, and if divisor exceeds dividend, 
 *           subtract previous shifted value from divident, reset counter, and continue shifting.
 */

public class DivideTwoIntegers{
	public int divide(int dividend, int divisor){
		//determine the sign of result
		boolean pos = (dividend>0 && divisor>0) || (dividend<0 && divisor<0);
		//convert to positive numbers
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int result = 0;

		while(a >= b){
			int count = 0;
			//double divisor
			while(a >= (b << count)){
				count ++;
			}

            //avoid overflow
			if((result > (Integer.MAX_VALUE - (1 << (count-1))))){
				if(pos){
				   return Integer.MAX_VALUE;
				}else{
					return Integer.MIN_VALUE;
				}
			}

			//update result
			result = result + (1 << (count-1));
			//update dividend
			a = a - (b << (count-1));
		}
        
        //add the sign
		if(!pos){
			return -result;
		}else{
			return result;
		}

	}
}