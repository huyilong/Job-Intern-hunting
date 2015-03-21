/**
 * Problem: Compute how much water the elevation map traps
 *
 * Solution: Set bar separately from left and right. Then for each position i, the volume of water
 *           stored at the position is min(left,right)-arr[i]
 */

public class TrappingRainWater{
	public int trap(int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		int len = A.length;
		int[] left = new int[len];
		int[] right = new int[len];
        int max = 0;
        //set bars from left
		for(int i=0; i<len-1; i++){
			if(A[i] > max){
				max = A[i];
			}
			left[i] = max;
		}
		max = 0;
		//set bars from right
		for(int i=len-1; i>=0; i--){
			if(A[i]>max){
				max = A[i];
			}
			right[i] = max;
		}

		int water = 0;
		//compute volume of water at each position
		for(int i=0; i<len-1; i++){
			water += Math.min(left[i], right[i])-A[i];
		}
		return water;

	}
}