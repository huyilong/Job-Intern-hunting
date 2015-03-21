//search for target in a rotated sorted array that might contain duplicates

public class SearchRotatedSortedArray2{
	public boolean search(int[] A, int target) {
        if(A==null || A.length==0){
            return false;
        }
        int low = 0;
        int high = A.length - 1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == A[mid]){
                return true;
            }
            
            //left subarray is sorted
            if(A[low] < A[mid]){
                //target is in sorted left subarray
                if(A[low]<=target && target<=A[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(A[low] > A[mid]){
                //target is in sorted right subarray
                if(A[mid]<=target && target<=A[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                low ++;
            }
        }
        return false;
    }
}