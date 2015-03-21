//search word in a 2D board, only use adjacent cell

//use boolean board to mark visited, use DFS to try each possible position; 
//count length to check if terminate

public class WordSearch{
	public boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(word.length()==0){
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(findWord(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean findWord(char[][] board, String word, int idx, int i, int j){
        if(idx == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(board[i][j] != word.charAt(idx)){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        boolean result = findWord(board,word,idx+1,i+1,j) || findWord(board,word,idx+1,i-1,j) || findWord(board,word,idx+1,i,j-1) || findWord(board,word,idx+1,i,j+1);
        visited[i][j] = false;
        return result;
    }
}