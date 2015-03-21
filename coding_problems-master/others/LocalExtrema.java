//iCIMS
//find number of local extrema in an array
//local minima: arr[p-1]>arr[p]=...=arr[q]<arr[q+1]
//local maxima: arr[p-1]<arr[p]=...=arr[q]>arr[q+1]

public class LocalExtrema{
	public static void main(String[] args){
		int[] test = new int[]{2,2,3,4,3,3,2,2,1,1,2,5};
		int[] test2 = new int[]{6,2};
		System.out.println(numExtrema(test2));

	}

	public static int numExtrema(int[] arr){
		if(arr==null || arr.length<=1){
			return 0;
		}
		int count = 0;
		int p = 0;
		int q = 0;
		int left = 0;
		int right = 0;
		int i = 1;
		int len = arr.length;
		while(i < len){
			left = arr[i-1];
			while(i+1<len && arr[i] == arr[i+1]){
				i++;
			}
			if(i+1 >= len){
				break;
			}
			right = arr[i+1];
			if(arr[i]>=left&&arr[i]>=right || arr[i]<=left&&arr[i]<=right){
				count ++;
			}
			i++;
		}
		count = count + 1;
		if(arr[0]!=arr[1]){
			count ++;
		}
		return count;
	}
}