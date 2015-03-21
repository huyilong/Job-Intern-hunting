/** 
 * Problem: if element is 0, its entire row and column will be 0
 *
 * Solution: boolean array to flag row and column
 */  
public class ZeroMatrix{
	public static void main(String[] args){
		int[][] test1 = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
		int[][] test2 = new int[][]{{0,2,3},{4,5,6},{7,8,9}};
		printMatrix(test1);
		zero(test1);
		printMatrix(test1);
		printMatrix(test2);
		zero(test2);
		printMatrix(test2);

	}

	public static void zero(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];
        //find zero element and flag row and column
		for(int r=0; r<m; r++){
			for(int c=0; c<n; c++){
				if(matrix[r][c] == 0){
					row[r] = true;
					col[c] = true;
				}
			}
		}
        //set row and column to be zeros
		for(int r=0; r<m; r++){
			for(int c=0; c<n; c++){
				if(row[r] || col[c]){
					matrix[r][c] = 0;
				}
			}
		}
	}



	public static void printMatrix(int[][] matrix){
		for(int[] row: matrix){
			for(int k: row){
				System.out.printf("%4d", k);
			}
			System.out.println();
		}
		System.out.println();
	}
}