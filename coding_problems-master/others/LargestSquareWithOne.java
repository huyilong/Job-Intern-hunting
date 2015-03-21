//Medillia

//find dimension of largest sub-matrix of 1's

public class LargestSquareWithOne{
	public static void main(String[] args){
		int[][] A = new int[5][];
	    A[0] = new int[] { 1, 0, 0, 1, 0 };
	    A[1] = new int[] { 0, 1, 1, 1, 1 };
	    A[2] = new int[] { 1, 1, 1, 1, 0 };
	    A[3] = new int[] { 1, 1, 1, 1, 0 };
	    A[4] = new int[] { 0, 1, 0, 1, 0 };

	    System.out.println(largestSquareDim(A));

	}

	public static int largestSquareDim(int[][] matrix){
		if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0){
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;

		int[][] dim = new int[row][col];

		//copy first row and column
		for(int i=0; i<col; i++){
			dim[0][i] = matrix[0][i];
		}
		for(int i=0; i<row; i++){
			dim[i][0] = matrix[i][0];
		}
        
        int maxDim = 0;

        //dim[i][j] tracks largest dimentions for elelement matrix[i][j] as bottom-right corner
		for(int i=1; i<row; i++){
			for(int j=1; j<col; j++){
				if(matrix[i][j] == 1){
					dim[i][j] = 1 + Math.min(dim[i-1][j-1], Math.min(dim[i-1][j], dim[i][j-1]));
					maxDim = Math.max(dim[i][j], maxDim);
				}else{
					dim[i][j] = 0;
				}
			}
		}
		return maxDim;
	}
}