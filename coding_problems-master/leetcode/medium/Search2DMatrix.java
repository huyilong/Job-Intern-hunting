/**
 * Problem: Search for a value in matrix
 *
 * Solution: Do binary search first on rows and then on columns of selected row
 */

public class Search2DMatrix{
	public boolean searchMatrix(int[][] matrix, int target){
		if(matrix == null){
			return false;
		}
		int row = matrix.length;
		if(row == 0){
			return false;
		}
		int col = matrix[0].length;
        
        //do binary search on rows
        if(target<matrix[0][0]){
        	return false;
        }
		int low = 0;
		int high = row-1;
		int targetRow = -1;
		while(low <= high){
			int mid = (low+high)/2;
			if(matrix[mid][0] > target){
				high = mid - 1;
			}else if(matrix[mid][0] < target){
				targetRow = mid;
				low = mid + 1;
			}else{
				return true;
			}
		}

		//do binary sesarch on columns
		low = 0;
		high = col-1;
		while(low <= high){
			int mid = (low+high)/2;
			if(matrix[targetRow][mid] > target){
				high = mid - 1;
			}else if(matrix[targetRow][mid] < target){
				low = mid + 1;
			}else{
				return true;
			}
		}
        return false;
	}


}