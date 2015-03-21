/**
 * Problem: Reverse words in a string
 *
 * Solution: Use str.split("\\s+") to split on whitespaces
 */

public class ReverseWord{
	public String reverseWords(String s){
		if(s == null){
			return "";
		}
		StringBuffer buf = new StringBuffer();
		s = s.trim();
		String[] words = s.split("\\s+");
		int len = words.length;
		for(int i=len-1; i>=1; i--){
			buf.append(words[i] + " ");
		}
		buf.append(words[0]);
		return buf.toString();
	}

}