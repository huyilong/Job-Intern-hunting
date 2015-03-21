//find number of unique paths in a 2D board(from top left to bottom right)

public class UniquePath{
	public int uniquePaths(int m, int n) {
        if(m==0 || n==0){
            return 0;
        }else if(m==1 || n==1){
            return 1;
        }
        
        int[][] way = new int[m][n];
        
        //only one way to reach way[i][0](i.e. keep going down)
        for(int i=0; i<m; i++){
            way[i][0] = 1;
        }
        
        //only one way to reach way[0][i](i.e. keep going right)
        for(int i=0; i<n; i++){
            way[0][i] = 1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                //#ways = #from up + #from left
                way[i][j] = way[i-1][j] + way[i][j-1];
            }
        }
        return way[m-1][n-1];
    }
}