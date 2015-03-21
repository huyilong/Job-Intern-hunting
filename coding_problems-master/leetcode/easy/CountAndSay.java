/**
 * Problem: Generate nth count-and-say sequence
 *
 * Solution: append result to stringbuffer if see a different element
 */

public class CountAndSay{
	public String countAndSay(int n){
		if(n<=0){
			return "";
		}
		String s = "1";
        int count = 0;
		while(n>1){
			StringBuffer buf = new StringBuffer();
			char curr = s.charAt(0);
			for(int i=0; i<s.length();i++){
				//if we see a different element, append result to stringbuffer
				if(s.charAt(i) != curr){
					buf.append(count + String.valueOf(curr));
					curr = s.charAt(i);
					count = 1;
				}else{
					count ++;
				}
			}
            //append final result
			if(count != 0){
			   buf.append(count + String.valueOf(curr));
			}

			s = buf.toString();
			count = 0;
			n--;
		}
		return s;
	}
}