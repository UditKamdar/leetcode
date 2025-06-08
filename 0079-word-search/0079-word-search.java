class Solution {
    int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        
       boolean[][] visited = new boolean[board.length][board[0].length]; 
        for(int i =0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){  
                if(board[i][j] == word.charAt(0)){      
                    if(dfs(board,i,j,0,visited,word)) return true;
    //              if(dfs(board,i,j,0,word)) return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int row, int column,int charCount,boolean[][] visited,  String word){
        if(charCount == word.length()) return true;
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column] || word.charAt(charCount) != board[row][column] ) return false;

        visited[row][column] = true;
     //  char temp = board[row][column];      // save original char
    //    board[row][column] = '#'; 
        for(int[] dir : directions){
            if(dfs(board,row+dir[0],dir[1]+column,charCount + 1,visited ,  word)){
    //            board[row][column] = temp;
                return true;
            } 
        }
    //    board[row][column] = temp;
       visited[row][column] = false;

        return false;
    }
}