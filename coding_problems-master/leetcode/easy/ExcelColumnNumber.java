/**
 * Problem: Find column number given a column title
 *
 * Solution: base-26 calculation
 */
public class ExcelColumnNumber{
	public int titleToNumber(String s){
		if(s == null){
			return 0;
		}
		s = s.toUpperCase();
		int col = 0;
		int base = 1;
		int len = s.length();
		//update column number and base
		for(int i=len-1; i>=0; i--){
			col = col + (s.charAt(i)-'A'+1)*base;
			base = base*26;
		}
		return col;
	}
}