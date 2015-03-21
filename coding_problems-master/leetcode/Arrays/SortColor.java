//Sort color in order red(0), white(1), blue(2)

public class SortColor{
	//counting sort, two-pass algorithm
	public void sortColors(int[] A) {
        if(A==null || A.length<=1){
            return;
        }
        int len = A.length;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for(int i=0; i<len; i++){
           if(A[i] == 0){
               count0 ++;
           }else if(A[i] == 1){
               count1 ++;
           }else{
               count2 ++;
           }
        }
        
        int i = 0;
        while(i < len){
            while(count0 != 0){
                A[i] = 0;
                count0 --;
                i ++;
            }
            
            while(count1 != 0){
                A[i] = 1;
                count1 --;
                i ++;
            }
            
            while(count2 != 0){
                A[i] = 2;
                count2 --;
                i ++;
            }
        }   
    }
    
    //one pass algorithm with constant space
    public void sortColors(int[] A) {
        if(A==null || A.length<=1){
            return;
        }
        int len = A.length;
        int front = 0;
        int end = len-1;
        int idx = 0;
        
        while(idx < len){
            if(A[idx] == 0 && idx>front){
                swap(A,idx,front);
                front ++;
            }else if(A[idx] == 2 && idx < end){
                swap(A,idx,end);
                end --;
            }else{
                idx ++;
            }
        }
        
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}