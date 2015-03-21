//find number of unique paths in an obstacle grid

public class UniquePath2{
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0]==null){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(row==0 || col==0 || obstacleGrid[0][0]==1 || obstacleGrid[row-1][col-1]==1){
            return 0;
        }
        
        int[][] way = new int[row][col];
        way[0][0] = 1;
        
        //impact of obstacle on (i,0)
        for(int i=1; i<row; i++){
            if(obstacleGrid[i][0] == 1){
                way[i][0] = 0;
            }else{
                way[i][0] = way[i-1][0];
            }
        }
        
        //impact of obstacle on (0,i)
        for(int i=1; i<col; i++){
            if(obstacleGrid[0][i] == 1){
                way[0][i] = 0;
            }else{
                way[0][i] = way[0][i-1];
            }
        }
        
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
            	//zero path to reach obstacle
                if(obstacleGrid[i][j] == 1){
                    way[i][j] = 0;
                }else{
                    way[i][j] = way[i-1][j] + way[i][j-1];
                }
            }
        }
        return way[row-1][col-1];
    }
}