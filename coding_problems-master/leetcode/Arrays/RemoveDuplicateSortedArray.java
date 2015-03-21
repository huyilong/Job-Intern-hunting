//remove duplicates from sorted array in place

//use two pointers, one to find next distinct number, and another to track
//the position to insert this distinct number

public class RemoveDuplicateSortedArray{
	public int removeDuplicates(int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		int num = 0;
		int nextNum = 0;
		int len = A.length;

		while(nextNum < len){
			while(nextNum+1<len && A[nextNum]==A[nextNum+1]){
				nextNum++;
			}
			A[num] = A[nextNum];
			num++;
			nextNum++;
		}
		return num;
	}
}