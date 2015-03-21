/**
 * Problem: Remove duplicates in sorted array, duplicates allowed to appear at most twice
 *
 * Solution: Use two pointers, one for inserting index, another to find next different element
 */

public class RemoveDuplicateArray2{
	public int removeDuplicates(int[] A){
		if(A==null || A.length==0){
			return 0;
		}
		int len = A.length;

		int nextNum = 0;
		int num = 0;
		int freq = 0;

		while(nextNum < len){
			//find next different element
			while(nextNum<len && A[nextNum]==A[num]){
				freq ++;
				nextNum ++;
			}
			
            //out of bound
		    if(nextNum >= len){
		    	if(freq>=2){
		    		num++;
		    		A[num] = A[nextNum-1];
                }
                return num+1;
            }
            //duplicate appearing more than twice
			if(freq >= 2){
				num++;
				A[num] = A[nextNum-1];
			}
			num++;
			A[num] = A[nextNum];
			freq = 0;

		}
		return num+1;
	}
}