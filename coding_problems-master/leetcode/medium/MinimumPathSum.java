/**
 * Problem: Find a mim sum path from top left to bottom right
 *
 * Solution:
 */

public class MinimumPathSum{
	public int minPathSum(int[][] grid){
		if(grid == null){
			return -1;
		}
		int row = grid.length;
		if(row == 0){
			return -1;
		}
		int col = grid[0].length;

		int x = 0;
		int y = 0;
		int val = Integer.MAX_VALUE;
		int sum = 0;

		while(x!=col-1 && y!=row-1){
			


		}

	}
}