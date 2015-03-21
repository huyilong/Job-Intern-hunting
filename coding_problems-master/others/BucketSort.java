//Medallia
//Bucket sort: find minimum and maximum of the range, create an array of buckets that 
//             is allocated for each value between min and max; number of each value
//             is counted by one pass and store into bucket array. 

//time O(n), n is the number of elements to be sorted
//fast when range is reasonably small

public class BucketSort{
	public static void main(String[] args){
		int[] test = new int[]{2,5,8,12,7,1,9,15,3,1,8};
		sort(test);
		for(int curr: test){
			System.out.print(curr + " ");
		}

	}

	public static void sort(int[] arr){
		if(arr==null || arr.length<=0){
			return;
		}
		int min = arr[0];
		int max = min;
		int n = arr.length;

		for(int i=1; i<n; i++){
			if(arr[i] > max){
				max = arr[i];
			}else if(arr[i] < min){
				min = arr[i];
			}
		}

		int bucket[] = new int[max-min+1];
		for(int i=0; i<n; i++){
			bucket[arr[i]-min]++;
		}

		int i = 0;
		int len = bucket.length;
		for(int j=0; j<len; j++){
			for(int k=0; k<bucket[j]; k++){
				arr[i++] = j+min;
			}
		}
	}
}