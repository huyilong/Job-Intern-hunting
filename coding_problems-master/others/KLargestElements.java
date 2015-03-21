//Medallia

//find k largest/smallest elements in an array

public class KLargestElements{
	public static void main(String[] args){
		int[] test = new int[]{7,5,2,4,3,9};
		int[] res = findKLargest(test,3);
		for(int n: res){
			System.out.println(n + " ");
		}

	}

	//use outer loop of bubble sort for k times
	//time O(nk)
	public static int[] findKLargest(int[] array, int k){
		if(array == null){
			return null;
		}
		int len = array.length;
		for(int i=len-1; i>=len-k; i--){
			for(int j=1; j<=i; j++){
				if(array[j-1] > array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}

		int[] res = new int[k];
		int idx = 0;
		for(int i=len-1; i>=len-k; i--){
			res[idx] = array[i];
			idx ++;
		}
		return res;
	}
}