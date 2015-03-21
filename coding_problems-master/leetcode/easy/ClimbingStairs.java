/**
 * Problem: Compute number of different ways to climb to top using either 1 or 2 step
 *
 * Solution: arr[i] = number of ways given n steps
 *           then arr[i] = arr[i-1] + arr[i-2]
 */

public class ClimbingStairs{
	public int climbStairs(int n){
		if(n <= 0){
			return 0;
		}
		int[] climb = new int[n+1];
		climb[0] = 1;
		climb[1] = 1;
		for(int i=2; i<n+1; i++){
			climb[i] = climb[i-1] + climb[i-2];
		}
		return climb[n];
	}
}