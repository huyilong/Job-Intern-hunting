/**
 * Problem: Implement str.indexOf(s) function
 *
 * Solution: two pointers, if a character matches first char of needle, keep comparing
 */

public class ImplementStr{
	public int strStr(String haystack, String needle){
		if(haystack==null || needle==null){
			return -1;
		}
		int needle_len = needle.length();
		int haystack_len = haystack.length();

		//some immediate cases
        if(haystack_len == 0 && needle_len==0){
            return 0;
        }else if(needle_len == 0){
        	return 0;
        }else if(haystack_len == 0){
        	return -1;
        }
		if(needle_len > haystack_len){
			return -1;
		}

		for(int i=0; i<=haystack_len-needle_len; i++){
			//if a character matches first char of needle, keep comparing
			if(haystack.charAt(i) == needle.charAt(0)){
				int temp = i+1;
				boolean found = true;
				for(int j=1; j<needle_len; j++){
					//failure
					if(haystack.charAt(temp) != needle.charAt(j)){
						j = needle_len;
						found = false;
					}else{
						temp++;
					}
				}
				if(found){
					return i;
				}
			}
		}
        return -1;
	}
}