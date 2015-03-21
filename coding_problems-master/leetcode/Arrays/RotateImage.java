//Rotate matrix clockwise by 90 degree

public class RotateImage{
	public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0){
            return;
        }
        int n = matrix.length;
        int layer = 0;
        int size = n - 1;
        
        while(size > 0){
            int margin = n - layer - 1;
            for(int i=0; i<size; i++){
                //store top
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
            size -= 2;
            layer ++;
        }
}