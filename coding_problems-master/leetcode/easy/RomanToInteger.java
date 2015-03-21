/**
 * Problem: Convert roman numeral to an integer
 *
 * Solution: follow roman numeral definition
 */
import java.util.HashMap;
public class RomanToInteger{
	public int romanToInt(String s){
		if(s == null){
			return 0;
		}
		//use hashmap to store value pair
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);

		int len = s.length();
		int result = map.get(s.charAt(len-1));
		int curr,next;
		for(int i=len-2; i>=0; i--){
			//need to check if next value if larger than current one
			curr = map.get(s.charAt(i));
			next = map.get(s.charAt(i+1));
			if(curr >= next){
				result += curr;
			}else{
				result -= curr;
			}
		}
		return result;
	}
}