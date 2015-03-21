/**
 * Problem: Every element appears three times except for a single on.
 *
 * Solution: Sum up bit at each position and modulo 3 to get single number
 */

public class SingleNumber2{
	public int singleNumber(int[] A){
		if(A==null || A.length==0){
			return -1;
		}
		int[] bits = new int[32];
		int num = 0;
		int len = A.length;
		for(int i=0; i<32; i++){
			//add numbers at bit i
			for(int j=0; j<len; j++){
				if (((A[j] >> i) & 1)==1) {
					bits[i]++;
				}
			}
			//mod 3 to rule out numbers appearing three times
			num |= ((bits[i]%3)<<i);
		}
		return num;
	}
}