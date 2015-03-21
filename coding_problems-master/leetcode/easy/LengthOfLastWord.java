/**
 * Problem: Find the length of last word in the string
 *
 * Solution: split by whitespace
 */

public class LengthOfLastWord{
	public int lengthOfLastWord(String s){
		if(s==null || s.trim().length()==0){
			return 0;
		}
		s = s.trim();
		//split by whitespace
		String[] words = s.split("\\s+");
		if(words.length == 0){
			return 0;
		}else{
			return words[words.length-1].length();
		}
	}
}