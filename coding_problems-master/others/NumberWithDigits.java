//Medallia

//Given the digits 1 through k (1<=k<=9), 
//return the list of all numbers where each digit occurs at most once 

import java.util.*;
public class NumberWithDigits{
	public static void main(String[] args){
		List<Integer> res = generate(3);
		for(int n: res){
			System.out.println(n + " ");
		}

	}

	public static List<Integer> generate(int k){
		List<Integer> numbs = new ArrayList<Integer>(k);

		//add sources
		for(int i=1; i<=k; i++){
			numbs.add(i);
		}
		List<Integer> res = new ArrayList<Integer>();
		generateHelper(numbs, res, 0);
		return res;
	}

	public static void generateHelper(List<Integer> numbs, List<Integer> res, int sum){
		//find a possible number
		if(sum != 0){
			res.add(sum);
		}
		//traverse to the end
		if(numbs.size() == 0){
			return;
		}
        
        int size = numbs.size();
		for(int i=0; i<size; i++){
			int temp = numbs.remove(i);
			generateHelper(numbs, res, 10*sum + temp);
			numbs.add(i, temp);
		}

	}


}