/**
 * Problem: Build pascal's triangle using given numRows
 *
 * Solution: list(i) = prevlist(i-1) + prevlist(i)
 */
import java.util.*;
public class PascalTriangle{
	public ArrayList<ArrayList<Integer>> generate(int numRows){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(numRows <= 0){
			return result;
		}
		ArrayList<Integer> head = new ArrayList<Integer>();
		head.add(1);
		result.add(0,head);
		numRows = numRows - 1;
		//compute each row
		for(int i=1; i<=numRows; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>(i+1);
			temp.add(0,1);
			int len = result.get(i-1).size();
			//list(i) = prevlist(i-1) + prevlist(i)
			for(int j=1; j<len; j++){
				temp.add(j,result.get(i-1).get(j-1)+result.get(i-1).get(j));
			}
			temp.add(len,1);
			result.add(i,temp);
		}
		return result;
	}
}