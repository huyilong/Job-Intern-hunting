//iCIMS
//Given array, find max(min(abs(x-a[i]))) such that min(a[i])<=x<=max(a[i])


import java.util.*;
public class LargestGap{
	public static void main(String[] args){
       int[] test = new int[]{10,0,8,2,-1,12,11,3};
       int[] test2 = new int[]{1,2,4};
       System.out.println(gap(test2));
	}

	public static int gap(int[] A){
		if(A==null || A.length<=1){
			return 0;
		}
		int maxGap = 0;
		mergeSort(A,0,A.length-1);
		int len = A.length;
		for(int i=0; i<len-1; i++){
			int mid = A[i] + (A[i+1]-A[i])/2;
			maxGap = Math.max(maxGap,Math.min(Math.abs(mid-A[i]), Math.abs(mid-A[i+1])));
		}
		return maxGap;
	}

	//merge sort
	//sort on the whole list, use p=0 and r=list.length-1
	public static void mergeSort(int[] arr, int p, int r){
		if(p < r){
			int q = (int)Math.floor((p+r)/2);
			//sort two subarrays
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			//merge sorted arrays
			merge(arr, p, q, r);
		}
	}


	//merge two sorted array
	public static void merge(int[] arr, int p, int q, int r){
		int len1 = q-p+1;
		int len2 = r-q;
		//create two new arrays to store sorted array
		int[] arr1 = new int[len1+1];
		int[] arr2 = new int[len2+1];
		//fill in the new arrays
		for(int i=0; i<len1; i++){
			arr1[i] = arr[p+i];
		}
		for(int i=0; i<len2; i++){
			arr2[i] = arr[q+1+i];
		}
		//use MAX_VALUE at the last element
		arr1[len1] = Integer.MAX_VALUE;
		arr2[len2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		//merge sorted list
		for(int k=p; k<=r; k++){
			if(arr1[i] <= arr2[j]){
				arr[k] = arr1[i];
				i++;
			}else{
				arr[k] = arr2[j];
				j++;
			}
		}
	}
}