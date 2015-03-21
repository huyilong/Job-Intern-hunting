/**
 * Problem: Implement power method
 *
 * Solution: Binary Search on power
 */

public class Power{
	public double pow(double x, int n){
		if(n < 0){
			return 1/powHelper(x,-n);
		}else{
			return powHelper(x,n);
		}
	}

	public double powHelper(double x, int n){
		if(n == 0){
			return 1;
		}
		double a = powHelper(x, n/2);
		if(n%2 == 0){
			return a*a;
		}else{
			return a*a*x;
		}
	}
}