/**
 * Problem: Find all possible letter combinations given the digits
 *
 * Solution: Add origin, generate combinations, then remove origin to prepare for next element
 */

import java.util.*;
public class LetterPhoneNumber{
	public ArrayList<String> letterCombinations(String digits){
		//store digit-letter mappings
		Map<Character,char[]> map = new HashMap<Character,char[]>();
		map.put('0',new char[]{});
		map.put('1',new char[]{});
		map.put('2',new char[]{'a','b','c'});
		map.put('3',new char[]{'d','e','f'});
		map.put('4',new char[]{'g','h','i'});
		map.put('5',new char[]{'j','k','l'});
		map.put('6',new char[]{'m','n','o'});
		map.put('7',new char[]{'p','q','r','s'});
		map.put('8',new char[]{'t','u','v'});
		map.put('9',new char[]{'w','x','y','z'});

		ArrayList<String> result = new ArrayList<String>();
		StringBuffer buf = new StringBuffer();
		letterHelper(map,result,buf,digits);
		return result;

	}

	public void letterHelper(Map<Character,char[]> map, ArrayList<String> result, StringBuffer buf, String digits){
		//add result string to list
		if(buf.length() == digits.length()){
			result.add(buf.toString());
			return;
		}
		//try every letter for the digit
		for(char letter: map.get(digits.charAt(buf.length()))){
			//add origin
			buf.append(letter);
			//generate combinations
			letterHelper(map,result,buf,digits);
			//remove origin to try next one
			buf.deleteCharAt(buf.length()-1);
		}
	}
}