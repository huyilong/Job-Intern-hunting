/**
 * Problem: Find the majority element
 *
 * Solution 1: use hashmap
 * Solution 2: two loops
 * Solution 3: Moore's Voting Algorithm
 */
import java.util.*;
public class MajorityElement{
	public int majorityElement(int[] num){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int len = num.length;
		//count frequency
		for(int i=0; i<len; i++){
			if(!map.containsKey(num[i])){
				map.put(num[i],1);
			}else{
				map.put(num[i],map.get(num[i])+1);
			}
		}
		int majority = 0;
		int count = 0;
		//determine majority element
		for(Integer key: map.keySet()){
			if(map.get(key)>count){
				count = map.get(key);
				majority = key;
			}

		}
		return majority;
	}

	public int majorityElement2(int[] num){
		int len = num.length;
		int maxCount = 0;
		int count = 0;
		int majority = 0;
		int val = 0;
		for(int i=0; i<len; i++){
			val = num[i];
			count = 0;
			//count frequency
			for(int j=0; j<len; j++){
				if(num[j]==val){
					count ++;
				}
			}
			//update maxCount and majority element
			if(count > maxCount){
				    maxCount = count;
				    majority = val;
			}
		}
		if(maxCount > Math.floor(len/2)){
		    return val;
		}else{
		    return 0;
		}
	}

	public int majorityElement3(int[] num){
		int len = num.length;
		if(len==1){
			return num[0];
		}
		int marjority = findMajority(num,len);
		int count = 0;
		for(int i=0; i<len; i++){
			if(num[i] == majority){
				count++;
			}
			if(count > Math.floor(len/2)){
				return majority;
			}
		}
		return -1;
	}

	public int findMajority(int[] num, int len){
		int maj_index = 0;
		int count = 1;
		for(int i=1; i<len; i++){
			if(a[maj_index] == num[i]){
				count++;
			}else{
				count --;
			}
			if(count == 0){
				maj_index = i;
				count = 1;
			}
		}
		return a[maj_index];
	}


}