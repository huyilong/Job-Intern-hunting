//set entire row and column to zero if element is zero

public class SetMatrixZero{
	public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean zeroRow = false;
        boolean zeroCol = false;
        
        //check if need to zero out first row
        for(int i=0; i<col; i++){
            if(matrix[0][i] == 0){
                zeroRow = true;
                break;
            }
        }
        
        //check if need to zero out first column
        for(int i=0; i<row; i++){
            if(matrix[i][0] == 0){
                zeroCol = true;
                break;
            }
        }
        
        //traverse the rest of matrix and mark row and column number using first row and column
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j] == 0){
                    //mark column j
                    matrix[0][j] = 0;
                    //mark row i
                    matrix[i][0] = 0;
                }
            }
        }
        
        //set rows to zeros
        for(int i=1; i<row; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<col; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        //set columns to zeros
        for(int i=1; i<col; i++){
            if(matrix[0][i] == 0){
                for(int j=1; j<row; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        
        //zero first row or first column
        if(zeroRow){
            for(int i=0; i<col; i++){
                matrix[0][i] = 0;
            }
        }
        if(zeroCol){
            for(int i=0; i<row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}