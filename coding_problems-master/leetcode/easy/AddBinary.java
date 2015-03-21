/**
 * Problem: Compute the sum of two binary strings
 *
 * Solution: modulo operation and stringbuffer
 */

public class AddBinary{
	public String addBinary(String a, String b){
		//immediate cases
		if(a==null && b==null){
			return null;
		}else if(a==null){
			return b;
		}else if(b==null){
			return a;
		}

		StringBuffer buf = new StringBuffer();
		int s1 = a.length()-1;
		int s2 = b.length()-1;
		int carryon = 0;
		int val = 0;
        
        //add part with common length
		while(s1>=0 && s2>=0){
			val = a.charAt(s1)-'0' + b.charAt(s2)-'0' + carryon;
			carryon = val/2;
			buf.insert(0,val%2);
			s1--;
			s2--;
		}

		//add rest of the string
		while(s1>=0){
			val = a.charAt(s1)-'0' + carryon;
			carryon = val/2;
			buf.insert(0,val%2);
			s1--;
		}
		while(s2>=0){
			val = b.charAt(s2)-'0' + carryon;
			carryon = val/2;
			buf.insert(0,val%2);
			s2--;
		}

        //append another bit if necessary
		if(carryon==1){
			buf.insert(0,1);
		}
		return buf.toString();
	}

}