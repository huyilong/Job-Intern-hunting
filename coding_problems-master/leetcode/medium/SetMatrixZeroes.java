/**
 * Problem: Set entire row and column to 0 if see a 0
 *
 * Solution: Use first row and column to mark rows and columns to be set to 0, 
 *           but need to check if need to zero out first row and column first
 */

public class SetMatrixZeroes{
	public void setZeroes(int[][] matrix){
		if(matrix == null){
			return;
		}
		int row = matrix.length;
		if(row == 0){
			return;
		}
		int col = matrix[0].length;
        //determine if we need to zero out first row and column
		boolean zeroFirstRow = false;
		boolean zeroFirstColumn = false;
		for(int i=0; i<col; i++){
			if(matrix[0][i]==0){
				zeroFirstRow = true;
				break;
			}
		}
		for(int i=0; i<row; i++){
			if(matrix[i][0]==0){
				zeroFirstColumn = true;
				break;
			}
		}
        //find zero elements
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(i!=0 && j!=0 && matrix[i][j]==0){
					//flog column
					matrix[0][j] = 0;
					//flag row
					matrix[i][0] = 0;
				}
			}
		}
        //zero out rows and columns
        for(int i=1; i<row; i++){
        	for(int j=1; j<col; j++){
        		if(matrix[i][0]==0 || matrix[0][j]==0){
        			matrix[i][j] == 0;
        		}
        	}
        }
        //zero out first row and column if necessary
        if(zeroFirstColumn){
        	for(int i=0; i<row; i++){
        		matrix[i][0] = 0;
        	}
        }
        if(zeroFirstRow){
        	for(int i=0; i<col; i++){
        		matrix[0][i] = 0;
        	}
        }
	}
}