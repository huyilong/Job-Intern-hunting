/**
 * Problem: convert string in zigzag format
 *
 * Solution: step size is 2(nRows-1) for fist and last row; 
 *           step size is adjusted to minus 2i for i-th middle row
 */

public class ZigZagConversion{
	public String convert(String s, int nRows){
		int len = s.length();
		if(len <= nRows || nRows==1){
			return s;
		}
		StringBuffer buf = new StringBuffer();
		int step = 2*(nRows-1);
		for(int i=0; i<nRows; i++){
			for(int j=i; j<s.length(); j+=step){
				buf.append(s.charAt(j));

				if(i!=0 && i!=nRows-1 && j+step-2*i<len){
					buf.append(s.charAt(j+step-2*i));
				}
			}
		}
		return buf.toString();
		
	}
}