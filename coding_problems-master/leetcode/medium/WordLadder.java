/**
 * Problem: Find the length of shortest transformation sequence
 *
 * Solution: BFS--for words in each level, try each possible letter a-z on each position of the word;
 *           Use queue to store words in a level and use a hashset to mark visited words.
 */

import java.util.*;
public class WordLadder{
	public int ladderLength(String start, String end, Set<String> dict){
		if(start==null || end==null || start.equals(end)){
			return 0;
		}
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		HashSet<String> visited = new HashSet<String>();
		int result = 1;
        
        //for each depth
		while(!q.isEmpty()){
			Queue<String> nextDepth = new LinkedList<String>();
			//for each word in current depth
			while(!q.isEmpty()){
				String s = q.poll();
				char[] arr = s.toCharArray();
				int len = s.length();
				//change every character
				for(int i=0; i<len; i++){
					char prev = arr[i];
					//try each letter
					for(int j='a'; j<='z'; j++){
						arr[i] = (char)j;
						String temp = new String(arr);
						//target found
						if(temp.equals(end)){
							return result;
						}
						//find a new word in the next level
						if(dict.contains(temp) && !visited.contains(temp)){
							nextDepth.offer(temp);
							visited.add(temp);
						}
					}
					//change letter back 
					arr[i] = prev;
				}
			}
			//go to next level
			q = nextDepth;
			result ++;
		}
		return 0;
	}
}