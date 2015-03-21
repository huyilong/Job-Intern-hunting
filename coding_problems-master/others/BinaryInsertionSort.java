public class BinaryInsertionSort{
	public static void main(String[] args){
        int[] arr = new int[]{3,8,10,-1,5,1,4,2,3,5,5,-8};
        sort(arr);
        for(int n: arr){
        	System.out.print(n + " ");
        }
	}

	public static void sort(int[] arr){
		int len = arr.length;

		for(int i=1; i<len; i++){
			//find position to insert in the range 0-i
			int insertIdx = binarySearch(arr, 0, i, arr[i]);
			if(insertIdx < i){
				int temp = arr[i];
				//shift element to the right
				for(int j=i-1; j>=insertIdx; j--){
					arr[j+1] = arr[j];
				}
				arr[insertIdx] = temp;
			}
		}
	}

	public static int binarySearch(int[] arr, int left, int right, int key){
		if(left == right){
			return left;
		}
		int mid = left + (right - left)/2;

		if(arr[mid] < key){
			return binarySearch(arr, mid+1, right, key);
		}else if(arr[mid] > key){
			return binarySearch(arr, left, mid, key);
		}else{
			return mid;
		}
	}
}