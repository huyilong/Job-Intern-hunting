/**
 * Problem: Find length of longest substring without repeating characters
 *
 * Solution: Use two pointers to bound the substring and use boolean array to mark characters used in the substring
 */
import java.util.*;

public class LongestSubstring{
	public int lengthOfLongestSubstring(String s){
		if(s==null || s.length()==0){
			return 0;
		}
		int start = 0;
		int end = 0;
		int len = s.length();
		int sublen = 0;
		//mark characters used in the substring
		boolean[] usage = new boolean[256];

		while(start<len && end<len){
			//character not used: mark used, move forward
			if(!usage[s.charAt(end)]){
				usage[s.charAt(end)] = true;
				end++;
			}
			//charcter used: unmark usage[start] and move start forward
			else{
				usage[s.charAt(start)] = false;
				start++;
			}
			sublen = Math.max(sublen, end-start);
		}
		return sublen;
	}
}