
//    One simple improvement is to iterate j only up through the square root of i.
// This is because if a number j that divides i evenly, then there would be a complement m
// such that j*m=i. If j>sqrt(i), then m<sqrt(i), so we don't need to check j again since
// we have checked it with m.
//
//   Another approach is to use the fact that all non-prime numbers are divisible by a prime number.
// To generate a list of primes up to some range(1-range), we first create a boolean array with length=range+1
// Then we first flag out non-prime numbers if it is divisible by 2. Then we generate the next prime to perform
// the same test. In the end, we have flagged out all non-prime numbers, so we are left with prime numbers.
// To improve more, we can shorten the boolean array by only denoting the odd numbers up through the range because
// even numbers can never be a prime. This will save half space.
public class ListOfPrime{
	public static void main(String[] args){
		primeSimple(200);
		System.out.println();
		flagPrime(200);
	}


	//simple iterative approach
	public static void primeSimple(int range){
		if(range < 2){
			return;
		}
		for(int i=2; i<=range; i++){
			if(isPrime(i)){
				System.out.print(i + " ");
			}
		}

	}
    
    //test if a number is a prime
	public static boolean isPrime(int num){
		int sqrt = (int)Math.sqrt(num);
		//iterate only up through the square root of num
		for(int i=2; i<=sqrt; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}

    //flagging
	public static void flagPrime(int range){
		//immediate case
		if(range < 2){
			return;
		}else if(range == 2){
			System.out.print(2);
			return;
		}
		//flags all odd numbers up through the range
		boolean[] notPrime;
		if(range % 2 != 0){
            notPrime = new boolean[range/2+1];
		}else{
			notPrime = new boolean[range/2];
		}
		notPrime[0] = true;
		//reset the range to be max odd number in the range
	    range = 2*notPrime.length - 1;
        int prime = 3;

        //flag non-prime number to be true
        while(prime <= range){
        	update(notPrime, prime);
        	prime = nextPrime(notPrime,prime);
        	if(prime >= range){
        		break;
        	}
        }
        int index = 0;
        //print prime numbers up to range
        System.out.print(2 + " ");
        for(boolean flag: notPrime){
        	if(!flag){
        		System.out.print((2*index+1) + " ");
        	}     
        	index++;
        }
	}
    
    //flag non-prime number to be true
	public static void update(boolean[] notPrime, int prime){
		int len = notPrime.length;
        //only need to iterate through prime*prime to the end
		for(int i=((prime*prime)-1)/2; i<len; i=i+prime){
			notPrime[i] = true;
		}
	}
    
    //determine next prime to perform test
	public static int nextPrime(boolean[] notPrime, int prime){
		int result = prime + 2;
		int len = notPrime.length;
		//traverse to find next prime
		while((result-1)/2<len && notPrime[(result-1)/2]){
			result += 2;
		}
		return result;
	}
    
    
}