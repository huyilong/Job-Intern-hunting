/**
 * Problem: Search element in a rotated sorted array
 *
 * Solution: Compare middle element and left/right boundary element to knwo if the subarray is sorted,
 *           then check if element is in the sorted array, otherwise change to search in the other array
 */

public class SearchRotatedSortedArray{
	public int search(int[] A, int target){
		if(A==null || A.length==0){
			return -1;
		}
		int low = 0;
		int high = A.length - 1;
		while(low <= high){
			//avoid overflow
			int mid = low + (high-low)/2;
			if(A[mid]==target){
				return mid;
			}
			//left half array is an increasing sequence
			if(A[low] <= A[mid]){
				//target in the sorted array
				if(A[low]<=target && target<A[mid]){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}else{
				if(A[mid]<target && target<=A[high]){
					low = mid + 1;
				}else{
					high = mid - 1;
				}
			}
		}
		return -1;
	}

}

