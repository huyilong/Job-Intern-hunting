/**
 * Problem: Find all unique triplets such that a+b+c=0
 *
 * Solution: Sort the array first, try elements in the sorted array as a,
 *           then use two pointers on the remaining right subarray to find b,c
 *           such that b+c=-a (sorting because we can consider a:small,b:mid,c:large).
 *           Skip duplicates while moving pointers.
 */
import java.util.*;
public class ThreeSum{
	public ArrayList<ArrayList<Integer>> threeSum(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num==null || num.length==0){
             return result;
		}
		int len = num.length;
		//sort the array
        Arrays.sort(num);
        //try each element as a except the last two elements
		for(int i=0; i<len-2; i++){
			//skip duplicate
			if(i==0 || num[i-1]!=num[i]){
				int target = -num[i];
				int bIdx = i+1;
				int cIdx = len-1;
				while(bIdx < cIdx){
					//found b and c
					if(num[bIdx]+num[cIdx]==target){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(-target);
						temp.add(num[bIdx]);
						temp.add(num[cIdx]);
						result.add(temp);
						bIdx++;
						cIdx--;
						//skip duplicates
						while(bIdx<cIdx && num[bIdx-1]==num[bIdx]){
							bIdx ++;
						}
						while(bIdx<cIdx && num[cIdx+1]==num[cIdx]){
							cIdx --;
						}
					}
					//adjust right boundary to left
					else if(num[bIdx]+num[cIdx]>target){
						cIdx --;
					}
					//adjust left boundary to right
					else{
						bIdx ++;
					}
			   }
			}

		}
		return result;
	}
}