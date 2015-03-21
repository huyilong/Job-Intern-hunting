//Medallia

//Summing up the individual digits for each number from 0 to k (0<=k<=10000000), 
//return how many times the most common sum occurs.
//Examples: k=10 gives 2 (since 1 and 10 both sum up to 1)
//k=50 gives 6 (since 5, 14, 23, 32, 41, 50 all sum up to 5) k=7777 gives 555

public class MostCommonSum{
	public static void main(String[] args){
		System.out.println(commonSum(10));
		System.out.println(commonSum(50));
		System.out.println(commonSum(7777));

	}

	public static int commonSum(int k){
		//possible digits sum are 0-63
		int[] sums = new int[64];
		//compute digit sum for numbers between 0-k
		for(int i=0; i<=k; i++){
			sums[digitSum(i)]++;
		}
		int res = 0;
		//select the most common sum
		for(int i=0; i<64; i++){
			if(sums[i] > res){
				res = sums[i];
			}
		}
		return res;
	}
    
    //compute digit sum
	public static int digitSum(int num){
		int res = 0;
		while(num > 0){
			res += num % 10;
			num = num / 10;
		}
		return res;
	}

}