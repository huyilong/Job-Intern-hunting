//plus one to the digits represented by an array

//use modulo and division, remember to consider adding extra digit

public class PlusOne{
	public int[] plusOne(int[] digits){
		if(digits==null){
			return null;
		}
		int carry = 1;
		int value = 0;
		int len = digits.length;

		for(int i=len-1; i>=0; i--){
			value = digits[i] + carry;
			carry = value/10;
			digits[i] = value % 10;
			if(carry == 0){
			    break;
			}
		}
		if(carry == 1){
			int[] res = new int[len+1];
			for(int i=1; i<len+1; i++){
				res[i] = digits[i-1];
			}
			res[0] = 1;
			return res;
		}else{
			return digits;
		}
	}
}