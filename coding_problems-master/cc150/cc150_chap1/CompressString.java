/** 
 * Problem: compress the string by using the counts of repeated characters
 *
 * Solution: simple scan
 */  
public class CompressString{
	public static void main(String[] args){
		String test = "aabcccccaaa";
        System.out.println(compress(test));
        String test2 = "aabbc";
        System.out.println(compress(test2));
	}

	public static String compress(String s){
		StringBuffer buf = new StringBuffer();
		//current character
		char c = s.charAt(0);
		//counter for current character
        int count = 0;
        //index into the string
		int i = 0;
		while(i < s.length()){
			//counting the same character
			while(i < s.length() && s.charAt(i) == c){
				count ++;
				i ++;
			}
			//append result to stringbuffer
			buf.append(c);
			buf.append(count);
			//change to next character
			if(i < s.length()){
			  c = s.charAt(i);
			  count = 1;
			  i++;
			}
		}
		//take care of single character at the end
		if(count == 1){
			buf.append(c);
			buf.append(count);
		}
		String result = buf.toString();

		//return string with shorter length
		if(s.length() <= result.length()){
			return s;
		}else{
			return result;
		}
	}
}