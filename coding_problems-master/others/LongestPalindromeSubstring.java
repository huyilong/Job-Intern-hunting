//Medallia

//Find the longest palindromic substring.

public class LongestPalindromeSubstring{
	public static void main(String[] args){
		String test = "araaaabnd";
		System.out.println(longestPalindrome(test));

	}

	public static String longestPalindrome(String s){
		String res = "";
        int len = s.length();
        for(int i=0; i<len; i++){
        	//center is a single character
        	String p1 = palindrome(s, i, i);
        	//center is two characters
        	String p2 = palindrome(s, i, i+1);

        	if(p1.length() > res.length()){
        		res = p1;
        	}
        	if(p2.length() > res.length()){
        		res = p2;
        	}

        }
        return res;
	}

	public static String palindrome(String s, int left, int right){
         int len = s.length();
         while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
         	left--;
         	right++;
         }
         return s.substring(left+1,right);
	}
}