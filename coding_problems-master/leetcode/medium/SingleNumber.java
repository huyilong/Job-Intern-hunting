/**
 * Problem: Find single number in the array
 *
 * Solution 1: use a hash set
 * Solution 2: use XOR (x XOR x = 0)
 */

import java.util.*;
public class SingleNumber{
	public int singleNumber(int[] A){
		if(A == null || A.length == 0){
			return -1;
		}
		Set<Integer> s = new HashSet<Integer>();
		int len = A.length;
		for(int i=0; i<len; i++){
			if(!s.contains(A[i])){
				s.add(A[i]);
			}else{
				s.remove(A[i]);
			}
		}
		return (int)s.toArray()[0];
	}
    
    public int singleNumber(int[] A){
    	if(A==null || A.length == 0){
    		return -1;
    	}
    	int len = A.length;
    	int val = 0;
    	for(int i=0; i<len; i++){
    		val = val ^ A[i];
    	}
    	return val;
    }




}