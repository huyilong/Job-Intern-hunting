/**
 * Problem: Convert integer to Roman
 *
 * Solution: First build mapping between integer values and Roman numerals including subtractive notations.
 *           Then use modulo operation to convert bases to Roman numerals
 */
import java.util.*;
public class IntegerToRoman{
	public String intToRoman(int num){
		if(num <= 0){
			return "";
		}
		//mappings, including subtractive notations
		int[] base = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuffer buf = new StringBuffer();
		int index = 0;
		int digit = 0;
		while(num > 0){
			digit = num/base[index];
			num = num - digit*base[index];
			//append Roman numeral
			for(int i=0; i<digit; i++){
				buf.append(roman[index]);
			}
			index++;

		}
		return buf.toString();
	}
}