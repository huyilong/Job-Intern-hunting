/** 
 * Problem: check if a string has unique character
 *
 * Solution 1: use ASCII table
 * Solution 2: bit manipulation
 */  
public class UniqueCharacter{
	public static void main(String[] args){
		String[] test = new String[]{"abcde","apple","hello","cat"};
		for(String s: test){
			System.out.println(s + ": " + hasUniqueChar2(s));
		}

	}
    
    //use ASCII table
	public static boolean hasUniqueChar1(String s){
		//immedicate case
		if(s.length() > 128){
			return false;
		}
		boolean[] chars = new boolean[128];
		for(int i=0; i<s.length(); i++){
			//duplicate character found
			if(chars[s.charAt(i)]){
				return false;
			}
			chars[s.charAt(i)] = true;
		}
		return true;
	}

	//use bit manipulation
	public static boolean hasUniqueChar2(String s){
		//each bit for each character
		int mask = 0;
		int len = s.length();
		int val;
		for(int i=0; i<len; i++){
			val = s.charAt(i) - 'a';
			//check corresponding bit
			if((mask & (1<<val)) > 0){
				return false;
			}
			//set bit if it's the first time visited
			mask = mask | 1<<val;
		}
		return true;
	}
}