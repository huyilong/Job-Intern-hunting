//bubble sort

public class BubbleSort{
	public static void main(String[] args){
		int[] test = new int[]{7,5,2,4,3,9};
		bubbleSort(test);
		for(int curr: test){
			System.out.print(curr + " ");
		}

	}

	public static void bubbleSort(int[] arr){
		if(arr==null || arr.length<=1){
			return;
		}

		int len = arr.length;

		for(int i=len-1; i>=0; i--){
			//move largest element to the end of array
			for(int j=1; j<=i; j++){
				if(arr[j-1] > arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}