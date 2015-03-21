/** 
 * Problem: rotate N*N matrix by 90 degree, assume clockwise
 *
 * Solution: rotate by layer
 */  
public class RotateMatrix{
	public static void main(String[] args){
		int[][] test1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] test2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(test1);
		rotate(test1, 3);
		printMatrix(test1);
		printMatrix(test2);
		rotate(test2,4);
		printMatrix(test2);
	}

	public static void rotate(int[][] matrix, int n){
		int layer = 0;
		int side = n - 1;
		while(side > 0){
			//edge of the layer
			int margin = n - 1 - layer;

			for(int i=0; i<side; i++){
				//temp = top
				int temp = matrix[layer][layer+i];
				//top = left
				matrix[layer][layer+i] = matrix[margin - i][layer];
				//left = bottom
				matrix[margin - i][layer] = matrix[margin][margin - i];
				//bottom = right
				matrix[margin][margin - i]= matrix[layer + i][margin];
				//right = temp
				matrix[layer + i][margin] = temp;
			}
			//go to next layer
			layer ++;
			side -= 2;
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