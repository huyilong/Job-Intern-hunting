/**
 * Problem: Find all unique quadruplets such that the sum is equal to target
 *
 * Solution 1: Similar to 3Sum, just add another loop between outside for loop and inside while loop
 * Solution 2: For every pair of two numbers in the array, store the sums and the index pairs in a hashmap.
 *             then perform lookup in hashmap to find two pairs that sum to the target
 */
import java.util.*;
public class FourSum{
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num==null || num.length<4){
			return result;
		}
		int len = num.length;
		Arrays.sort(num);
		for(int aIdx=0; aIdx<len-3; aIdx++){
			//skip duplicates
			if(aIdx!=0 && num[aIdx]==num[aIdx-1]){
				continue;
			}
			for(int bIdx=aIdx+1; bIdx<len-2; bIdx++){
				//skip duplicates
				if(bIdx!=aIdx+1 && num[bIdx]==num[bIdx-1]){
					continue;
				}
				int cIdx = bIdx + 1;
				int dIdx = len - 1;
				int targetSum = target - num[aIdx] - num[bIdx];
				while(cIdx < dIdx){
					int sum = num[cIdx] + num[dIdx];
					if(sum == targetSum){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[aIdx]);
						temp.add(num[bIdx]);
						temp.add(num[cIdx]);
						temp.add(num[dIdx]);
						result.add(temp);
						cIdx ++;
						dIdx --;
						//skip duplicates
						while(cIdx<dIdx && num[cIdx]==num[cIdx-1]){
							cIdx ++;
						}
						while(cIdx<dIdx && num[dIdx]==num[dIdx+1]){
							dIdx--;
						}
					}else if(sum < targetSum){
						cIdx ++;
					}else{
						dIdx --;
					}
				}
			}
		}
		return result;
	}

	public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num==null || num.length<4){
			return result;
		}
		HashMap<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
        int len = num.length;
        //store pairs of two sums
        for(int i=0; i<len-1; i++){
        	for(int j=i+1; j<len; j++){
        		int sum = num[i] + num[j];
        		ArrayList<Integer> temp = new ArrayList<Integer>(2);
        		temp.add(i);
        		temp.add(j);
        		//store pairs into hashmap
                if(!map.containsKey(sum)){
                	ArrayList<ArrayList<Integer>> tempList = new ArrayList<ArrayList<Integer>>();
                	tempList.add(temp);
                	map.put(sum, tempList);
                }else{
                	map.get(sum).add(temp);
                }
        	}
        }
        //use hashset to avoid duplicates
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        //try each possible sum
        for(Integer sum: map.keySet()){
        	ArrayList<ArrayList<Integer>> l1 = map.get(sum);
        	//find counterpart
        	if(map.containsKey(target-sum)){
        		//two sums are the same and only one pair for the sum
        		if(target==2*sum && l1.size()==1){
        			continue;
        		}
        		ArrayList<ArrayList<Integer>> l2 = map.get(target-sum);
        		//build pairs to pairs
        		for(ArrayList<Integer> p1: l1){
        			for(ArrayList<Integer> p2: l2){
        				if(p1 == p2){
        					continue;
        				}
        				//check if an element is used twice
        				if(p1.contains(p2.get(0)) || p1.contains(p2.get(1))){
        					continue;
        				}
        				ArrayList<Integer> l = new ArrayList<Integer>(4);
        				l.add(num[p1.get(0)]);
        				l.add(num[p1.get(1)]);
        				l.add(num[p2.get(0)]);
        				l.add(num[p2.get(1)]);
        				Collections.sort(l);
        				//add to set to avoid duplicates
        				set.add(l);
        			}
        		}

        	}
        }

        result.addAll(set);
        return result;

	}

}