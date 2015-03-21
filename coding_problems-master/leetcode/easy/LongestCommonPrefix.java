/**
 * Problem: Find the longest common prefix string amongst an array of string
 *
 * Solution: scan each character for each string
 */

public class LongestCommonPrefix{
	public String longestCommonPrefix(String[] strs){
		if(strs==null || strs.length==0{
			return "";
		})
		int size = strs.length;
		int index = 0;
		char curr = ' ';
		boolean sameChar = true;
		StringBuffer buf = new StringBuffer();
		while(sameChar){
			//get current char
			if(strs[0]!=null && index < strs[0].length()){
				curr = strs[0].charAt(index);
			}
			//compare char with each string
			for(int k=0; k<size; k++){
				sameChar = (strs[k]!=null && index<strs[k].length() && strs[k].charAt(index)==curr);
			    if(!sameChar){
			    	break;
			    }
			}
			//append char to prefix
			if(sameChar){
			  buf.append(curr);
			  index ++;
			}
		}
		return buf.toString();
	}
}