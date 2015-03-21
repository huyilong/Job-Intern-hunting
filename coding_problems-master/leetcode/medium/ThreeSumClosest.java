/**
 * Problem: Find three integers such that the sum is cloest to the target
 *
 * Solution: Similar to threeSum, just need to update final result white traversing
 */

public class ThreeSumClosest{
	public int threeSumClosest(int[] num, int target){
		if(num==null || num.length==0){
			return 0;
		}
		Arrays.sort(num);
		int len = num.length;
		//divide by 2 to avoid possible overflow when doing closestSum-target
		int closestSum = Integer.MAX_VALUE/2;
		for(int i=0; i<len-2; i++){
			//to improve, cound use loop to skip duplicates here
			int bIdx = i+1;
			int cIdx = len-1;
			while(bIdx < cIdx){
				//to improve, could use loop to skip duplicates here
				int sum = num[i] + num[bIdx] + num[cIdx];
				if(sum == target){
					return sum;
				}else if(sum < target){
					bIdx ++;
				}else{
					cIdx --;
				}
				//update closest sum
				if(Math.abs(sum-target) < Math.abs(closestSum - target)){
					closestSum = sum;
				}
			}
		}
		return closestSum;
	}
}