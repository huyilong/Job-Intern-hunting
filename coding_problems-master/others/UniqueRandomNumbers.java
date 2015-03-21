//Vecna
//Generate unique random numbers

import java.util.*;
public class UniqueRandomNumbers{
	public static void main(String[] args){
		//this method ensures that we do not use the same value more than once
		//but still allows for a random order
		generate1(10,3);

	}
    
    //generate <size> numbers in the range 1-range
	public static void generate1(int range, int size){
		ArrayList<Integer> list = new ArrayList<Integer>();
		//numbers of range 1-range
		for(int i=1; i<=range; i++){
			list.add(new Integer(i));
		}
		//random order
		Collections.shuffle(list);

		System.out.println(size + " unique random numbers are: ");

		for(int i=0; i<size; i++){
			System.out.println(list.get(i));
		}
	}
}