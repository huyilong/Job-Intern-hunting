/** 
 * Problem: determine if a string is the rotation of another string
 *          use only one call of isSubstring()
 *
 * Solution: s1=xy, s2=yx, note that s2 is substring of s1s1=xyxy
 */  
public class isRotation{
	public static void main(String[] args){
		String[][] test = new String[][]{{"apple","ppl"},{"banana","anaa"}};
		for(String[] pair: test){
			System.out.println(pair[0] + " and " + pair[1] + ": " + isSubstring(pair[0],pair[1]));
		}

		String[][] test2 = new String[][]{{"waterbottle","erbottlewat"},{"waterbottle","rebottlewat"}};
		for(String[] pair: test2){
			System.out.println(pair[0] + " and " + pair[1] + ": " + rotation(pair[0],pair[1]));
		}
	}

	public static boolean rotation(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		return isSubstring(s1+s1, s2);

	}

	public static boolean isSubstring(String s1, String s2){
		char[] child;
		char[] parent;
		//store into shorter and longer char array
		if(s1.length() <= s2.length()){
			child = s1.toCharArray();
			parent = s2.toCharArray();
		}else{
			child = s2.toCharArray();
			parent = s1.toCharArray();
		}

		int offset = Math.abs(s1.length()-s2.length());
		int len = child.length;
        
		for(int i=0; i<offset; i++){
			//if first char matches, continue to check the rest
			if(parent[i] == child[0]){
				int j = i;
				int k = 0;
				while(k<child.length && parent[j] == child[k]){
					j ++;
					k ++;
				}
				if(k == child.length){
					return true;
				}
			}
		}
		return false;
	}
}