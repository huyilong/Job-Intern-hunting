//Medallia

//find number of trailing zeroes in factorial

public class FactorialTrailingZeroes{
	public int trailingZeroes(int n){
		if(n<=0){
			return 0;
		}
		int count2 = 0;
		int count5 = 0;
		int temp2,temp5;
		for(int i=n; i>=1; i--){
			temp2 = i;
			temp5 = i;
			while(temp2%2 == 0){
				temp2 = temp2/2;
				count2++;
			}
			while(temp5%5 == 0){
				temp5 = temp5/5;
				count5++;
			}
		}
		return Math.min(count2,count5);
	}
}