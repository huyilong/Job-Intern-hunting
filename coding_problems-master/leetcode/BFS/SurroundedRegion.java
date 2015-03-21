//Surrounded Region

public class SurroundedRegion{
	public void solve(char[][] board) {
        if(board==null || board.length<=1 || board[0]==null || board[0].length<=1){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        
        //scan first and last row
        for(int i=0; i<col; i++){
            scan(board, 0, i, row, col);
            scan(board, row-1, i, row, col);
        }
        
        //scan first and last column
        for(int i=0; i<row; i++){
            scan(board, i, 0, row, col);
            scan(board, i, col-1, row, col);
        }
        
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                //left over spots marked with O should be marked as X
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                //reset '#' to 'O'
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void scan(char[][] board, int i, int j, int row, int col){
        if(board[i][j] != 'O'){
            return;
        }
        //mark all spots with # if connected to boundary
        board[i][j] = '#';
        Queue<Integer> q = new LinkedList<Integer>();
        //use code to store position info
        q.offer(getCode(i,j,col));
        //perform BFS
        while(!q.isEmpty()){
            int code = q.poll();
            //retrieve position information
            int rowIdx = code / col;
            int colIdx = code % col;
            
            //top
            if(rowIdx>=1 && board[rowIdx-1][colIdx]=='O'){
                board[rowIdx-1][colIdx] = '#';
                q.offer(getCode(rowIdx-1, colIdx, col));
            }
            //bottom
            if(rowIdx+1<row && board[rowIdx+1][colIdx]=='O'){
                board[rowIdx+1][colIdx] = '#';
                q.offer(getCode(rowIdx+1, colIdx, col));
            }
            //left
            if(colIdx>=1 && board[rowIdx][colIdx-1]=='O'){
                board[rowIdx][colIdx-1] = '#';
                q.offer(getCode(rowIdx, colIdx-1, col));
            }
            //right
            if(colIdx+1<col && board[rowIdx][colIdx+1]=='O'){
                board[rowIdx][colIdx+1] = '#';
                q.offer(getCode(rowIdx, colIdx+1, col));
            }
        }
    }
    
    public int getCode(int i, int j, int temp){
        return i*temp + j;
    }
}