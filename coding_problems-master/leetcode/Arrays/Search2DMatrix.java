//search target in a sorted 2D matrix

public class Search2DMatrix{
	 public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = row-1;
        int targetRow = -1;
        
        //immediate case
        if(matrix[0][0] > target || target > matrix[row-1][col-1]){
            return false;
        }else if(target > matrix[row-1][0]){
            targetRow = row - 1;
        }
        
        
        //perform binary search on rows
        while(low <= high){
            int mid = low + (high-low)/2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        //locate the row that target might exists
        targetRow = high;
        
        //perform binary search on cols
        low = 0;
        high = col-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(matrix[targetRow][mid] == target){
                return true;
            }else if(matrix[targetRow][mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}