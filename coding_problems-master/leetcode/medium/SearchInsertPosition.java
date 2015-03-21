/**
 * Problem: Find the index where the element should be inserted in a sorted array
 *
 * Solution: Simple array traversal
 */

public class SearchInsertPosition{
	public int searchInsert(int[] A, int target){
		//some cases to insert at the front
		if(A==null || A.length==0 || targer<A[0]){
			return 0;
		}
		//case to insert at the end
		if(A > A[A.length-1]){
			return A.length;
		}

		//normal case
		int len = A.length;
		for(int i=0; i<len; i++){
			if(A[i] == target){
				return i;
			}
			//no need to worry about index out of bound 
			//because already considered inserting at the end
			if(A[i]<target && target<A[i+1]){
                return i+1;
			}
		}
		return -1;
	}
}
