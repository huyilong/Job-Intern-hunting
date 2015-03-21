//remove all instances of the given value in place, return new length

//overwrite instances with elements from backwards

public class RemoveElement{
	public int removeElement(int[] A, int elem){
		if(A==null || A.length==0){
			return 0;
		}
		int front = 0;
		int end = A.length-1;
		while(front <= end){
			if(A[front]==elem){
				A[front] = A[end];
				end --;
			}else{
				front ++;
			}
		}
		return end+1;
	}
}