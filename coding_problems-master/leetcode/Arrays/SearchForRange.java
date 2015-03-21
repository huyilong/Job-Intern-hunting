//Given a sorted array, search for starting and ending position of a target value

public class SearchForRange{
	public int[] searchRange(int[] A, int target) {
        int[] res = new int[]{-1,-1};
        if(A==null || A.length==0){
            return res;
        }
        int len = A.length;
        int first = 0;
        
        //search for starting position
        while(first<len && A[first]!=target){
            first ++;
        }
        
        if(first == len){
            return res;
        }else{
            int second = first+1;
            //search for ending position
            while(second<len && A[second] == A[first]){
                second ++;
            }
            res[0] = first;
            res[1] = second-1;
        }
        return res;
        
    }
}