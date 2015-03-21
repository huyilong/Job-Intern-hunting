//remove duplicates from sorted array, duplciates can appear at most twice

public class RemoveDuplicateSortedArray2{
	public int removeDuplicates(int[] A) {
        if(A==null || A.length==0){
            return 0;
        }else if(A.length == 1){
            return 1;
        }
        
        int len = A.length;
        int iter = 0;
        int nextNum = 0;
        int count = 0;
        
        while(nextNum < len){
            count = 0;
            //nextNum stops at next different number
            while(nextNum<len && A[iter]==A[nextNum]){
                count ++;
                nextNum++;
            }
            //if duplicates appear more than or equal to twice
            //only keep two duplicates and move current position to the correct place
            if(count >= 2){
                A[iter+1] = A[iter];
                iter = iter + 2;
            }else{
                iter = iter + 1;
            }
            //replace current position with next different number
            if(iter<len && nextNum < len){
              A[iter] = A[nextNum];
            }
        }
        return iter;
    }
}