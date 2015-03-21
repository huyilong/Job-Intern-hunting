/**
 * Problem: Convert column number to column title
 *
 * Solution: turn decimal into base 26
 */

public class ExcelColumnTitle{
	public String convertToTitle(int n){
		if(n<=0){
			return "";
		}
		StringBuffer buf = new StringBuffer();
		while(n > 0){
			buf.insert(0, (char)('A' + (n-1)%26));
			n = (n-1)/26;
		}
		return buf.toString();
	}
}