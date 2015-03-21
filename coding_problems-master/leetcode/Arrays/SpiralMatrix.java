//return all elements in a matrix in spiral order

public class SpiralMatrix{
	 public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0 || matrix[0]==null || matrix[0].length==0){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //compute number of layers
        int layerNum = Math.min(row,col)/2;
        
        for(int layer=0; layer<layerNum; layer++){
            //top layer
            for(int i=layer; i<col-layer-1; i++){
                res.add(matrix[layer][i]);
            }
            //right layer
            for(int i=layer; i<row-layer-1; i++){
                res.add(matrix[i][col-layer-1]);
            }
            //bottom layer
            for(int i=col-layer-1; i>layer; i--){
                res.add(matrix[row-layer-1][i]);
            }
            //left layer
            for(int i=row-layer-1; i>layer; i--){
                res.add(matrix[i][layer]);
            }
        }
        
        //add rest of numbers when smaller dimension is odd
        if(Math.min(row,col)%2==1){
            //rest of numbers are in a horizontal line
            if(row < col){
                for(int i=layerNum; i<col-layerNum; i++){
                    res.add(matrix[layerNum][i]);
                }
            }else{
                //rest of numbers are in a vertical line
                for(int i=layerNum; i<row-layerNum; i++){
                    res.add(matrix[i][layerNum]);
                }
            }
        }
        return res;
    }
}