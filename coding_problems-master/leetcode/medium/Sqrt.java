/**
 * Problem: Implement sqrt(int x)
 *
 * Solution: Try numbers from 0-x using binary search
 */

public class Sqrt{
	public int sqrt(int x){
		long low = 0;
		long high = x;

		while(low <= high){
			long mid = (low+high)/2;
			if(x < mid*mid){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return (int)high;
	}
}