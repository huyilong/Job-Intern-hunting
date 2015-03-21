/**
 * Problem: Find kth row of Pascal's triangle using O(k) space
 *
 * Solution: using arraylist
 * Solution(optimized) : C(n,k+1) = C(n,k)*((n-k)/(k+1))
 */

import java.util.*;
public class PascalTriangle2{

	public ArrayList<Integer> getRow(int rowIndex){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(rowIndex < 0){
			return result;
		}
		result.add(1);
		if(rowIndex == 0){
			return result;
		}
		for(int i=1; i<=rowIndex; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			for(int j=1; j<result.size(); j++){
				temp.add(result.get(j-1)+result.get(j));
			}
			temp.add(1);
			result = temp;
		}
		return result;
	}
    
    //optimized version
	public ArrayList<Integer> getRow2(int rowIndex){
		ArrayList<Integer> result = new ArrayList<Integer>(rowIndex+1);
		if(rowIndex < 0){
			return result;
		}
		result.add(1);
		if(rowIndex == 1){
			result.add(1);
			return result;
		}
		//compute half of the list
		for(int i=1; i<=rowIndex; i++){
			//need to take care of overflow
			result.add((int)(result.get(i-1)*1.0/i*(rowIndex-i+1)));
		}
		int k = rowIndex/2 + 1;
		//copy the value into the rest of list
		for(int i=k; i<=rowIndex; i++){
			result.add(result.get(rowIndex-i));
		}		
        return result;
	}
}