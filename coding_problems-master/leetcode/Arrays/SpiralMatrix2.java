//fill in numbers in a square matrix in spiral order

public class SpiralMatrix2{
	public int[][] generateMatrix(int n) {
        if(n < 0){
            return null;
        }
        int[][] matrix = new int[n][n];
        int layerNum = n/2;
        int value = 1;
        
        for(int layer=0; layer<layerNum; layer++){
            //top layer
            for(int i=layer; i<n-layer-1; i++){
                matrix[layer][i] = value++;
            }
            //right layer
            for(int i=layer; i<n-layer-1; i++){
                matrix[i][n-layer-1] = value++;
            }
            //bottom layer
            for(int i=n-layer-1; i>layer; i--){
                matrix[n-layer-1][i] = value++;
            }
            //left layer
            for(int i=n-layer-1; i>layer; i--){
                matrix[i][layer] = value++;
            }
        }
        
        //dimension is odd
        if(n%2 == 1){
            matrix[layerNum][layerNum] = value;
        }
        
        return matrix;
        
    }
}