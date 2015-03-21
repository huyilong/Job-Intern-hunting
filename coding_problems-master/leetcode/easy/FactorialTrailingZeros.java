/**
 * Problem: Find the number of trailing zeros in n!
 *
 * Solution: count number of factors 2 and 5
 */

public class FactorialTrailingZeros{
	public int trailingZeroes(int n){
		if(n<=0){
			return 0;
		}
		int count2 = 0;
		int count5 = 0;
		int temp2,temp5;

		for(int i=n; i>=1; i--){
			temp2 = i;
			temp5 = i;
			//count number of factor 2
			while(temp2%2 == 0){
				temp2 = temp2/2;
				count2++;
			}
			//count number of factor 5
			while(temp5%5 == 0){
				temp5 = temp5/5;
				count5++;
			}
		}
		//one pair of 2 and 5 makes a trailing zero
		return Math.min(count2,count5);
	}
}