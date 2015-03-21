//search target in a rotated sorted array

public class SearchRotatedSortedArray{
	 public int search(int[] A, int target) {
        if(A==null || A.length==0){
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == A[mid]){
                return mid;
            }
            
            //left subarray is sorted
            if(A[low] <= A[mid]){
                //target is in sorted left subarray
                if(A[low]<=target && target<=A[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                //target is in sorted right subarray
                if(A[mid]<=target && target<=A[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}