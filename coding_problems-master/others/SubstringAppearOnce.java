//Medallia

//Given a string s (1<=s.length()<=1000),return the substring that is only occurring once

public class SubstringAppearOnce{
	public static void main(String[] args){
        String test = "aaaa";
        System.out.println(substringOnce(test));
	}

	//brute force
	public static String substringOnce(String s){
		if(s==null || s.length()==0){
			return s;
		}
		int len = s.length();
		for(int end=1; end<=len; end++){
			for(int offset=0; offset+end<=len; offset++){
				String temp = s.substring(offset, offset + end);
				if(freq(s,temp) == 1){
					return temp;
				}
			}
		}
		return null;
	}

	public static int freq(String s, String sub){
		int res = 0;
		int len = s.length();
		int sublen = sub.length();
		for(int i=0; i<=len-sublen; i++){
			if(s.charAt(i) == sub.charAt(0)){
				int offset = 0;
				while(s.charAt(i+offset) == sub.charAt(offset)){
					offset ++;
				}
				if(offset == sublen){
					res ++;
				}
			}
		}
		return res;
	}
}