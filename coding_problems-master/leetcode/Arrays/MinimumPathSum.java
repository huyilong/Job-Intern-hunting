//find minimum path sum from top left to bottom right

public class MinimumPathSum{
	//use 2d array
	public int minPathSum(int[][] grid) {
        if(grid==null || grid[0]==null){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] min = new int[row][col];
        min[0][0] = grid[0][0];
        
        //fill in first row
        for(int i=1; i<col; i++){
            min[0][i] = min[0][i-1] + grid[0][i];
        }
        
        //fill in first column
        for(int i=1; i<row; i++){
            min[i][0] = min[i-1][0] + grid[i][0];
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                min[i][j] = Math.min(min[i-1][j],min[i][j-1]) + grid[i][j];
            }
        }   
        return min[row-1][col-1];
    }
     
     //use 1d array
     public int minPathSum(int[][] grid) {
        if(grid==null || grid[0]==null){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        
        int[] min = new int[col];
        min[0] = grid[0][0];
        
        //min array contains min path sum of first row
        for(int i=1; i<col; i++){
            min[i] = min[i-1] + grid[0][i];
        }
        
        for(int i=1; i<row; i++){
        	//go to next row
            min[0] = min[0] + grid[i][0];
            for(int j=1; j<col; j++){
                min[j] = Math.min(min[j],min[j-1]) + grid[i][j];
            }
        }
        
        return min[col-1];
    }

}