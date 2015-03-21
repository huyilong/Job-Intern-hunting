//Medallia

//Given an integer k (1<=k<=2000000000), find two prime that sum up to it and return the lower number. 
//If there are multiple solutions, always return the lowest prime. If there are no solutions, return -1.
//Examples: k=12 gives 5 (5 + 7 = 12) k=68 gives 7 (7 + 61 = 68) k=77 gives -1 

public class TargetPrimeSum{
	public static void main(String[] args){
		System.out.println(primeSum(12));
		System.out.println(primeSum(68));
		System.out.println(primeSum(77));
	}

	public static int primeSum(int k){
		int front = 0;
		int end = k;

		while(front <= end){
			//find a smaller prime number
			while(front <=  end){
				if(isPrime(front)){
					break;
				}else{
					front ++;
				}
			}

			//find a larger prime number
			while(front <= end){
				if(isPrime(end)){
					break;
				}else{
					end --;
				}
			}

			//test sum
			if(front <= end){
				int sum = front + end;
				if(sum == k){
					return front;
				}else if(sum < k){
					front ++;
				}else{
					end --;
				}
			}
		}
		return -1;
	}

	public static boolean isPrime(int num){
		if(num < 2){
			return false;
		}
		int sqrt = (int)Math.sqrt(num);
		for(int i=2; i<=sqrt; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;

	}
}