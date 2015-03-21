/**
 * Problem: Find longest palindromic substring
 *
 * Solution: Try each possible centers and check if palindrome exists around the center
 */

public class LongestPalindromicSubstring{
	public String longestPalindrome(String s){
		if(s==null || s.length()==0){
			return "";
		}
		int len = s.length();
		//initial candidate
		String palindrome = s.substring(0,1);
		for(int i=0; i<len-1; i++){
			//center is a single letter
			String p1 = expand(s, i, i);
			if(p1.length() > palindrome.length()){
				palindrome = p1;
			}
			//center is the space between two letters
			String p2 = expand(s, i, i+1);
			if(p2.length() > palindrome.length()){
				palindrome = p2;
			}
		}
		return palindrome;
	}

	public String expand(String s, int left, int right){
		int len = s.length();
		//expand until out of bound or not palindrome
		while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
			left --;
			right ++;
		}
		return s.substring(left+1,right);
	}
}