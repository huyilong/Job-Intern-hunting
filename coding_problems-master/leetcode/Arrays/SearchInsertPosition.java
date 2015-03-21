//search insert position in a sorted array

public class SearchInsertPosition{
	 public int searchInsert(int[] A, int target) {
        if(A==null || A.length==0){
            return 0;
        }
        int len = A.length;
        
        int i = 0;
        while(i < len-1){
            if(A[i] == target){
                return i;
            }
            if(A[i]<target && target<A[i+1]){
                return i+1;
            }
            i++;
        }
        if(target <= A[0]){
            return 0;
        }else if(target == A[len-1]){
            return len-1;
        }else{
            return len;
        }
    }
}