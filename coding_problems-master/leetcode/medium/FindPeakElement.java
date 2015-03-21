/**
 * Problem: Find peak element and return index.
 *
 * Solution: Divide-and-Conquer, check if mid element is a peak, otherwise check if mid is smaller than left/right neighbor, 
 *           then left/right subarray must contain a peak element(due to locally raising)
 */

public class FindPeakElement{
	public int findPeakElement(int[] num){
		if(num==null || num.length==0){
			return Integer.MIN_VALUE;
		}
		return peakHelper(num,0,num.length-1);
	}

	public int peakHelper(int[] num, int low, int high){
		int mid = (low+high)/2;
		//middle element is a peak, need to ensure index in bound
		if((mid==low || num[mid-1]<=num[mid]) && (mid==high || num[mid]>=num[mid+1])){
			return mid;
		//check subarray due to locally raising
		}else if(mid>low && num[mid] < num[mid-1]){
			return peakHelper(num, low, mid-1);
		}else{
			return peakHelper(num, mid+1, high);
		}
	}
}