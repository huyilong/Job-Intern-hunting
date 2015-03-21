/**
 * Problem: Merge two sorted arrays
 *
 * Solution: keep inserting larger element from the end of array
 */

public class MergeSortedArray{
	public void merge(int A[], int m, int B[], int n){
		//compute tail index
		int idx = m+n;
		//keep adding larger element from the end
		while(m>0 && n>0){
			idx --;
			if(A[m-1] >= B[n-1]){
				m--;
                A[idx] = A[m];
			}else{
				n--;
				A[idx] = B[n];
			}
		}
		//move rest of B into A
		while(n>0){
			idx --;
			n--;
			A[idx] = B[n];
		}
	}
}