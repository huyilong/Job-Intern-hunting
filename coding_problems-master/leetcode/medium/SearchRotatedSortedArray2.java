/**
 * Problem: Follow up on search rotated sorted array, what if duplicates exists?
 *
 * Solution: In previous problem, we use A[low] <= A[mid] to confirm that A[low]~A[mid] is an increasing sequence
 *           under the condition that no duplicates exist. But now we can get the same conclusion if duplicate occurs.
 *           To improve the previous approach, just test A[low] < A[mid] to ensure increasing sequence and move low forward
 *           if A[low]=A[mid]. Alternatively, we can just do a linear scan to search for target.
 */

public class SearchRotatedSortedArray2{
	public boolean search(int[] A, int target){
		if(A==null || A.length==0){
			return false;
		}
		int low = 0;
		int high = A.length - 1;
		while(low <= high){
			//avoid overflow
			int mid = low + (high-low)/2;
			if(A[mid]==target){
				return true;
			}
			//left half array is an increasing sequence
			if(A[low] < A[mid]){
				//target in the sorted array
				if(A[low]<=target && target<A[mid]){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}else if(A[low] > A[mid]){
				if(A[mid]<target && target<=A[high]){
					low = mid + 1;
				}else{
					high = mid - 1;
				}
			}else{
				//move low index forward if A[mid]=A[low]
				low ++;
			}
		}
		return false;
	}
}