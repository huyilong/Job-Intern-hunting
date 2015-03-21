/** 
 * Problem: check if two strings are permutation of each other
 *
 * Solution 1: use ASCII table
 * Solution 2: sort strings and then compare
 */  
public class isPermutation{
	public static void main(String[] args){
		String[][] test = new String[][]{{"apple","paple"}, {"hello","lolhi"}, {"wwhat","thaw "}};
		for(String[] s: test){
			System.out.println(s[0] + " and " + s[1] +": " + permutation2(s[0],s[1]));
		}

	}
    
    //use ASCII character set
	public static boolean permutation1(String s1, String s2){
		//not permutation if length not equal
		if(s1.length() != s2.length()){
			return false;
		}
		int len = s1.length();
		int[] chars = new int[256];
		//count characters in s1
		for(int i=0; i<len; i++){
			chars[s1.charAt(i)] ++;
		}
		//decount characters in s2
		for(int i=0; i<len; i++){
			chars[s2.charAt(i)] --;
			//character count doesn't match if spot<0
			if(chars[s2.charAt(i)] < 0){
				return false;
			}
		}
		return true;
	}
    

    //sort and compare
	public static boolean permutation2(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		java.util.Arrays.sort(c1);
		java.util.Arrays.sort(c2);
		String str1 = new String(c1);
		String str2 = new String(c2);
		return str1.equals(str2);
	}
}