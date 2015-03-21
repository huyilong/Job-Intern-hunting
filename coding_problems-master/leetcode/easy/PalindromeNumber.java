/**
 * Problem: Determine whether an integer is a palindrome without using extra space
 *
 * Solution 1: reverse and then compare, but reverse may cause overflow
 * Solution 2: use arithmetic, compare lowest/highest digit at same time
 */

public class PalindromeNumber{
	public boolean isPalindrome1(int x){
		if(x < 0){
			return false;
		}
		if(x < 10){
			return true;
		}
		int temp = x;
		int reverse = 0;
		while(temp != 0){
			reverse = reverse*10 + temp%10;
			temp = temp/10;
		}
		return reverse==x;
	}

	public boolean isPalindrome(int x){
		//negatice number cannot be palindrome
		if(x < 0){
			return false;
		}
		//one-digit number is a palindrome
		if(x < 10){
			return true;
		}

		//compute base for highest digit
		int base = 1;
		while(x/base >= 10){
			base = base*10;
		}

		int lowDigit, highDigit;
		while(x != 0){
			//get lowest and highest digits
			lowDigit = x % 10;
			highDigit = x / base;
			if(lowDigit != highDigit){
				return false;
			}
			//update x value and base
			x = (x - highDigit*base)/10;
			base = base/100;
		}
		return true;
	}
}