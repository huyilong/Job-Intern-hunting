//merge two sorted arrays

public class MergeSortedArray{
	public void merge(int A[], int m, int B[], int n) {
        int frontA = m-1;
        int frontB = n-1;
        int end = m+n-1;
        
        while(frontA>=0 && frontB>=0){
            if(A[frontA]<B[frontB]){
                A[end] = B[frontB];
                frontB --;
                end --;
            }else{
                A[end] = A[frontA];
                frontA --;
                end --;
            }
        }
        
        while(frontB>=0){
            A[end] = B[frontB];
            frontB --;
            end --;
        }
    }
}