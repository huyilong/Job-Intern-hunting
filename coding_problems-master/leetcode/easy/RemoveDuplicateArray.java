/**
 * Problem: Given a sorted array, remove duplicates in place and return new length
 *
 * Solution: two pointers, update ascending numbers one by one in the array from start to end
 */
public class RemoveDuplicateArray{
	public int removeDuplicates(int[] A){
		if(A == null || A.length==0){
			return 0;
		}
		int num = 0;
		int nextNum = 0;
		int len = A.length;
		while(nextNum < len){
			//find next different number
			while(nextNum<len && A[nextNum]==A[num]){
				nextNum++;
			}
			//set number after num to be nextNum
			if(nextNum < len){
			  num++;
			  A[num] = A[nextNum];
			}else{
				return num+1;
			}
		}
		return num+1;
	}
}