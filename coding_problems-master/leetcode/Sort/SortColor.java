//Sort Color

public class SortColor{
	public void sortColors(int[] A){
		if(A==null || A.length==0){
			return A;
		}
		int len = A.length;
		int idx = 0;
		int zeroIdx = 0;
		int twoIdx = len - 1;

		while(idx <= twoIdx){
			if(A[idx]==0 && idx>zeroIdx){
				swap(A, idx, zeroIdx);
				zeroIdx ++;
			}else if(A[idx]==2 && idx<twoIdx){
				swap(A, idx, twoIdx);
				twoIdx --;
			}else{
				idx ++;
			}
		}


	}

	public void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}