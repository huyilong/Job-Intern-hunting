/**
 * Problem: Remove element from array in place, return new length
 *
 * Solution: if elem found, replace it with tail element and check again
 */

public class RemoveElement{
	public int removeElement(int[] A, int elem){
		if(A==null || A.length==0){
			return 0;
		}
		int front = 0;
		int tail = A.length-1;
		while(front <= tail){
			//exchange front and tail
			if(A[front] == elem){
				A[front] = A[tail];
				tail--;
			}else{
				front++;
			}
		}
		return tail+1;
	}
}