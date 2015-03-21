//Medallia

//Most efficient way to sort 1000 arrays of 1000 items into one huge array

import java.util.*;
public class SortArrayOfNumbers{
	public static void main(String[] args){
		List<int[]> numbers = new ArrayList<int[]>();
		numbers.add(new int[]{7,1,9,0,13});
		numbers.add(new int[]{100,91,132,136,11});
		numbers.add(new int[]{88,31,108,-9,19});
		numbers.add(new int[]{10,2,9,-98,16});
		numbers.add(new int[]{91,23,81,88,16});

		int[] res = sortArrayOfNumbers(numbers);
		for(int n: res){
			System.out.print(n +" ");
		}
	}

	public static int[] sortArrayOfNumbers(List<int[]> numbers){
		for(int[] curr: numbers){
			bucketSort(curr, curr.length);
		}
		return mergeSortedArray(numbers);
	}

	//bucket sort
	public static void bucketSort(int[] arr, int numOfBucket){
		if(numOfBucket <= 0){
			throw new IllegalArgumentException("Invalid number of buckets");
		}
		if(arr == null || arr.length==0){
			return;
		}

		int high = arr[0];
		int low = arr[0];

		//find value range
		int len = arr.length;
		for(int i=0; i<len; i++){
			low = Math.min(low, arr[i]);
			high = Math.max(high, arr[i]);
		}

		//compute interval
		double interval = (double)(high - low + 1)/numOfBucket;
        
        //create buckets
		ArrayList<Integer> buckets[] = new ArrayList[numOfBucket];
		for(int i=0; i<numOfBucket; i++){
			buckets[i] = new ArrayList<Integer>();
		}

		//put elements into buckets
		for(int i=0; i<len; i++){
			buckets[(int)((arr[i]-low)/interval)].add(arr[i]);
		}

		//sort each bucket and write to the original array
		int idx = 0;
		for(int i=0; i<numOfBucket; i++){
			Collections.sort(buckets[i]);
			int size = buckets[i].size();
			for(int j=0; j<size; j++){
				arr[idx] = buckets[i].get(j);
				idx++;
			}
		}
	}


	//merge sorted arrays
	public static int[] mergeSortedArray(List<int[]> arrays){
		if(arrays==null || arrays.size()==0){
			return null;
		}

		int k = arrays.size();
		//create priority queue with comparator on tuple
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>(k, new Comparator<Tuple>(){
			public int compare(Tuple t1, Tuple t2){
				return t1.value - t2.value;
			}
		});

		//add intial elements
		for(int i=0; i<k; i++){
			pq.offer(new Tuple(arrays.get(i)[0], i, 0));
		}

		int[] res = new int[k*arrays.get(0).length];
        
        //merge
        int idx = 0;
		while(!pq.isEmpty()){
			Tuple curr = pq.poll();
			res[idx] = curr.value;
			idx ++;
            //add next number in the sorted array
			if(curr.arrIndex+1 < arrays.get(curr.arrNumber).length){
				pq.offer(new Tuple(arrays.get(curr.arrNumber)[curr.arrIndex+1], curr.arrNumber, curr.arrIndex+1));
			}
		}

		return res;
	}

}