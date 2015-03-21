/**
 * Problem: Sort colors by the order red(0), white(1), and blue(2)
 *
 * Solution 1: counting sort--count number of 0,1,2 and rewrite array
 * Solution 2: two pointers--one pointing to red index, another pointing to blue index, swap elements into corresponding region
 */

public class SortColors{
	public void sortColors(int[] A){
		if(A==null || A.length==0){
			return;
		}
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
        int len = A.length;
        //counting
		for(int i=0; i<len; i++){
			switch(A[i]){
				case 0:
				  count0++;
				  break;
				case 1:
				   count1++;
				   break;
				case 2:
				   count2++;
				   break;
				default:
				   break;
			}
		}
		//rewrite array
		int index = 0;
		while(count0 != 0){
			A[index] = 0;
			index++;
		}
		while(count1 != 0){
			A[index] = 1;
			index++;
		}
		while(count2 != 0){
			A[index] = 2;
			index++;
		}
	}

	public void sortColors2(int[] A){
		if(A==null || A.length==0){
			return;
		}
		int len = A.length;
		int red = 0;
		int blue = len-1;
		int  i = 0;
		while(i<=blue){
			//move red to region
			if(A[i]==0){
				swap(A, i, red);
				red ++;
				//fall through to A[i]==2 to check current position again
			}
			//move blue to region
			if(A[i]==2){
				swap(A, i, blue);
				blue --;
				//need to check current position again
				i --; 
			}
			i++;
		}
	}

	public void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}


}