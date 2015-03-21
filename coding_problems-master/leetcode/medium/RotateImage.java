/**
 * Problem: Rotate matrix 90 degree clockwise
 *
 * Solution: Rotate layer by layer
 */

public class RotateImage{
	public void rotate(int[][] matrix){
		if(matrix==null || matrix.length==0){
			return;
		}
		int n = matrix.length;
		if(n != matrix[0].length){
			return;
		}
        //layer
		int layer = 0;
		//side length of each layer
		int side = n-1;

		while(side > 0){
			//boundary
			int margin = n-1-layer;
			//rotate elements
			for(int i=0; i<side; i++){
				//store top element
				int temp = matrix[layer][layer+i];
				//top = left
				matrix[layer][layer+i] = matrix[margin-i][layer];
				//left = bottom
				matrix[margin-i][layer] = matrix[margin][margin-i];
				//bottom = right
				matrix[margin][margin-i] = matrix[layer+i][margin];
				//right = top
				matrix[layer+i][margin] = temp;
			}
			side = side - 2;
			layer ++;

		}
	}
}